package com.example.tacocloud.controller;

import com.example.tacocloud.config.OrderProps;
import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.model.User;
import com.example.tacocloud.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderService orderService;

    private final OrderProps props;

    @Autowired
    public OrderController(OrderService orderService, OrderProps props) {
        this.orderService = orderService;
        this.props = props;
    }
    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {

        PageRequest pageable = PageRequest.of(0, props.getPageSize());
        model.addAttribute("orders",
                orderService.getByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);
        orderService.createTacoOrder(order);
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
