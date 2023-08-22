package com.caradverts.caradverts_codevibe.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.caradverts.caradverts_codevibe.model.CarAdvert;
import com.caradverts.caradverts_codevibe.repository.CarAdvertRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarAdvertService {

    private CarAdvertRepository carAdvertRepository;

    public CarAdvertService(CarAdvertRepository carAdvertRepository) {
        super();
        this.carAdvertRepository = carAdvertRepository;
    }

    public List<CarAdvert> getAllCarAdverts() {
        return carAdvertRepository.findAll();
    }

    public CarAdvert getCarAdvertById(long id) {
        return carAdvertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException());
    }

    public CarAdvert createCarAdvert(CarAdvert carAdvert) {
        return carAdvertRepository.save(carAdvert);
    }

    public CarAdvert modifyCarAdvert(CarAdvert carAdvert, long id) {
        CarAdvert existingCarAdvert = carAdvertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "This is returned if a car advert with given id is not found."));

        existingCarAdvert.setTitle(carAdvert.getTitle());
        existingCarAdvert.setFuelType(carAdvert.getFuelType());
        existingCarAdvert.setPrice(carAdvert.getPrice());
        existingCarAdvert.setIsNew(carAdvert.getIsNew());
        existingCarAdvert.setMileage(carAdvert.getMileage());
        existingCarAdvert.setFirstRegistration(carAdvert.getFirstRegistration());

        carAdvertRepository.save(existingCarAdvert);

        return existingCarAdvert;
    }

    public void deleteCarAdvert(long id) {
        // carAdvertRepository.findById(id)
        // .orElseThrow(() -> new ResourceNotFoundEx("CarAdvert", "Id",
        // Long.toString(id)));
        carAdvertRepository.deleteById(id);
    }

}
