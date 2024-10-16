package com.example.tacocloud.controller;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoOrderController {

    private final OrderService orderService;

    public TacoOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId,
                              @RequestBody TacoOrder tacoOrder) {
        return orderService.updateTacoOrder(orderId, tacoOrder);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId,
                                @RequestBody TacoOrder patch) {
        return orderService.patchTacoOrder(orderId, patch);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long id) {
        orderService.deleteTacoOrder(id);
    }
}
