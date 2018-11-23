package cesi.ril17.spring.TP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cesi.ril17.spring.TP.domain.Seller;

public interface SellerRepository extends CrudRepository<Seller, Long> {
	List<Seller> findByName(String name);
	
	List<Seller> findAll();
}
