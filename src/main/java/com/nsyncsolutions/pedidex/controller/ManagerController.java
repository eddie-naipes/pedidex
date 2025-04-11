package com.nsyncsolutions.pedidex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nsyncsolutions.pedidex.utils.ApiConstants.API_VERSION;
import static com.nsyncsolutions.pedidex.utils.ApiConstants.MANAGER;

@RestController
@RequestMapping(API_VERSION + MANAGER)
public class ManagerController {
}
