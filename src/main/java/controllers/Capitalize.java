package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Capitalize {

    @GetMapping("/capitalize/{text}")
    public String setCapitalize(Model model, @PathVariable String text) {
        String newText = text.toUpperCase();
        model.addAttribute("capitalizeText" , newText);
        return "capitalize.html";
    }
}
