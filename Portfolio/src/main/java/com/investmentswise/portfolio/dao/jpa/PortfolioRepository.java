package com.investmentswise.portfolio.dao.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.investmentswise.portfolio.domain.Portfolio;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
@RepositoryRestResource(collectionResourceRel = "portfolio", path = "portfolio")
public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
    Portfolio findById(String id);

}
