package com.example.tacocloud.service;

import com.example.tacocloud.model.TacoOrder;

public interface OrderService {
    TacoOrder getTacoOrder(Long id);

    TacoOrder createTacoOrder(TacoOrder order);

    void deleteAllOrders();
}
