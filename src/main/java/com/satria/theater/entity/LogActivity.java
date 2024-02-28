package com.satria.theater.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class LogActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_log_activity")
    @SequenceGenerator(name = "seq_log_activity", sequenceName = "seq_log_activity", allocationSize = 1)
    private Long id;
    private String activityType;
    private String activityDescription;

    @CreationTimestamp
    private LocalDateTime createdAt;

    LogActivity () {}

    public String getActivityDescription() {
        return activityDescription;
    }

    public String getActivityType() {
        return activityType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LogActivity (
        Long id,
        String activityType,
        String activityDescription,
        LocalDateTime createdAt
    ) {
        this.id = id;
        this.activityType = activityType;
        this.activityDescription = activityDescription;
        this.createdAt = createdAt;
    }
}
