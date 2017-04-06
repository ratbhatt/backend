package com.investmentswise.portfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import( {MongoConfig.class} )
public class Config {
    
}