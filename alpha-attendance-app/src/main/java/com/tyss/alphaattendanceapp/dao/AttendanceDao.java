package com.tyss.alphaattendanceapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.alphaattendanceapp.dto.Attendance;
import com.tyss.alphaattendanceapp.repository.AttendanceRepository;

@Repository
public class AttendanceDao {

	@Autowired
	private AttendanceRepository repository;

	public Attendance saveAttendance(Attendance attendance) {
		return repository.save(attendance);
	}

	public Attendance updateAttendance(Attendance attendance) {
		return repository.save(attendance);
	}

	public Optional<Attendance> findAttendanceById(int id) {
		return repository.findById(id);
	}

	public void deleteAttendanceById(int id) {
		repository.deleteById(id);
	}

	public List<Attendance> findAllAttendances() {
		return repository.findAll();
	}

}
