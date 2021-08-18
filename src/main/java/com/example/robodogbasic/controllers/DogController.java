package com.example.robodogbasic.controllers;

import com.example.robodogbasic.commands.DogCommand;
import com.example.robodogbasic.converters.BreedToEnum;
import com.example.robodogbasic.converters.DogCommandToDog;
import com.example.robodogbasic.models.Breed;
import com.example.robodogbasic.services.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DogController {
    private DogStorage dogStorage;

    @Autowired
    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }

    @GetMapping({"/generate"})
    public String generateDog() {
        dogStorage.addRandomDog();
        return "redirect:/index";
    }

    @GetMapping("/newdog")
    public String newDog(Model model) {
        model.addAttribute("dog", new DogCommand());
        model.addAttribute("breeds", Breed.values());
        return "dogform";
    }

    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute DogCommand dogCommand, @RequestParam String action) {
        if (action.equals("Create")) {
            this.dogStorage.addDog(new DogCommandToDog().convert(dogCommand));
        }
        if (action.equals("Update")) {
            this.dogStorage.updateDog(dogCommand.getName(), dogCommand.getAge(), new BreedToEnum().convert(dogCommand.getBreed()));
        }
        return "redirect:/index";
    }
}
