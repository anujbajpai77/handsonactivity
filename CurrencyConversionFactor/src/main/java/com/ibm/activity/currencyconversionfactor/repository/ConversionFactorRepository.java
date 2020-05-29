package com.ibm.activity.currencyconversionfactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.activity.currencyconversionfactor.domain.ConversionFactorEntity;

@Repository
public interface ConversionFactorRepository extends JpaRepository<ConversionFactorEntity, Long> {

	ConversionFactorEntity getCoFactorByCountryCode(String countryCode);

}
