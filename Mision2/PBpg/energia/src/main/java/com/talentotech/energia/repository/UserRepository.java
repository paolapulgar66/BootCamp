package com.talentotech.energia.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.talentotech.energia.model.User;

public interface UserRepository extends JpaRepository<User, Long> {




    
}