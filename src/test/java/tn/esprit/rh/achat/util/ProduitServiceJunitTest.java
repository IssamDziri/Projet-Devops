/*package tn.esprit.rh.achat.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduitServiceJunitTest {

    @Autowired
    IProduitService produitService;

    @Autowired
    ProduitRepository produitRepository;

    Produit p1 = new Produit(55L, "2365","produit1",50);
    Produit p2 = new Produit(66L, "5681","produit5",120);
    @Test
    @Order(1)
    public void testaddProdiut() {
        Produit produitAdded =  produitService.addProduit(p1);
        Assertions.assertEquals(produitAdded.getCodeProduit(), produitAdded.getCodeProduit());
    }

    @Test
    @Order(2)
    public void testRetrieveAllProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(listProduits.size(), listProduits.size());
    }


    @Test

    @Order(3)
    public void testModifyProduit()   {

        Produit produitUpdated  = produitService.updateProduit(p2);
        Assertions.assertEquals(p2.getCodeProduit(), produitUpdated.getCodeProduit());
    }

    @Test

    @Order(2)
    public void testDeleteProduit() {

        //  produitService.deleteProduit(6L);
        produitRepository.deleteAll();
        Assertions.assertNull(produitService.retrieveProduit(2L));

    }
}*/