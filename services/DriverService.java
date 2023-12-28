package com.ecity.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecity.entities.Driver;

public interface DriverService {
	
	Driver findDriverById(int id);
	
	List<Driver> findAllDrivers();
	
	Driver addDriver(Driver d, MultipartFile multipartFile);
	
	void deleteDriver(Driver d);
	
}
