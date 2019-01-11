package com.iba.festival.controller;

import com.iba.festival.domain.User;
import com.iba.festival.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
       /* if (userService.verifyPhoneNumber(user.getPhoneNumber())==false){
            model.put("message", "Invalid phone number. Example: +375/80 29/44/33/25 000 00 00");
        }*/
        if (!userService.addUser(user)) {
            model.put("festival", "User exists!");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("festival", "User successfully activated");
        } else {
            model.addAttribute("festival", "Activation code is not found!");
        }

        return "login";
    }
}
