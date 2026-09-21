package com.scholarsphere.accessservice.controller;

import com.scholarsphere.accessservice.entity.AccessRecord;
import com.scholarsphere.accessservice.service.AccessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access")
public class AccessController {

    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping("/grant")
    public ResponseEntity<AccessRecord> grantAccess(@RequestParam Long userId, 
                                                    @RequestParam Long contentId, 
                                                    @RequestParam(defaultValue = "30") int days) {
        return ResponseEntity.ok(accessService.grantAccess(userId, contentId, days));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccessRecord>> getUserAccess(@PathVariable Long userId) {
        return ResponseEntity.ok(accessService.getAccessByUser(userId));
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkAccess(@RequestParam Long userId, @RequestParam Long contentId) {
        return ResponseEntity.ok(accessService.hasAccess(userId, contentId));
    }
}