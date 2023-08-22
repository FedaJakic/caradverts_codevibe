package com.caradverts.caradverts_codevibe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caradverts.caradverts_codevibe.model.CarAdvert;
import com.caradverts.caradverts_codevibe.services.CarAdvertService;

@RestController
@RequestMapping(path = "/car")
public class CarAdvertController {

    private CarAdvertService carAdvertService;

    public CarAdvertController(CarAdvertService carAdvertService) {
        super();
        this.carAdvertService = carAdvertService;
    }

    @GetMapping("/adverts")
    public List<CarAdvert> allCarAdverts() {
        return carAdvertService.getAllCarAdverts();
    }

    @GetMapping("/adverts/{id}")
    public ResponseEntity<CarAdvert> carAdvertsById(@PathVariable("id") long carAdvertId) {
        return new ResponseEntity<CarAdvert>(carAdvertService.getCarAdvertById(carAdvertId), HttpStatus.OK);
    }

    @PostMapping("/adverts")
    public ResponseEntity<CarAdvert> createNewCarAdvert(@RequestBody CarAdvert carAdvert) {
        return new ResponseEntity<CarAdvert>(carAdvertService.createCarAdvert(carAdvert), HttpStatus.CREATED);
    }

    @PutMapping("/adverts/{id}")
    public ResponseEntity<CarAdvert> modifyCarAdvert(@PathVariable("id") long carAdvertId,
            @RequestBody CarAdvert carAdvert) {
        return new ResponseEntity<CarAdvert>(carAdvertService.modifyCarAdvert(carAdvert, carAdvertId), HttpStatus.OK);
    }

    @DeleteMapping("/adverts/{id}")
    public ResponseEntity<String> deleteCarAdvert(@PathVariable("id") long id) {
        carAdvertService.deleteCarAdvert(id);
        return new ResponseEntity<String>("Car Advert deleted Successuflly", HttpStatus.NO_CONTENT);
    }

}
