package com.ecity.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecity.daos.CarTypeDao;
import com.ecity.entities.CarType;
import com.ecity.utils.StorageService;

@Transactional
@Service
public class CarTpeServiceImpl implements CarTypeServices {
	@Autowired
	private CarTypeDao carTypeDao;
	@Autowired
	private StorageService stroageService;

	@Override
	public List<CarType> findCarTypeAll() {

		return carTypeDao.findAll();
	}

	@Override
	public CarType findById(int id) {
		Optional<CarType> carType = carTypeDao.findById(id);
		return carType.orElse(null);
	}

	@Override
	public CarType saveCarType(CarType cartype, MultipartFile carImage) {
		String fileName = stroageService.store(carImage);
		cartype.setCarImage(fileName);
		return carTypeDao.save(cartype);
	}

	@Override
	public void deleteCategory(CarType carType) {
		carTypeDao.delete(carType);
	}
}
