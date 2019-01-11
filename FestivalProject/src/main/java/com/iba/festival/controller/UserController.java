package com.iba.festival.controller;

import com.iba.festival.domain.Role;
import com.iba.festival.domain.User;
import com.iba.festival.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("speakers")
    public String getSpeaker(Model model) {
        model.addAttribute("users", userService.findAll()
                .stream()
                .map(user -> user.getRoles().equals(Role.SPEAKER))
                .collect(Collectors.toList()));

        return "speakers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phoneNumber", user.getPhoneNumber());

        return "profile";
    }


    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phoneNumber
    ) {
        userService.updateProfile(user, password, email, phoneNumber);

        return "redirect:/user/profile";
    }


    @GetMapping("goOnFest/{user}")
    public String goOnFest(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userService.goOnFest(currentUser, user);

        return "redirect:/main/" + user.getId();
    }

    @GetMapping("ungoOnFest/{user}")
    public String ungoOnFest(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user
    ) {
        userService.ungoOnFest(currentUser, user);

        return "redirect:/main/" + user.getId();
    }
}
