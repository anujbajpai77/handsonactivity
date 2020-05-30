package com.ibm.activity.currencyconversionfactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.activity.currencyconversionfactor.domain.ConversionFactorEntity;
import com.ibm.activity.currencyconversionfactor.dto.ConversionFactorDTO;
import com.ibm.activity.currencyconversionfactor.dto.ConversionFactorMapper;
import com.ibm.activity.currencyconversionfactor.repository.ConversionFactorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConversionFactorService {

	@Autowired
	ConversionFactorRepository coFactorRepository;

	@HystrixCommand(fallbackMethod = "fallBackCall")
	public ConversionFactorDTO getCoFactorByCountryCode(String countryCode) {

		try {
			ConversionFactorEntity coFactorEntity = coFactorRepository.getCoFactorByCountryCode(countryCode);
			ConversionFactorMapper mapper = new ConversionFactorMapper();
			return mapper.convertConversionFactorToConversionDTO(coFactorEntity);
		} catch (Exception e) {
			throw new RuntimeException("Get Service Exception");
		}

	}

	public ConversionFactorDTO addCoFactor(ConversionFactorDTO coFactorDTO) {
		try {
			ConversionFactorMapper mapper = new ConversionFactorMapper();
			ConversionFactorEntity factorEntity = mapper.convertConversionFactorDTOToConversionFactor(coFactorDTO);
			return mapper.convertConversionFactorToConversionDTO(coFactorRepository.save(factorEntity));
		} catch (Exception e) {
			throw new RuntimeException("Add Service Exception");
		}
	}

	public ConversionFactorDTO updateCoFactor(String countryCode, ConversionFactorDTO coFactorDTO) {
		try {
			ConversionFactorEntity conversionDetailsEntity = coFactorRepository.getCoFactorByCountryCode(countryCode);
			if (conversionDetailsEntity.getId() > 0) {
				ConversionFactorMapper mapper = new ConversionFactorMapper();
				conversionDetailsEntity.setConversionFactor(coFactorDTO.getConversionFactor());
				conversionDetailsEntity.setCountryCode(coFactorDTO.getCountryCode());

				ConversionFactorEntity updatedCoFactor = coFactorRepository.save(conversionDetailsEntity);
				return mapper.convertConversionFactorToConversionDTO(updatedCoFactor);
			} else {
				return null;
			} 
		} catch (Exception e) {
			throw new RuntimeException("Update Service Exception");
		}

	}
	
	public ConversionFactorDTO fallBackCall(String countryCode) {
		ConversionFactorDTO dfaultDto=new ConversionFactorDTO();
		dfaultDto.setId(100L);
		dfaultDto.setCountryCode(countryCode);
		dfaultDto.setConversionFactor(0.00);
		return dfaultDto;
	}
}
