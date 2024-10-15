package com.example.tacocloud.controller;

import com.example.tacocloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {
        orderService.deleteAllOrders();
        return "redirect:/admin";
    }
}
