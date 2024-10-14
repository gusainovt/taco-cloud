package com.example.tacocloud.converter;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<Long, Ingredient> {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

//    @Bean
//    public CommandLineRunner dataLoader(IngredientRepository repo) {
//        return args -> {
//            repo.save(new Ingredient(1L,"Flour Tortilla", Ingredient.Type.WRAP));
//            repo.save(new Ingredient(2L, "Corn Tortilla", Ingredient.Type.WRAP));
//            repo.save(new Ingredient(3L, "Ground Beef", Ingredient.Type.PROTEIN));
//            repo.save(new Ingredient(4L, "Carnitas", Ingredient.Type.PROTEIN));
//            repo.save(new Ingredient(5L, "Diced Tomatoes", Ingredient.Type.VEGGIES));
//            repo.save(new Ingredient(6L, "Lettuce", Ingredient.Type.VEGGIES));
//            repo.save(new Ingredient(7L, "Cheddar", Ingredient.Type.CHEESE));
//            repo.save(new Ingredient(8L, "Monterrey Jack", Ingredient.Type.CHEESE));
//            repo.save(new Ingredient(9L, "Salsa", Ingredient.Type.SAUCE));
//            repo.save(new Ingredient(10L, "Sour Cream", Ingredient.Type.SAUCE));
//        };
//    }

    @Override
    public Ingredient convert(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public <U> Converter<Long, U> andThen(Converter<? super Ingredient, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
