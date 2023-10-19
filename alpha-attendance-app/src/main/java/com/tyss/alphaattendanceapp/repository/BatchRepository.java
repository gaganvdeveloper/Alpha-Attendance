package com.tyss.alphaattendanceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.alphaattendanceapp.dto.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer>{

}
