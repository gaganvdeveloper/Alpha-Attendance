package com.tyss.alphaattendanceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.alphaattendanceapp.dto.TimeSheet;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer>{

}
