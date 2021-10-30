package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Welcome {

    @GetMapping("/")
    public String welcoming(Model model) {
        model.addAttribute("welcome","WELCOME TO SONGR APP" );
        return "welcome.html";
    }
}
