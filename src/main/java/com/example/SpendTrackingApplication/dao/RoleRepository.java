package com.example.SpendTrackingApplication.dao;

import com.example.SpendTrackingApplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,String> {
    @Query(value="From Role where name=:name")
    Role getRoleByName(@Param("name") String name);
}
