package com.example.demo.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Entity
//@AllArgsConstructor
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;


//    public Ingredient(String id, String name, String type) {
//        this.id = id;
//        this.name = name;
//        this.type = Ingredient.Type.valueOf(type);
//    }

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}