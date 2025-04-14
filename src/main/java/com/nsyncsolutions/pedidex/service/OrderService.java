package com.nsyncsolutions.pedidex.service;

import com.nsyncsolutions.pedidex.dto.OrderDTO;
import com.nsyncsolutions.pedidex.dto.OrderRequest;
import com.nsyncsolutions.pedidex.mapper.ClientMapper;
import com.nsyncsolutions.pedidex.mapper.OrderMapper;
import com.nsyncsolutions.pedidex.model.Order;
import com.nsyncsolutions.pedidex.model.OrderedItem;
import com.nsyncsolutions.pedidex.model.enums.StatusType;
import com.nsyncsolutions.pedidex.repository.OrderRepository;
import com.nsyncsolutions.pedidex.repository.OrderedItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderedItemRepository orderedItemRepository;
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Transactional
    public OrderDTO createOrder(OrderRequest orderRequest) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setClient(clientService.findById(orderRequest.getClientId()));
        orderDTO.setOrderedItems(orderRequest.getOrderedItems());
        orderDTO.setPaymentMethod(orderRequest.getPaymentMethod());
        orderDTO.setStatus(StatusType.PENDING);
        orderDTO.setTotalAmount(BigDecimal.ZERO);

        Order order = orderMapper.orderDTOToOrder(orderDTO);

        if (order.getOrderedItems() != null) {
            for (OrderedItem item : order.getOrderedItems()) {
                if (item.getId() == null) {
                    if (item.getProduct() != null && item.getProduct().getId() != null) {
                        orderedItemRepository.save(item);
                    }
                }
            }
        }

        BigDecimal totalAmount = calculateOrderTotal(order);
        order.setTotalAmount(totalAmount);
        order.setStatus(StatusType.PENDING);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.orderToOrderDTO(savedOrder);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::orderToOrderDTO)
                .toList();
    }

    public OrderDTO getOrderById(UUID id) {
        return orderRepository.findById(id)
                .map(orderMapper::orderToOrderDTO)
                .orElse(null);
    }

    @Transactional
    public OrderDTO updateOrder(UUID id, OrderDTO orderDTO) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    Order order = orderMapper.orderDTOToOrder(orderDTO);
                    order.setId(id);
                    BigDecimal totalAmount = calculateOrderTotal(order);
                    order.setTotalAmount(totalAmount);
                    Order savedOrder = orderRepository.save(order);
                    return orderMapper.orderToOrderDTO(savedOrder);
                })
                .orElse(null);
    }

    @Transactional
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    private BigDecimal calculateOrderTotal(Order order) {
        return order.getOrderedItems().stream()
                .map(this::calculateItemTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateItemTotal(OrderedItem item) {
        return item.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity()));
    }
}