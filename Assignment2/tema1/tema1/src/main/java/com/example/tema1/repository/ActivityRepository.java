package com.example.tema1.repository;

import com.example.tema1.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Activity findByActivityId(Long id);
}
