package tn.esprit.rh.achat.dto;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Produit;

@Getter
@Setter
public class DtoCategorieProduit {
	
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	private Set<Produit> produits;
	
	public DtoCategorieProduit(String codeCategorie, String libelleCategorie) {
		super();
		this.codeCategorie = codeCategorie;
		this.libelleCategorie = libelleCategorie;
	}
	
	

}
