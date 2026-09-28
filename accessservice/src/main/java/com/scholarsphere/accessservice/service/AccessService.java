package com.scholarsphere.accessservice.service;

import com.scholarsphere.accessservice.entity.AccessRecord;
import com.scholarsphere.accessservice.repository.AccessRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccessService {

    private final AccessRepository accessRepository;

    public AccessService(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    public AccessRecord grantAccess(Long userId, Long contentId, int durationDays) {
        AccessRecord record = new AccessRecord(
                userId,
                contentId,
                "GRANTED",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(durationDays)
        );
        return accessRepository.save(record);
    }

    public List<AccessRecord> getAccessByUser(Long userId) {
        return accessRepository.findByUserId(userId);
    }

    public boolean hasAccess(Long userId, Long contentId) {
        return accessRepository.findByUserIdAndContentId(userId, contentId)
                .map(record -> "GRANTED".equalsIgnoreCase(record.getAccessStatus()) 
                        && record.getExpiresAt().isAfter(LocalDateTime.now()))
                .orElse(false);
    }
}