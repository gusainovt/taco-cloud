package com.example.tacocloud.repository;

import com.example.tacocloud.model.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco,Long> {
}
