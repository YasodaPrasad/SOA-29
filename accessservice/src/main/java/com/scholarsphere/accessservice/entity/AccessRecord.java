package com.scholarsphere.accessservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "access_records")
public class AccessRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long contentId;

    @Column(nullable = false)
    private String accessStatus; // GRANTED, EXPIRED, DENIED

    private LocalDateTime grantedAt;
    private LocalDateTime expiresAt;

    public AccessRecord() {}

    public AccessRecord(Long userId, Long contentId, String accessStatus, LocalDateTime grantedAt, LocalDateTime expiresAt) {
        this.userId = userId;
        this.contentId = contentId;
        this.accessStatus = accessStatus;
        this.grantedAt = grantedAt;
        this.expiresAt = expiresAt;
    }

    public Long getAccessId() { return accessId; }
    public void setAccessId(Long accessId) { this.accessId = accessId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getContentId() { return contentId; }
    public void setContentId(Long contentId) { this.contentId = contentId; }

    public String getAccessStatus() { return accessStatus; }
    public void setAccessStatus(String accessStatus) { this.accessStatus = accessStatus; }

    public LocalDateTime getGrantedAt() { return grantedAt; }
    public void setGrantedAt(LocalDateTime grantedAt) { this.grantedAt = grantedAt; }

    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
}