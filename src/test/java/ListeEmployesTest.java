import domaine.Commande;
import domaine.Employe;
import java.util.ArrayList;
import java.util.List;
import metier.ListeObjects;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 * 
 */
public class ListeEmployesTest {
  
  private metier.ListeEmployes listeEmployes;
  
  @BeforeMethod
  public void init(){
    List<domaine.Employe> liste = new ArrayList<>();
    liste.add(new Employe(0, "Nom0", "Prenom0"));
    liste.add(new Employe(0, "Nom1", "Prenom1"));
    liste.add(new Employe(0, "Nom2", "Prenom2"));
    liste.add(new Employe(0, "Nom3", "Prenom3"));
    liste.add(new Employe(0, "Nom4", "Prenom4"));
    listeEmployes = new metier.ListeEmployes(liste);
  }

  
  @Test
  public void testAddCommande(){
    listeEmployes.setPos(0);
    int nbCommandes = listeEmployes.getCourant().getNbCommandes();
    domaine.Commande commande = new Commande(listeEmployes.getCourant(), new domaine.Capsule(0, "CapsuleTest", 0.5), 10);
    listeEmployes.addCommande(commande);
    assertNotSame(listeEmployes.getCourant().getNbCommandes(), nbCommandes);
  }
  
}