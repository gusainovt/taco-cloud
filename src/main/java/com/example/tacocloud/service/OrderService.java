package com.example.tacocloud.service;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.model.User;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface OrderService {
    TacoOrder getTacoOrder(Long id);

    TacoOrder createTacoOrder(TacoOrder order);

    void deleteAllOrders();
    List<TacoOrder> getByUserOrderByPlacedAtDesc (User user, PageRequest pageable);
}
