package com.ibm.activity.currencyconversionfactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.activity.currencyconversionfactor.domain.ConversionFactorEntity;
import com.ibm.activity.currencyconversionfactor.dto.ConversionFactorDTO;
import com.ibm.activity.currencyconversionfactor.dto.ConversionFactorMapper;
import com.ibm.activity.currencyconversionfactor.repository.ConversionFactorRepository;

@Service
public class ConversionFactorService {

	@Autowired
	ConversionFactorRepository coFactorRepository;

	public ConversionFactorDTO getCoFactorByCountryCode(String countryCode) {

		ConversionFactorEntity coFactorEntity = coFactorRepository.getCoFactorByCountryCode(countryCode);
		ConversionFactorMapper mapper = new ConversionFactorMapper();

		return mapper.convertConversionFactorToConversionDTO(coFactorEntity);

	}

	public ConversionFactorDTO addCoFactor(ConversionFactorDTO coFactorDTO) {
		ConversionFactorMapper mapper = new ConversionFactorMapper();
		ConversionFactorEntity factorEntity = mapper.convertConversionFactorDTOToConversionFactor(coFactorDTO);

		return mapper.convertConversionFactorToConversionDTO(coFactorRepository.save(factorEntity));
	}

	public ConversionFactorDTO updateCoFactor(String countryCode, ConversionFactorDTO coFactorDTO) {
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

	}
}
