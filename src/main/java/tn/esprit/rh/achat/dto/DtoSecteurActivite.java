package tn.esprit.rh.achat.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Fournisseur;
@Getter
@Setter
public class DtoSecteurActivite {
	
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	private Set<Fournisseur> fournisseurs;
	
	public DtoSecteurActivite(String codeSecteurActivite, String libelleSecteurActivite) {
		super();
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
	}
	
	
	
	
	


}
