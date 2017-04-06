package com.investmentswise.portfolio.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentswise.portfolio.dao.jpa.PortfolioRepository;
import com.investmentswise.portfolio.domain.Portfolio;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class PortfolioManager {

    private static final Logger log = LoggerFactory.getLogger(PortfolioManager.class);
    
    @Autowired PortfolioRepository repository;
    
    public PortfolioManager() {
    }
    
//    public Portfolio addPortfolio(String name, String portfolioId) {
//    	Portfolio portfolio = new Portfolio(name, portfolioId);
//    	return repository.save(portfolio);
//    }

}
