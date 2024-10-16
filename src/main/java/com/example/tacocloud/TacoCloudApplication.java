package com.example.tacocloud;

import com.example.tacocloud.model.Ingredient.Type;
import com.example.tacocloud.model.Ingredient;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.repository.IngredientRepository;
import com.example.tacocloud.repository.TacoRepository;
import com.example.tacocloud.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(
			IngredientRepository repo,
			UserRepository userRepo,
			PasswordEncoder encoder,
			TacoRepository tacoRepo) {
		return args -> {
			Ingredient flourTortilla = repo.findById(1L).orElseThrow();
			Ingredient cornTortilla = repo.findById(2L).orElseThrow();
			Ingredient groundBeef = repo.findById(3L).orElseThrow();
			Ingredient carnitas = repo.findById(4L).orElseThrow();
			Ingredient tomatoes = repo.findById(5L).orElseThrow();
			Ingredient lettuce = repo.findById(6L).orElseThrow();
			Ingredient cheddar = repo.findById(7L).orElseThrow();
			Ingredient jack = repo.findById(8L).orElseThrow();
			Ingredient salsa = repo.findById(9L).orElseThrow();
			Ingredient sourCream =repo.findById(10L).orElseThrow();
			repo.save(flourTortilla);
			repo.save(cornTortilla);
			repo.save(groundBeef);
			repo.save(carnitas);
			repo.save(tomatoes);
			repo.save(lettuce);
			repo.save(cheddar);
			repo.save(jack);
			repo.save(salsa);
			repo.save(sourCream);
			Taco taco1 = new Taco();
			taco1.setName("Carnivore");
			taco1.setIngredients(Arrays.asList(
					flourTortilla, groundBeef, carnitas,
					sourCream, salsa, cheddar));
			taco1.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));
			tacoRepo.save(taco1);
			Taco taco2 = new Taco();
			taco2.setName("Bovine Bounty");
			taco2.setIngredients(Arrays.asList(
					cornTortilla, groundBeef, cheddar,
					jack, sourCream));
			taco2.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));
			tacoRepo.save(taco2);
			Taco taco3 = new Taco();
			taco3.setName("Veg-Out");
			taco3.setIngredients(Arrays.asList(
					flourTortilla, cornTortilla, tomatoes,
					lettuce, salsa));
			taco3.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));
			tacoRepo.save(taco3);
		};
	}

}
