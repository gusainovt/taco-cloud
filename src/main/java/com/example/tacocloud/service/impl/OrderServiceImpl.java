package com.example.tacocloud.service.impl;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.model.User;
import com.example.tacocloud.repository.OrderRepository;
import com.example.tacocloud.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Search for a taco order by its ID.
     * @param id Order ID.
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
    @Override
    public List<TacoOrder> getByUserOrderByPlacedAtDesc(User user, PageRequest pageable){
        return orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
    }
}
