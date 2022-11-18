package tn.esprit.rh.achat.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Produit;
@Getter
@Setter
public class DtoStock {
	   private Long idStock;
	    private String libelleStock;
	    private Integer qte;
	    private Integer qteMin;

	    private Set<Produit> produits;

	    public DtoStock(String libelleStock, Integer qte, Integer qteMin) {
	        super();
	        this.libelleStock = libelleStock;
	        this.qte = qte;
	        this.qteMin = qteMin;
	    }

}
