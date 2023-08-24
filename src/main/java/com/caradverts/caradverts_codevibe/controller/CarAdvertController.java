package com.caradverts.caradverts_codevibe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caradverts.caradverts_codevibe.dto.CarAdvertDTO;
import com.caradverts.caradverts_codevibe.model.CarAdvert;
import com.caradverts.caradverts_codevibe.services.CarAdvertService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/car")
public class CarAdvertController {

    private CarAdvertService carAdvertService;

    public CarAdvertController(CarAdvertService carAdvertService) {
        super();
        this.carAdvertService = carAdvertService;
    }

    @GetMapping("/adverts")
    public List<CarAdvert> getAllCarAdverts(@RequestParam(value = "sortby", required = false) String sort) {
        return carAdvertService.getAllCarAdverts(sort);
    }

    @GetMapping("/adverts/{id}")
    public ResponseEntity<CarAdvert> getCarAdvertsById(@PathVariable("id") long carAdvertId) {
        return new ResponseEntity<CarAdvert>(carAdvertService.getCarAdvertById(carAdvertId), HttpStatus.OK);
    }

    @PostMapping("/adverts")
    public ResponseEntity<CarAdvert> createNewCarAdverts(@Valid @RequestBody CarAdvert carAdvert) {
        return new ResponseEntity<>(carAdvertService.createCarAdvert(carAdvert),
                HttpStatus.CREATED);
    }

    @PutMapping(path = "/adverts/{id}")
    public Optional<CarAdvert> modifyCarAdvert(@Valid @RequestBody CarAdvertDTO carAdvertDTO,
            @PathVariable("id") Long carId) {
        return carAdvertService.modifyCarAdvert(carAdvertDTO, carId);
    }

    @DeleteMapping("/adverts/{id}")
    public ResponseEntity<String> deleteCarAdvert(@PathVariable("id") long id) {
        carAdvertService.deleteCarAdvert(id);
        return new ResponseEntity<String>("Car Advert deleted Successuflly", HttpStatus.NO_CONTENT);
    }

}
