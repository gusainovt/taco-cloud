package com.example.tacocloud.service.impl;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.model.User;
import com.example.tacocloud.repository.OrderRepository;
import com.example.tacocloud.service.OrderService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

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


    /**
     * Find the taco orders by user placed at and sorted DESC
     * @param user {@link User}
     * @param pageable {@link PageRequest}
     * @return list of {@link TacoOrder}
     */
    @Override
    public List<TacoOrder> getByUserOrderByPlacedAtDesc(User user, PageRequest pageable){
        return orderRepository.findByUserOrderByPlacedAtDesc(user, pageable);
    }

    /**
     * Updates the taco order by ID
     * @param orderId The taco order ID
     * @param order {@link TacoOrder}
     * @return {@link TacoOrder}
     */
    @Override
    public TacoOrder updateTacoOrder(Long orderId, TacoOrder order) {
        order.setId(orderId);
        return orderRepository.save(order);
    }

    /**
     * Updates the taco order based on the specified parameters
     * @param orderId The taco order ID
     * @param patch {@link TacoOrder}
     * @return {@link TacoOrder}
     */
    @Override
    public TacoOrder patchTacoOrder(Long orderId, TacoOrder patch) {
        TacoOrder order = orderRepository.findById(orderId).orElseThrow();
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if (patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }
        return orderRepository.save(order);
    }

    /**
     * Deletes the taco order by ID
     * @param orderId The taco order ID
     */
    @Override
    public void deleteTacoOrder(Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }
}
