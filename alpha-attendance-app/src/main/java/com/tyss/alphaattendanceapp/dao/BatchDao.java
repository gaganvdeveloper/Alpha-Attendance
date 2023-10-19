package com.tyss.alphaattendanceapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.alphaattendanceapp.dto.Batch;
import com.tyss.alphaattendanceapp.repository.BatchRepository;

@Repository
public class BatchDao {

	@Autowired
	BatchRepository repository;

	public Batch saveBatch(Batch batch) {
		return repository.save(batch);
	}

	public Batch updateBatch(Batch batch) {
		return repository.save(batch);
	}

	public Optional<Batch> findBatchById(int id) {
		return repository.findById(id);
	}

	public void deleteBatchById(int id) {
		repository.deleteById(id);
	}

	public List<Batch> saveBatch() {
		return repository.findAll();
	}

}
