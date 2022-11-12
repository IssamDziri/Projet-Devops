package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@ExtendWith(MockitoExtension.class)
class produit{
	
	@Mock
	ProduitRepository produitRepository;
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	@Test
	public void retrieveAllproduitsTest() {
		when(produitRepository.findAll()).thenReturn(Stream.of(
                new Produit((long)1,null,null,null, null,null,null,null,null,null),
                new Produit((long)2,null,null,null, null,null,null,null,null,null), 
				new Produit((long)3,null,null,null, null,null,null,null,null,null))
                .collect(Collectors.toList()));
		assertEquals(3,produitService.retrieveAllProduits().size());
		
	}

	@Test
	public void addproduitTest() {
		Produit op = new Produit((long)1,null,null,null, null,null,null,null,null,null);
		when(produitRepository.save(op)).thenReturn(op);
		assertEquals(op, produitService.addProduit(op));
	}

	@Test
	public void retreiveproduitTest() {
		Produit op = new Produit((long)1,null,null,null, null,null,null,null,null,null);
		when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
		Produit op1 = produitService.retrieveProduit((long) 2);
		Assertions.assertNotNull(op1);

	}

	@Test
	public void deleteproduitTest() {
		Produit op = new Produit((long)1,null,null,null, null,null,null,null,null,null);
		produitService.deleteProduit((long) 1);
		verify(produitRepository).deleteById((long) 1);

	}

	@Test
	public void updatetproduitTest() {
		Produit op = new Produit((long)1,null,null,null, null,null,null,null,null,null);
		Mockito.when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(op);
		op.setLibelleProduit("iheb");;
		Produit exisitingOp= produitService.updateProduit(op) ;
		
		assertNotNull(exisitingOp);
		assertEquals("iheb", op.getLibelleProduit());
	}
}