package ch.hegfrederic.metier;

import ch.hegfrederic.base.EmployeDao;
import ch.hegfrederic.domaine.Commande;
import ch.hegfrederic.domaine.Employe;
import ch.hegfrederic.metier.ListeEmployes;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 * 
 */
public class ListeEmployesTest {
  
  private ListeEmployes listeEmployes;
  
  @BeforeMethod
  public void init(){
    EmployeDao mockedEmployeDao = mock(ch.hegfrederic.base.EmployeDao.class);
    List<Employe> list = new java.util.ArrayList<>();
    list.add(new Employe(0, "Nom0", "Prenom0"));
    list.add(new Employe(0, "Nom1", "Prenom1"));
    list.add(new Employe(0, "Nom2", "Prenom2"));
    list.add(new Employe(0, "Nom3", "Prenom3"));
    list.add(new Employe(0, "Nom4", "Prenom4"));
    when(mockedEmployeDao.getListeEmployes()).thenReturn(list);
    listeEmployes = new ListeEmployes(mockedEmployeDao);
    listeEmployes.init();
  }

  @Test(enabled=true)
  public void testAddCommande(){
    listeEmployes.setPos(0);
    int nbCommandes = listeEmployes.getCourant().getNbCommandes();
    ch.hegfrederic.domaine.Commande commande = new Commande(listeEmployes.getCourant(), new ch.hegfrederic.domaine.Capsule(0, "CapsuleTest", 0.5), 10);
    listeEmployes.addCommande(commande);
    assertNotSame(listeEmployes.getCourant().getNbCommandes(), nbCommandes);
  }
  
}