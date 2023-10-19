package com.tyss.alphaattendanceapp.dto;

import java.time.LocalDate;

import com.tyss.alphaattendanceapp.util.BatchStatus;
import com.tyss.alphaattendanceapp.util.Mode;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subjectName;
	private String batchCode;
	private LocalDate startDate;
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private BatchStatus status;
	@Enumerated(EnumType.STRING)
	private Mode mode;
	private String location;
}
