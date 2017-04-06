package com.investmentswise.portfolio.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */

public class Stock{

    @Id
    private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(String entryPrice) {
		this.entryPrice = entryPrice;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	@Column(nullable = false)
    private String company;

    @Column()
    private String entryPrice;

    @Column()
    private String currentPrice;

    @Override
	public String toString() {
		return "Stock [id=" + id + ", company=" + company + ", entryPrice=" + entryPrice + ", currentPrice="
				+ currentPrice + ", entryDate=" + entryDate + "]";
	}

	@Column()
    private String entryDate;

    public Stock(String id, String company, String entryPrice, String entryDate   ) {
    	this.id = id;
    	this.company = company;
    	this.entryPrice = company;
    	this.entryDate = entryDate;
    }

    public Stock(){}

}
