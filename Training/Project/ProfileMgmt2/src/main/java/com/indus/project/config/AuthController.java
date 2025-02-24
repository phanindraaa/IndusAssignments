package com.indus.project.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String rawPassword = "password"; // Replace with your desired password
    String encodedPassword = passwordEncoder.encode(rawPassword);

    private final String hardcodedUsername = "testuser";
    private final String hardcodedPassword = encodedPassword; // BCrypt hash of "password"

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        System.out.println("Encoded Password: " + encodedPassword);


        if (hardcodedUsername.equals(username) && passwordEncoder.matches(password, hardcodedPassword)) {
            String token = jwtTokenProvider.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}
