package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.Ingredient;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.IngridientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    private IngridientRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Ingredient> ingredients = repository.findAll();
        model.addAttribute("ingredients", ingredients);
        return "ingredient/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ingredient", repository.findById(id).get());
        return "ingredient/show";
    }
}
