package org.lessons.java.spring_la_mia_pizzeria_crud.controller;

import org.lessons.java.spring_la_mia_pizzeria_crud.model.SpecialOffer;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.OfferRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private OfferRepository repository;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("offers") SpecialOffer formOffer, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "offers/create";
        }

        repository.save(formOffer);

        return "redirect:/pizze";
    }
}
