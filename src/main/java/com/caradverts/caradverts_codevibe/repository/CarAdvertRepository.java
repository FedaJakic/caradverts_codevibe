package com.caradverts.caradverts_codevibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caradverts.caradverts_codevibe.model.CarAdvert;

public interface CarAdvertRepository extends JpaRepository<CarAdvert, Long> {

}
