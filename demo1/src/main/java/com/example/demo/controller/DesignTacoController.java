package com.example.demo.controller;

import com.example.demo.beans.Ingredient;
import com.example.demo.beans.Ingredient.Type;
import com.example.demo.beans.Order;
import com.example.demo.beans.Taco;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.TacoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private TacoRepository tacoRepository;
    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }


    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredient -> ingredients.add(ingredient));
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        System.out.println("askdjhakshdajsd");
        return "design";
    }
    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    /**
     * Version1
     */
//    @PostMapping
//    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors){
//        if (errors.hasErrors()) {
//
//            return "design";
//        }
//        log.info("Process design: "+design);
//        return "redirect:/orders/current";
//    }
    @PostMapping
    public String processDesign(
            @Valid Taco design, Errors errors,
            @ModelAttribute Order order) {
        System.out.println(design);
        if (errors.hasErrors()) {
            return "design";
        }

        System.out.println(design);
        Taco saved = tacoRepository.save(design);
        System.out.println(saved);
        order.addDesign(saved);
        System.out.println(order);
        return "redirect:/orders/current";
    }

//    @PostMapping
//    public String processDesign(Map<String,Object> reqMap) {
////
////        if (errors.hasErrors()) {
////            return "design";
////        }
////
////        Taco saved = tacoRepository.save(design);
////        order.addDesign(saved);
//        Iterator<Map.Entry<String, Object>> iterator = reqMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, Object> e = iterator.next();
//            System.out.print(e.getKey());
//            System.out.print(',');
//            System.out.println(e.getValue());
//        }
//        return "redirect:/orders/current";
//    }
}
