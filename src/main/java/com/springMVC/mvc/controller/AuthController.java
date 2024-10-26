package com.springMVC.mvc.controller;

import com.springMVC.mvc.dto.RegistrationDTO;
import com.springMVC.mvc.models.UserEntity;
import com.springMVC.mvc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDTO user = new RegistrationDTO();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDTO user,
                           BindingResult result,
                           Model model) {
        UserEntity existingUsersEmail = userService.findByEmail(user.getEmail());
        if (existingUsersEmail != null
                && existingUsersEmail.getEmail() != null
                && !existingUsersEmail.getEmail().isEmpty()) {
            result.rejectValue("email", "User exists with the email/username");
        }

        UserEntity existingUsername = userService.findByUsername(user.getUsername());
        if (existingUsername != null
                && existingUsername.getUsername() != null
                && !existingUsername.getUsername().isEmpty()) {
            result.rejectValue("user", "User exists with the email/username");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }
}
