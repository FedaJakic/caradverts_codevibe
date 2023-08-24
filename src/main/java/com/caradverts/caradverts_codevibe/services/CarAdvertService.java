package com.caradverts.caradverts_codevibe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.mapstruct.factory.Mappers;

import com.caradverts.caradverts_codevibe.dto.CarAdvertDTO;
import com.caradverts.caradverts_codevibe.dto.CarAdvertMapper;
import com.caradverts.caradverts_codevibe.model.CarAdvert;
import com.caradverts.caradverts_codevibe.repository.CarAdvertRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarAdvertService {

    private CarAdvertRepository carAdvertRepository;
    private CarAdvertMapper carAdvertMapper;

    CarAdvertMapper INSTANCE = Mappers.getMapper(CarAdvertMapper.class);

    public CarAdvertService(CarAdvertRepository carAdvertRepository, CarAdvertMapper carAdvertMapper) {
        super();
        this.carAdvertRepository = carAdvertRepository;
        this.carAdvertMapper = carAdvertMapper;
    }

    public List<CarAdvert> getAllCarAdverts(String sort) {
        if (sort == null) {
            return carAdvertRepository.findAll();
        } else if (sort.isBlank()) {
            return carAdvertRepository.findAll(Sort.by(Direction.DESC, "id"));
        } else {
            return carAdvertRepository.findAll(Sort.by(Direction.DESC, sort));
        }
    }

    public CarAdvert getCarAdvertById(long id) {
        return carAdvertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public CarAdvert createCarAdvert(CarAdvert carAdvert) {
        if (carAdvertRepository.existsById(carAdvert.getId()))
            throw new RuntimeException("There is already car advert with given ID");
        else
            return carAdvertRepository.save(carAdvert);
    }

    public Optional<CarAdvert> modifyCarAdvert(CarAdvertDTO carAdvertDTO, Long carId) {
        CarAdvert carAdvert = carAdvertRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "This is returned if a car advert with given id is not found."));

        if (carAdvertDTO.getId() != null && carAdvertDTO.getId() != carId) {
            if (carAdvertDTO.getId() > 0)
                carAdvertRepository.deleteById(carId);
        }

        carAdvertMapper.updateCarAdvertFromDto(carAdvertDTO, carAdvert);
        carAdvertRepository.save(carAdvert);
        Long newModifiedCarId = carAdvert.getId();
        return carAdvertRepository.findById(newModifiedCarId);
    }

    public void deleteCarAdvert(long id) {
        if (carAdvertRepository.existsById(id))
            carAdvertRepository.deleteById(id);
        else
            throw new EntityNotFoundException("This is returned if a car advert with given id is not found.");
    }

}
