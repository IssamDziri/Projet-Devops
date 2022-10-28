package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Operateur;

@Repository
public interface OperateurRepository extends JpaRepository<Operateur, Long> {


}
