package com.investmentswise.portfolio.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document(collection = "Portfolio")
public class Portfolio implements Serializable{
	
    @Id private String id;
    
	private String portfolioName;
	
	private List<Stock> stocks;
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Portfolio(String portfolioId, String portfolioName , List<Stock> stocks) {
		super();
		this.portfolioName = portfolioName;
		this.id = portfolioId;
		this.stocks = stocks;
	}

	public Portfolio(){}

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", portfolioName=" + portfolioName + ", stocks=" + stocks + "]";
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	


}