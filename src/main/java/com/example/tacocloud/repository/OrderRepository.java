package com.example.tacocloud.repository;

import com.example.tacocloud.model.TacoOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends MongoRepository<TacoOrder, String> {

}
