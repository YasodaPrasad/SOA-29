package com.scholarsphere.userservice.controller;

import com.scholarsphere.userservice.entity.UserProfile;
import com.scholarsphere.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/profile")
    public ResponseEntity<UserProfile> saveProfile(@RequestBody UserProfile profile) {
        return ResponseEntity.ok(userService.createOrUpdateProfile(profile));
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getProfileByUserId(userId));
    }
}