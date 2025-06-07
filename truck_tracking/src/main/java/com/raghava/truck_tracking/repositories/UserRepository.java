package com.raghava.truck_tracking.repositories;


import com.raghava.truck_tracking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}