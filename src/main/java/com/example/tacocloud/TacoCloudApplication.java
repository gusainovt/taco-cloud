package com.example.tacocloud;

import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.save(new Ingredient(1L,"Flour Tortilla", Type.WRAP));
			repo.save(new Ingredient(2L, "Corn Tortilla", Type.WRAP));
			repo.save(new Ingredient(3L, "Ground Beef", Type.PROTEIN));
			repo.save(new Ingredient(4L, "Carnitas", Type.PROTEIN));
			repo.save(new Ingredient(5L, "Diced Tomatoes", Type.VEGGIES));
			repo.save(new Ingredient(6L, "Lettuce", Type.VEGGIES));
			repo.save(new Ingredient(7L, "Cheddar", Type.CHEESE));
			repo.save(new Ingredient(8L, "Monterrey Jack", Type.CHEESE));
			repo.save(new Ingredient(9L, "Salsa", Type.SAUCE));
			repo.save(new Ingredient(10L, "Sour Cream", Type.SAUCE));
		};
	}

}
