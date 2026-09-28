package com.scholarsphere.accessservice.repository;

import com.scholarsphere.accessservice.entity.AccessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AccessRepository extends JpaRepository<AccessRecord, Long> {
    List<AccessRecord> findByUserId(Long userId);
    Optional<AccessRecord> findByUserIdAndContentId(Long userId, Long contentId);
}