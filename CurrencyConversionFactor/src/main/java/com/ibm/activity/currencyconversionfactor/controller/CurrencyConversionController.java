package com.ibm.activity.currencyconversionfactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.activity.currencyconversionfactor.dto.ConversionFactorDTO;
import com.ibm.activity.currencyconversionfactor.service.ConversionFactorService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("conversion")
@RestController
public class CurrencyConversionController {

	@Autowired
	ConversionFactorService coFactoryService;

	@ApiOperation("This Api will give the  conversion factor entries.")
	@GetMapping("/getfactor")
	public ResponseEntity<ConversionFactorDTO> getConversionFactor(
			@RequestParam(value = "countryCode") String countryCode) {
		return ResponseEntity.ok().body(coFactoryService.getCoFactorByCountryCode(countryCode));
	}

	@ApiOperation("This Api used to add the new entry for conversion factor.")
	@PostMapping("/addfactor")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ConversionFactorDTO> addConversionFactor(@RequestBody ConversionFactorDTO coFactorDTO) {
		ConversionFactorDTO factorDTO = coFactoryService.addCoFactor(coFactorDTO);
		return ResponseEntity.ok().body(factorDTO);
	}

	@ApiOperation("This Api used to Update the existing entry with new details.")
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/updatefactor")
	public ResponseEntity<ConversionFactorDTO> updateConversionFactor(@RequestParam(value = "countryCode") String countryCode,
			@RequestBody ConversionFactorDTO coFactorDTO) {
		
		// @PathVariable(value = "id") Long id,
		return new ResponseEntity<>(coFactoryService.updateCoFactor(countryCode, coFactorDTO), HttpStatus.OK);

	}
}
