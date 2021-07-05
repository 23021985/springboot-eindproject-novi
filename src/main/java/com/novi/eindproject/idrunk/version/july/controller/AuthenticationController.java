package com.novi.eindproject.idrunk.version.july.controller;

//import com.eindproject.idrunk.lastVersion.payload.AuthenticationRequest;
//import com.eindproject.idrunk.lastVersion.payload.AuthenticationResponse;
//import com.eindproject.idrunk.lastVersion.service.CustomUserDetailsService;
//import com.eindproject.idrunk.lastVersion.utils.JwtUtil;
import com.novi.eindproject.idrunk.version.july.payload.AuthenticationRequest;
import com.novi.eindproject.idrunk.version.july.payload.AuthenticationResponse;
import com.novi.eindproject.idrunk.version.july.service.CustomUserDetailsService;
import com.novi.eindproject.idrunk.version.july.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
//import utils.JwtUtil;

import java.security.Principal;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok().body(principal);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
