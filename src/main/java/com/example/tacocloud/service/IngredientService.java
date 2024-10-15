package com.example.tacocloud.service;

import com.example.tacocloud.model.Ingredient;

public interface IngredientService {
    Iterable<Ingredient> getAll();

    Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type);
}
