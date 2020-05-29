package com.ibm.activity.convertcurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.activity.convertcurrency.client.ConvertCurrencyRestClient;
import com.ibm.activity.convertcurrency.dto.ConvertCurrencyDTO;

@Service
public class ConvertCurrencyService {

	final ConvertCurrencyRestClient restClient;

	@Autowired
	public ConvertCurrencyService(ConvertCurrencyRestClient restClient) {
		this.restClient = restClient;
	}

	public ConvertCurrencyDTO convertedCurrency(String countryCode, Double amount) {
		ConvertCurrencyDTO responseDto = restClient.getConversionFactor(countryCode);

		if (responseDto.getId() > 0) {
			Double convertedAmount = responseDto.getConversionFactor() * amount;
			responseDto.setConvertedAmount(convertedAmount);
		}
 
		return responseDto;
	}

}
