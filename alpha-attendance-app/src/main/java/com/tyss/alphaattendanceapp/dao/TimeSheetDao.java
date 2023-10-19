package com.tyss.alphaattendanceapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.alphaattendanceapp.dto.TimeSheet;
import com.tyss.alphaattendanceapp.repository.TimeSheetRepository;

@Repository
public class TimeSheetDao {

	@Autowired
	private TimeSheetRepository repository;

	public TimeSheet saveTimeSheet(TimeSheet timeSheet) {
		return repository.save(timeSheet);
	}

	public TimeSheet updateTimeSheet(TimeSheet timeSheet) {
		return repository.save(timeSheet);
	}

	public Optional<TimeSheet> findTimeSheetById(int id) {
		return repository.findById(id);
	}

	public void deleteTimeSheetById(int id) {
		repository.deleteById(id);
	}

	public List<TimeSheet> findAllTimeSheets() {
		return repository.findAll();
	}

}
