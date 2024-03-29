package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
