package com.ecity.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecity.entities.Booking;
import com.ecity.entities.Car;
import com.ecity.models.Response;
import com.ecity.models.car.CarDto;
import com.ecity.models.car.CarInDto;
import com.ecity.services.CarService;

@RequestMapping("/car")
@RestController
@CrossOrigin
public class CarControllerImpl {

	@Autowired
	private CarService carService;

	@GetMapping("/")
	public ResponseEntity<?> findAllCars() {
		List<Car> categoryList = carService.findCarAll();
		Stream<CarDto> result = categoryList.stream().map(category -> CarDto.fromEntity(category));
		return Response.success(result);
	}

	@PostMapping("/")
	public ResponseEntity<?> save(CarInDto carInDto) {
		Car newCar = CarInDto.toEntity(carInDto);
		newCar = carService.saveCar(newCar);
		return Response.success(newCar);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findCarBycategoryId(@PathVariable("id") int id) {
		List<Car> carsOfcategory = carService.findBycategoryId(id);
		Stream<CarDto> result = carsOfcategory.stream().map(category -> CarDto.fromEntity(category));
		return Response.success(result);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable("id") int id){
		Car car = carService.findById(id);
		carService.deleteBooking(car);
		return Response.success(car);
		
	}
}
