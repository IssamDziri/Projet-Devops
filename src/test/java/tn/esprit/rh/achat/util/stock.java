package tn.esprit.rh.achat.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = AchatApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class OperateurServiceMockitoTest {
	
 @Mock
 OperateurRepository operateurRepositoryMock;
 @InjectMocks
 OperateurServiceImpl operateurService;


 Operateur op = Operateur.builder().nom("Farhat").prenom("Chaima").password("root").build();
 List<Operateur> listOperateurs = new ArrayList<Operateur>(){
     {
         add(Operateur.builder().nom("amine").prenom("amine").password("root").build());
         add(Operateur.builder().nom("sabrine").prenom("sabrine").password("root").build());
         add(Operateur.builder().nom("issam").prenom("issam").password("root").build());
         add(Operateur.builder().nom("iheb").prenom("iheb").password("root").build());

     }

 };

 @Test
 public void testretrieveOperateur(){
     Mockito.when(operateurRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(op)); //find all
     Operateur op1 = operateurService.retrieveOperateur(2L);
     Assertions.assertNotNull(op1);
		System.out.println("woorking retrieve !");


 }
 @Test
 public void testaddOperateur() {
     Mockito.when(operateurRepositoryMock.save(op)).thenReturn(op);
     Operateur op1 = operateurService.addOperateur(op);
     Assertions.assertNotNull(op1);
		System.out.println("woorking add !");


 }

 @Test
 public void testretrieveAllOperateurs() {
     Mockito.when(operateurRepositoryMock.findAll()).thenReturn(listOperateurs);
     List<Operateur> listOp = operateurService.retrieveAllOperateurs();
     Assertions.assertNotNull(listOp);
		System.out.println("woorkiiiiing all retrieve !");

 }



 @Test
 public void tesupdateOperateur() {
     op.setPrenom("ines");
     Mockito.when(operateurRepositoryMock.save(op)).thenReturn(op);
     Operateur op1 = operateurService.updateOperateur(op);
     Assertions.assertEquals(op.getPrenom(),op1.getPrenom());
		System.out.println("woorking update !");


 }

 @Test
 public void testdeleteOperateur() {
     Operateur op2 = Operateur.builder().nom("iheb").prenom("iheb").password("root").build();
     operateurService.deleteOperateur(op2.getIdOperateur());
     Mockito.verify(operateurRepositoryMock).deleteById(op2.getIdOperateur());
		System.out.println("woorking delete !");


 }

}
