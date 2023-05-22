package com.a.ventafrutos.controller;

import com.a.ventafrutos.dto.AuthenticationRequest;
import com.a.ventafrutos.dto.AuthenticationResponse;
import com.a.ventafrutos.entities.User;
import com.a.ventafrutos.repository.UserRepository;
import com.a.ventafrutos.service.user.UserService;
import com.a.ventafrutos.utils.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws BadCredentialsException,DisabledException, UsernameNotFoundException,IOException, JSONException, ServletException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCorreo(),authenticationRequest.getContra()));
        }catch(BadCredentialsException e){
            throw new BadCredentialsException("Correo o contraseña incorrecto");
        }catch(DisabledException disabledException){
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,"Usuaro no creado");
            return null;
        }
        final UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getCorreo());
        User user = userRepository.findFirstByCorreo(authenticationRequest.getCorreo());
        final String jwt = jwtUtil.generateToken(authenticationRequest.getCorreo());
        return new AuthenticationResponse(jwt);
    }
}
