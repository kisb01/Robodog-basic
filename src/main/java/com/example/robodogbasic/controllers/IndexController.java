package com.example.robodogbasic.controllers;

import com.example.robodogbasic.services.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    public DogStorage dogStorage;

    @Autowired
    public IndexController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("allDogs", dogStorage.allDogs());
        return "index";
    }

}
