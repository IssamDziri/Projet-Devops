package tn.esprit.rh.achat.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

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
         add(Operateur.builder().nom("Sabrine").prenom("Mokhtar").password("root").build());
         add(Operateur.builder().nom("ghg").prenom("ghg").password("root").build());
         add(Operateur.builder().nom("rrr").prenom("rrr").password("root").build());
         add(Operateur.builder().nom("Farhat").prenom("nour").password("root").build());

     }

 };

 @Test
 public void testretrieveOperateur(){
     Mockito.when(operateurRepositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(op)); //find all
     Operateur op1 = operateurService.retrieveOperateur(2L);
     Assertions.assertNotNull(op1);
		System.out.println("woooorkiiiiing retrieve !");


 }
 @Test
 public void testaddOperateur() {
     Mockito.when(operateurRepositoryMock.save(op)).thenReturn(op);
     Operateur op1 = operateurService.addOperateur(op);
     Assertions.assertNotNull(op1);
		System.out.println("woooorkiiiiing add !");


 }

 @Test
 public void testretrieveAllOperateurs() {
     Mockito.when(operateurRepositoryMock.findAll()).thenReturn(listOperateurs);
     List<Operateur> listOp = operateurService.retrieveAllOperateurs();
     Assertions.assertNotNull(listOp);
		System.out.println("woooorkiiiiing all retrieve !");

 }



 @Test
 public void tesupdateOperateur() {
     op.setPrenom("ddd");
     Mockito.when(operateurRepositoryMock.save(op)).thenReturn(op);
     Operateur op1 = operateurService.updateOperateur(op);
     Assertions.assertEquals(op.getPrenom(),op1.getPrenom());
		System.out.println("woooorkiiiiing update !");


 }

 @Test
 public void testdeleteOperateur() {
     Operateur op2 = Operateur.builder().nom("Mokhtar").prenom("Sabrine").password("root").build();
     operateurService.deleteOperateur(op2.getIdOperateur());
     Mockito.verify(operateurRepositoryMock).deleteById(op2.getIdOperateur());
		System.out.println("woooorkiiiiing delete !");


 }

}