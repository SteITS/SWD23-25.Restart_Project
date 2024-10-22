package com.restart.controller;

import com.restart.dto.UserDto;
import com.restart.entity.User;
import com.restart.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import javax.validation.Valid;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Metodo per gestire la richiesta della home page
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // Metodo per reindirizzare alla home page
    @GetMapping("/")
    public String redirectToIndex() {
    return "redirect:/index";
}

    // Metodo per visualizzare il form di registrazione utente
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    //Mostra che l'autenticazione è avvenuta con successo
    @GetMapping("/success")
    public ResponseEntity<User> showSuccessMessage(){
        return ResponseEntity.ok(userService.getAuthenticatedUser());
    }

    // Metodo per visualizzare il form di registrazione utente
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/login.html";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    //Metodo per visualizzare la lista degli utenti
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "community";
    }

    // Metodo per gestire la richiesta della pagina di login
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}