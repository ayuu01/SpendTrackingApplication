package com.example.SpendTrackingApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class ParentEntity implements Serializable {
    private static final long serialVersionUID = -5723258342757016392L;

    @JsonFormat(pattern="MM/dd/yyyy")
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @JsonFormat(pattern="MM/dd/yyyy")
    @Column(name = "updated_at")
    private Date updatedAt;

    public Long getCreatedAt() {
        return createdAt.getTime();
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt.getTime();
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
