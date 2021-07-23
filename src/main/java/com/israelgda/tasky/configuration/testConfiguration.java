package com.israelgda.tasky.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.israelgda.tasky.service.DBService;

@Configuration
@Profile("test")
public class testConfiguration {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanciacaoTeste() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}
	

}
