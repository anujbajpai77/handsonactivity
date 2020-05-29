package com.ibm.activity.convertcurrency.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.activity.convertcurrency.dto.ConvertCurrencyDTO;


@FeignClient(name="CurrencyConversionFactor")
public interface ConvertCurrencyRestClient {

	@GetMapping("/conversion/getfactor")
	public ConvertCurrencyDTO getConversionFactor(
			@RequestParam(value = "countryCode") String countryCode);
}
