package com.tyss.alphaattendanceapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import com.tyss.alphaattendanceapp.util.Attendance_Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	private LocalTime loginTime;
	private double totalWorkingHours;
	@Enumerated(EnumType.STRING)
	private Attendance_Status attendance;
	@OneToMany
	private List<Batch> batchs;
}
