package com.scholarsphere.userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(nullable = false, unique = true)
    private Long userId;

    private String fullName;
    private String email;
    private String institution;
    private String role; // e.g., STUDENT, RESEARCHER, ADMIN

    public UserProfile() {}

    public UserProfile(Long userId, String fullName, String email, String institution, String role) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.institution = institution;
        this.role = role;
    }

    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}