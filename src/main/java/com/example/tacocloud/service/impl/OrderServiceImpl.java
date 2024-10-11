package com.example.tacocloud.service.impl;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repository.OrderRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements com.example.tacocloud.service.OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Search for a taco order by its ID.
     * @param id Search for a taco order by its ID.
     * @return {@link TacoOrder}
     */
    @Override
    @PostAuthorize("hasRole('ADMIN') || returnObject.user.username == authentication.name")
    public TacoOrder getTacoOrder(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    /**
     * Creates a new taco order
     * @param order {@link TacoOrder}
     * @return {@link TacoOrder}
     */
    @Override
    public TacoOrder createTacoOrder(TacoOrder order) {
        return orderRepository.save(order);
    }

    /**
     * The method deletes all orders.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

}
