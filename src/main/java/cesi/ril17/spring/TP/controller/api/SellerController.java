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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cesi.ril17.spring.TP.domain.Seller;
import cesi.ril17.spring.TP.service.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {
	
	private SellerService sellerService;

	@Autowired
	public SellerController(SellerService sellerService) {
		super();
		this.sellerService = sellerService;
	}
	
	/**
	 *  Retourne le vendeur ayant l'id en entrée
	 * @param name
	 * @return
	 */
	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<Seller>> getSellerByID(@PathVariable Long id) {
		return new ResponseEntity<Optional<Seller>>(
				sellerService.findById(id), 
				HttpStatus.OK);
	}
	
	/**
	 *  Retourne tous les vendeurs ayant le nom en entrée
	 * @param name
	 * @return
	 */
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Seller>> getSellerByName(@PathVariable String name) {
		return new ResponseEntity<List<Seller>>(
				sellerService.findByName(name), 
				HttpStatus.OK);
	}

	/**
	 *  Retourne tous les vendeurs
	 * @return
	 */
	@GetMapping("/getAll")
	public ResponseEntity<List<Seller>> getSeller() {
		return new ResponseEntity<List<Seller>>(
				sellerService.findAll(), 
				HttpStatus.OK);
	}

	/**
	 *  Insère le vendeur en entrée
	 * @param seller
	 * @return
	 */
	@PostMapping("/insertSeller")
	public Long insertSeller(@RequestBody Seller seller) {
		seller = sellerService.insertSeller(seller);
		return seller.getId();
	}
	
	/**
	 * Supprime le vendeur ayant l'ID en entrée
	 * @return
	 */
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		if(sellerService.deleteById(id)) {
			return new ResponseEntity<String>(
					"Data have been destroyed.", 
					HttpStatus.OK
				);
		}
		return new ResponseEntity<String>(
				"An error occured. Please try later.", 
				HttpStatus.OK
			);
	}

	/**
	 *  Supprime tous les vendeurs
	 * @return
	 */
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		if(sellerService.deleteAll()) {
			return new ResponseEntity<String>(
					"Data have been destroyed.", 
					HttpStatus.OK
				);
		}
		return new ResponseEntity<String>(
				"An error occured. Please try later.", 
				HttpStatus.OK
			);
	}
	
	/**
	 *  Modifie le vendeur
	 * @return
	 */
	@PutMapping("/modifySeller/{id}")
	public ResponseEntity<String> modifySeller(@RequestBody Seller sel, @PathVariable Long id) {
		if(sellerService.modifyById(id, sel)) {
			return new ResponseEntity<String>(
					"Data have been modified.", 
					HttpStatus.OK);
		}
		return new ResponseEntity<String>(
				"An error occured. Please try later.", 
				HttpStatus.OK);
	}
}

