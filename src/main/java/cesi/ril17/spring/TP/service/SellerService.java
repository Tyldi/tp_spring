package cesi.ril17.spring.TP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import cesi.ril17.spring.TP.domain.Seller;
import cesi.ril17.spring.TP.repository.SellerRepository;

@Service
public class SellerService {

	private SellerRepository sellerRepo;

	@Autowired
	public SellerService(SellerRepository sellerRepo) {
		super();
		this.sellerRepo = sellerRepo;
	}

	public List<Seller> findAll() {
        List<Seller> sellers = sellerRepo.findAll();
        return sellers;
    }
	
	public List<Seller> findByName(String name) {
		List<Seller> sellers = sellerRepo.findByName(name);
		return (sellers.isEmpty()) ?  null : sellers;
	}
	
	public Optional<Seller> findById(Long id) {
		Optional<Seller> sel = sellerRepo.findById(id);
		return sel;
	}
	
	public Boolean modifyById(Long id, Seller sel) {
		if(sellerRepo.existsById(id)) {
			try {
				sellerRepo.save(sel);
			} catch(Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	public Seller insertSeller(Seller seller) {
		seller = sellerRepo.save(seller);
		return seller;
	}
	
	public boolean deleteAll() {
		try {
			sellerRepo.deleteAll();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean deleteById(Long id) {
		try {
			sellerRepo.deleteById(id);;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
