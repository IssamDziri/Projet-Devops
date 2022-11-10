package tn.esprit.rh.achat.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Fournisseur;

@Getter
@Setter
public class DtoDetailFournisseur {
	private Long idDetailFournisseur;
	private String email;
	private Date dateDebutCollaboration;
	private String adresse;
	private String matricule;
	private Fournisseur fournisseur;
	
	public DtoDetailFournisseur(String email, Date dateDebutCollaboration, String adresse, String matricule) {
		super();
		this.email = email;
		this.dateDebutCollaboration = dateDebutCollaboration;
		this.adresse = adresse;
		this.matricule = matricule;
	}
	
	

}
