package com.example.tacocloud.repository;

import com.example.tacocloud.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readTacoOrdersByDeliveryZipAndPlacedAtBetween(String delivetyZip, Date startDate, Date endDate);

    List<TacoOrder> findByDeliveryStreetAndDeliveryCityAllIgnoreCase(String deliveryStreet, String deliveryCity);

    List<TacoOrder> findByDeliveryCityOrderByDeliveryStreet(String city);


}
