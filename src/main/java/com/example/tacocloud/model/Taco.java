package com.example.tacocloud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "tacos")
@RestResource(rel = "tacos",path = "tacos")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name must be least 5 characters long")
    private String name;

    @Column(name = "create_at")
    private Timestamp createAt;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
