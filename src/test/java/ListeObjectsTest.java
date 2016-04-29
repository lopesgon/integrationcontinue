import java.util.ArrayList;
import metier.ListeObjects;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class ListeObjectsTest {
  
  private class Toto{
    private int id;
    private String libelle;
    
    public Toto(int id, String libelle){
      this.id = id; this.libelle = libelle;
    }
    
    public boolean equals(Object o){
      return this.id == ((Toto)o).id;
    }
  }
  
  private metier.ListeObjects<Toto> listTotos;
  
  @BeforeMethod
  public void init(){
    listTotos = new ListeObjects<>();
    listTotos.add(new Toto(0, "Toto0"), 0);
    listTotos.add(new Toto(1, "Toto1"), 1);
    listTotos.add(new Toto(2, "Toto2"), 2);
    listTotos.add(new Toto(3, "Toto3"), 3);
    listTotos.add(new Toto(4, "Toto4"), 4);
  }
  
  @Test
  public void testContains(){
    Toto toto = new Toto(10, "Toto10");
    listTotos.add(toto, 0);
    assertTrue(listTotos.contains(toto));
  }
  
  @Test
  public void testAdd(){
    Toto toto = new Toto(5, "Toto5");
    listTotos.setPos(0);
    Toto toto0 = listTotos.getCourant();
    listTotos.add(toto, 0);
    Toto totorecup = listTotos.get(0);
    assertEquals(toto.libelle,totorecup.libelle);
    assertEquals(toto0, listTotos.getCourant());
  }
  
  @Test
  public void testGet(){
    assertTrue(listTotos.get(-1) == null);
    assertTrue(listTotos.get(5) == null);
  }
  
  @Test
  public void testGetCourant(){
    listTotos.setPos(10);
    assertEquals(listTotos.getCourant(), null);
    Toto toto = listTotos.get(0);
    listTotos.setPos(0);
    assertEquals(listTotos.getCourant(), toto);
  }
  
  @Test
  public void testDelCourant(){
    Toto toto = listTotos.get(0);
    listTotos.setPos(-1);
    listTotos.delCourant();
    assertEquals(listTotos.get(0), toto);
    listTotos.setPos(0);
    listTotos.delCourant();
    assertNotSame(listTotos.get(0), toto);
  }
  
  @Test
  public void testDel(){
    listTotos.setPos(3);
    Toto toto = listTotos.get(3);
    listTotos.del(3);
    assertNotSame(toto, listTotos.get(3));
    assertEquals(listTotos.getPos(), -1);
    listTotos.setPos(3);
    listTotos.del(2);
    assertEquals(listTotos.getPos(), 2);
  }

  @Test
  public void testSetObjects(){
    java.util.List<Toto> lst = new ArrayList<>();
    lst.add(new Toto(-1, "TotoTest"));
    class MaListe extends ListeObjects<Toto> {
      public MaListe(java.util.List<Toto> lst){
        setObjects(lst);
      }
    }
    MaListe maliste = new MaListe(lst);
    assertEquals(maliste.get(0), lst.get(0));
  }

}