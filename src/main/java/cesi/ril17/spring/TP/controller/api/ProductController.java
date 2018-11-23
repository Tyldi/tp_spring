package cesi.ril17.spring.TP.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesi.ril17.spring.TP.domain.Product;
import cesi.ril17.spring.TP.domain.Seller;
import cesi.ril17.spring.TP.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	/**
	 *  Retourne le produit ayant l'id en entrée
	 * @param name
	 * @return
	 */
	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<Product>> getProduitByID(@PathVariable Long id) {
		return new ResponseEntity<Optional<Product>>(
				productService.findById(id), 
				HttpStatus.OK);
	}
	
	/**
	 * Retourne tous les produits ayant le nom en entrée
	 * @param name
	 * @return
	 */
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Product>> getSellerByName(@PathVariable String name) {
		return new ResponseEntity<List<Product>>(
				productService.findByName(name), 
				HttpStatus.OK);
	}
	
	/**
	 * Retourne tous les produits
	 * @return
	 */
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getSeller() {
		return new ResponseEntity<List<Product>>(
				productService.findAll(), 
				HttpStatus.OK);
	}
	
	/**
	 * Insère le produit en entrée
	 * @param product
	 * @return
	 */
	@PostMapping("/insertProduct")
	public Long insertSeller(@RequestBody Product product) {
		product = productService.insertProduct(product);
		return product.getId();
	}
	
	/**
	 * Supprime le produit ayant l'ID en entrée
	 * @return
	 */
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		if(productService.deleteById(id)) {
			return new ResponseEntity<String>(
					"Data have been destoryed.", 
					HttpStatus.OK
				);
		}
		return new ResponseEntity<String>(
				"An error occured. Please try later.", 
				HttpStatus.OK
			);
	}
	
	/**
	 * Supprime tous les produits
	 * @return
	 */
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		if(productService.deleteAll()) {
			return new ResponseEntity<String>(
					"Data have been destoryed.", 
					HttpStatus.OK
				);
		}
		return new ResponseEntity<String>(
				"An error occured. Please try later.", 
				HttpStatus.OK
			);
	}
}
