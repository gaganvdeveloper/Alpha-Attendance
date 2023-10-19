package com.tyss.alphaattendanceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.alphaattendanceapp.dto.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

}
