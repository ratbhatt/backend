package com.investmentswise.portfolio.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.investmentswise.portfolio.dao.jpa.PortfolioRepository;
import com.investmentswise.portfolio.domain.Portfolio;
import com.investmentswise.portfolio.domain.Stock;
import com.investmentswise.portfolio.service.PortfolioManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;*/

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/portfolio")

public class PortfolioController extends AbstractRestHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private PortfolioManager portfolioService;
    
   
    private PortfolioRepository repository;    

	@Autowired
	public PortfolioController(PortfolioRepository repository) {
		super();
		this.setPortfolioRepo(repository);
	}
	
	@PostConstruct
	public void initData(){
		logger.debug("inside initData");
		repository.deleteAll();
		Stock stock = new Stock("5000", "Saregama industries", "210", "30/03/2017");
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stock);
		Portfolio portfolio = new Portfolio("1","Portfolio 1",stockList);
		portfolio.setStocks(stockList);
		repository.save(portfolio);
	}
	
	
 
	@RequestMapping(value = "/{portfolioId}" , method=RequestMethod.GET)
	public Portfolio getPortfolio(@PathVariable("portfolioId") String portfolioId) {
	    return repository.findById(portfolioId);
	} 

	@RequestMapping(value = "/{portfolioId}/stocks", method=RequestMethod.GET)
	public @ResponseBody List<Stock> getStocks(@PathVariable("portfolioId") String portfolioId) {
		
		List<Stock> stocks = repository.findById(portfolioId).getStocks();
	    return stocks;
	} 	
	
	@RequestMapping(value = "/{portfolioId}/stock", method=RequestMethod.POST)
	public ResponseEntity<?> addStocks(@PathVariable("portfolioId") String portfolioId, @RequestBody Stock stock) {
		
		HttpHeaders headers = new HttpHeaders();
		Portfolio portfolio = repository.findById(portfolioId);
		List<Stock> stocks = repository.findById(portfolioId).getStocks();
		if(stocks==null)
			stocks = new ArrayList<Stock>();
		else if (stocks.contains(stock))
			return new ResponseEntity<String>(headers, HttpStatus.ALREADY_REPORTED);	
		stocks.add(stock);
		portfolio.setStocks(stocks);
		repository.save(portfolio);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);	
	} 	
	
    @RequestMapping(value = "/{portfolioId}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePortfolio(@PathVariable String portfolioId, @RequestBody Portfolio portfolioRequest,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(repository.findById(portfolioId));
        repository.save(portfolioRequest);
    }
    
    
    public PortfolioRepository getTaskRepo() {
		return repository;
	}

	public void setPortfolioRepo(PortfolioRepository repository) {
		this.repository = repository;
	}
}
