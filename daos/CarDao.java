package com.ecity.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecity.entities.Car;

public interface CarDao extends JpaRepository<Car, Integer> {
	//@Query("select * from Car where categoryId = ?1")
	
	List<Car> findBycarCategoryId(int id);
}
