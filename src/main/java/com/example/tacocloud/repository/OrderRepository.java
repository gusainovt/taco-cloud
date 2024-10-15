package com.example.tacocloud.repository;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
    List<TacoOrder> findByUserOrderByPlacedAtDesc (User user, PageRequest pageable);
}
