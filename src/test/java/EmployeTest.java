import domaine.Capsule;
import domaine.Commande;
import domaine.Employe;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 * 
 */
public class EmployeTest {

  private domaine.Employe employe;

  private List<domaine.Commande> setUpCommande(){
    List<Commande> commandes = new ArrayList<>();
    commandes.add(new Commande(employe, new Capsule(0, "caps1", 0.5), 10));
    commandes.add(new Commande(employe, new Capsule(1, "caps2", 0.75), 10));
    return commandes;
  }

  @BeforeMethod
  public void setUp() throws Exception {
    employe = new Employe(0, "UserTest", "Test");
    List<Commande> commandes = setUpCommande();
    employe.setCommandes(commandes);
  }
  
  // @AfterMethod
  
  @Test
  public void testGetTotalCommandes(){
    double initTotal = employe.getTotalCommandes();
    employe.addCommande(new Commande(employe, new Capsule(3, "caps3", 0.3), 10));
    // assertTrue(initTotal + 3 == employe.getTotalCommandes());
    assertEquals(initTotal+3,employe.getTotalCommandes());
  }
  
  @Test
  public void testAddCommande(){
    int nbCommandes = employe.getNbCommandes();
    employe.addCommande(new Commande(employe, new Capsule(3, "caps3", 0.3), 10));
    assertEquals(employe.getNbCommandes(), 3);
  }
  
  @Test
  public void testAddNombre(){
    Commande commande = employe.getCommande(0);
    int qt = commande.getNombre();
    commande.addNombre(qt);
    assertEquals(commande.getNombre(),qt*2);
  }
  
}