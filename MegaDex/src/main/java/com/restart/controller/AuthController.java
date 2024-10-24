package com.restart.controller;

import com.restart.dto.UserDto;
import com.restart.entity.User;
import com.restart.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //Mostra che l'autenticazione è avvenuta con successo
    @GetMapping("/success")
    public ResponseEntity<User> showSuccessMessage(){
        return ResponseEntity.ok(userService.getAuthenticatedUser());
    }

    // Metodo per visualizzare il form di registrazione utente
    @PostMapping("/register/save")
    public ResponseEntity<UserDto> registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if(!userService.checkEmail(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED) // 304
                .body(userDto);
        }
        if(!userService.checkPassword(userDto.getPassword())){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE) // 406
                    .body(userDto);
        }
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
            return ResponseEntity.status(HttpStatus.CONFLICT) // 409
                    .body(userDto);
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return ResponseEntity.internalServerError().body(userDto);
        }
        userService.saveUser(userDto);
        return ResponseEntity.ok(userDto);
    }
}