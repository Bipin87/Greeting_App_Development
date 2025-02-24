package com.capgemini.My_Greeting_App.repository;

import com.capgemini.My_Greeting_App.entities.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
