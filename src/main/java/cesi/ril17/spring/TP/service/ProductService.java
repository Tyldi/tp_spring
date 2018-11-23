package cesi.ril17.spring.TP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cesi.ril17.spring.TP.domain.Product;
import cesi.ril17.spring.TP.domain.Seller;
import cesi.ril17.spring.TP.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;

	@Autowired
	public ProductService(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	public List<Product> findAll() {
        List<Product> products = productRepo.findAll();
        return products;
    }
	
	public List<Product> findByName(String name) {
		List<Product> products = productRepo.findByName(name);
		return (products.isEmpty()) ?  null : products;
	}
	
	public Optional<Product> findById(Long id) {
		Optional<Product> prod = productRepo.findById(id);
		return prod;
	}
	
	
	public Product insertProduct(Product product) {
		product = productRepo.save(product);
		return product;
	}
	
	public boolean deleteAll() {
		try {
			productRepo.deleteAll();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteById(Long id) {
		try {
			productRepo.deleteById(id);;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
