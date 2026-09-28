package com.scholarsphere.userservice.service;

import com.scholarsphere.userservice.entity.UserProfile;
import com.scholarsphere.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile createOrUpdateProfile(UserProfile profile) {
        return userRepository.save(profile);
    }

    public UserProfile getProfileByUserId(Long userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User profile not found for ID: " + userId));
    }
}