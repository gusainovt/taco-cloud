package com.example.tacocloud.service.impl;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IngredientServiceImpl implements com.example.tacocloud.service.IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    /**
     * Get all the ingredients
     * @return List of ingredients
     */
    @Override
    public Iterable<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    /**
     * Filters the list of ingredients by type
     * @param ingredients List of ingredients
     * @param type Type of ingredient {@link com.example.tacocloud.model.Ingredient.Type}
     * @return Filtered list of ingredients
     */
    @Override
    public Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type) {
        return StreamSupport
                .stream(ingredients.spliterator(),false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
