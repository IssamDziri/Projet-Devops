package tn.esprit.rh.achat.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Facture;
@Getter
@Setter
public class DtoOperateur {

	private Long idOperateur;
	private String nom;
	private String prenom;
	
	private String password;

	private Set<Facture> factures;

	public DtoOperateur(String nom, String prenom, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}
	

}
