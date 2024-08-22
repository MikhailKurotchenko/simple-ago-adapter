package com.example.simpleagoadapter.repository;


import com.example.simpleagoadapter.entities.Call;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CallRepository extends JpaRepository<Call, Long> {
}
