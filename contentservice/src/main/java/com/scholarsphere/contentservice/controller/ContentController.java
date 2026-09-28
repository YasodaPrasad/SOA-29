package com.scholarsphere.contentservice.controller;

import com.scholarsphere.contentservice.entity.Content;
import com.scholarsphere.contentservice.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcomeMessage() {
        return ResponseEntity.ok("Access granted! Secure content loaded successfully.");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addContent(@RequestBody Content content, 
                                       @RequestHeader(value = "X-User-Role", required = false) String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Access Denied: Only ADMIN users can upload content.");
        }
        return ResponseEntity.ok(contentRepository.save(content));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Content>> getAllContent() {
        return ResponseEntity.ok(contentRepository.findAll());
    }
}