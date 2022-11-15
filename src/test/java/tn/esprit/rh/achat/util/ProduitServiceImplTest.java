/* package tn.esprit.rh.achat.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.util.List;
////
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class ProduitServiceImplTest {

	@Autowired
	ProduitServiceImpl produitService;
	
	Produit prod= Produit.builder().codeProduit("123").libelleProduit("lait").build();
	

	@Test
	
	void testAddProduit()  throws ParseException{
		List<Produit> produits = produitService.retrieveAllProduits();
		Produit produitADD = Produit.builder().codeProduit("100").libelleProduit("lait").build();
		int expected = produits.size();
		Produit savedProduit = produitService.addProduit(produitADD);
		assertEquals(expected + 1, produitService.retrieveAllProduits().size());		
	}

	@Test
	
	void testdeleteProduit() throws ParseException {
		Produit produitADD = Produit.builder().codeProduit("100").libelleProduit("lait").build();
		Produit addedProduit = produitService.addProduit(produitADD);
		produitService.deleteProduit(addedProduit.getIdProduit());
		assertNull(produitService.retrieveProduit(addedProduit.getIdProduit()));

	}
	 
}
*/
