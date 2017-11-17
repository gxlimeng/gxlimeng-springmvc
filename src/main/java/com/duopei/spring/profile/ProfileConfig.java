package com.duopei.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public ProfileBean devProfileBean(){
		return new ProfileBean(" from development profile >>>> ");
	}
	
	@Bean
	@Profile("prod")
	public ProfileBean prodProfileBean(){
		return new ProfileBean(" from production profile >>>>");
	}
	
}
