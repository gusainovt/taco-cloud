package com.example.tacocloud.service.impl;

import com.example.tacocloud.model.Taco;
import com.example.tacocloud.repository.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TacoServiceImpl implements com.example.tacocloud.service.TacoService {

    private final TacoRepository tacoRepository;


    public TacoServiceImpl(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    /**
     * Find all the tacos
     * @return list of the tacos
     */
    @Override
    public Iterable<Taco> getAll(PageRequest pageRequest) {
        return tacoRepository.findAll(pageRequest).getContent();
    }

    /**
     * Find the taco by id
     * @param id The taco ID
     * @return {@link Optional<Taco>}
     */
    @Override
    public Optional<Taco> getTacoById(Long id) {
        return tacoRepository.findById(id);
    }

    /**
     * Created new taco
     * @param taco {@link Taco}
     * @return {@link Taco}
     */
    @Override
    public Taco createTaco(Taco taco) {
        return tacoRepository.save(taco);
    }
}
