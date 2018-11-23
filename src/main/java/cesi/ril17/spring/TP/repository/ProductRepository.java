package cesi.ril17.spring.TP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cesi.ril17.spring.TP.domain.Product;
import cesi.ril17.spring.TP.domain.Seller;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);
	
	List<Product> findAll();
	
	void deleteAll();
}
