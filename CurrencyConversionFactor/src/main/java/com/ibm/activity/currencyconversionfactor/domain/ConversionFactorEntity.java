package com.ibm.activity.currencyconversionfactor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONVERSION_DETAILS")
public class ConversionFactorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "conversion_factor")
	private Double conversionFactor;

	public ConversionFactorEntity() {

	}

	public ConversionFactorEntity(Long id, String countryCode, Double conversionFactor) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

}
