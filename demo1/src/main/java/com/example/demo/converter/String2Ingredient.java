package com.example.demo.converter;

import com.example.demo.beans.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class String2Ingredient implements Converter<String[], List<Ingredient>> {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> convert(String[] source) {
        List<Ingredient> list = new ArrayList<>();
        for(String s:source){
            Ingredient e = ingredientRepository.findById(s).get();
            list.add(e);
        }
        return list;
    }
}
