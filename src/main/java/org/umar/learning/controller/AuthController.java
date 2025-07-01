package org.umar.learning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umar.learning.model.User;
import org.umar.learning.security.JwtUtil;
import org.umar.learning.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> userMap) {
        String email = userMap.get("email");
        String password = userMap.get("password");

        User user = userService.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid email or password"));
    }
}
