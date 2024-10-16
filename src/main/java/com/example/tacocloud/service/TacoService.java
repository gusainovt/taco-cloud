package com.example.tacocloud.service;

import com.example.tacocloud.model.Taco;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface TacoService {
    Iterable<Taco> getAll(PageRequest pageRequest);

    Optional<Taco> getTacoById(Long id);

    Taco createTaco(Taco taco);
}
