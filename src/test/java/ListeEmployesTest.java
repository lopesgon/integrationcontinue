import ch.hegfrederic.domaine.Commande;
import ch.hegfrederic.domaine.Employe;
import java.util.ArrayList;
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
  
  private ch.hegfrederic.metier.ListeEmployes listeEmployes;
  
  @BeforeMethod
  public void init(){
    List<ch.hegfrederic.domaine.Employe> liste = new ArrayList<>();
    liste.add(new Employe(0, "Nom0", "Prenom0"));
    liste.add(new Employe(0, "Nom1", "Prenom1"));
    liste.add(new Employe(0, "Nom2", "Prenom2"));
    liste.add(new Employe(0, "Nom3", "Prenom3"));
    liste.add(new Employe(0, "Nom4", "Prenom4"));
    List list = mock(List.class);
    listeEmployes = new ch.hegfrederic.metier.ListeEmployes(); // liste);
  }

  
  @Test(enabled=false)
  public void testAddCommande(){
    listeEmployes.setPos(0);
    int nbCommandes = listeEmployes.getCourant().getNbCommandes();
    ch.hegfrederic.domaine.Commande commande = new Commande(listeEmployes.getCourant(), new ch.hegfrederic.domaine.Capsule(0, "CapsuleTest", 0.5), 10);
    listeEmployes.addCommande(commande);
    assertNotSame(listeEmployes.getCourant().getNbCommandes(), nbCommandes);
  }
  
}