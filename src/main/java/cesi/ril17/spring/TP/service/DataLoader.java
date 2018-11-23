package cesi.ril17.spring.TP.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import cesi.ril17.spring.TP.domain.Product;
import cesi.ril17.spring.TP.domain.Seller;
import cesi.ril17.spring.TP.repository.ProductRepository;
import cesi.ril17.spring.TP.repository.SellerRepository;

@Service
public class DataLoader {

	private ProductRepository productRepo;
	private SellerRepository sellerRepo;

	@Autowired
	public DataLoader(ProductRepository productRepo, SellerRepository sellerRepo) {
		super();
		this.productRepo = productRepo;
		this.sellerRepo = sellerRepo;
	}
	
	@PostConstruct
	private void loadData() {
		// create seller
		Seller seller1 = new Seller(null, "AUBIGNAC", "Chemin du JEE", "31500", "Toulouse", null);
		Seller seller2 = new Seller(null, "AUBIGNAC2", "Chemin du JEE", "31500", "Toulouse", null);
		Seller seller3 = new Seller(null, "AUBIGNAC", "Chemin du JEE2", "31500", "Toulouse", null);
		sellerRepo.save(seller1);
		sellerRepo.save(seller2);
		sellerRepo.save(seller3);
		// delete seller2
		//sellerRepo.delete(seller2);
		
		// create product
		Product prod1 = new Product(null, "Ordinateur", "very nice stuff, with great GTX, please buy it.", "path/img.jpg", 15.2, null, seller1);
		productRepo.save(prod1);
	}
}
