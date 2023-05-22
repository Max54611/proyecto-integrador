package com.a.ventafrutos.controller;

import com.a.ventafrutos.dto.SignupDTO;
import com.a.ventafrutos.dto.UserDTO;
import com.a.ventafrutos.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO){
       UserDTO createdUser = userService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("Usuario no creado", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser,HttpStatus.CREATED);

    }
}
