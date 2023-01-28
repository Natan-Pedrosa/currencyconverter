package com.currencyconverter.CurrencyConverter.controller;

import com.currencyconverter.CurrencyConverter.model.Currency;
import com.currencyconverter.CurrencyConverter.service.CurrencyConversion;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@SpringBootApplication
@RestController
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}

	@PostMapping(path = "/conversion",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Currency conversion(@RequestBody JsonNode currency){
		return CurrencyConversion.conversionCurrencyActualToAnother(currency);
	}
}
