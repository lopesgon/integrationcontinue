package ch.hegfrederic.presentation;

import ch.hegfrederic.domaine.Employe;
import ch.hegfrederic.metier.ListeEmployes;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 * 
 */
public class FrmMainTest {
  
  private FrmMain fm;
  private final String EMP_TEXT = "employeTest";
  
  @BeforeMethod
  public void init(){
    ListeEmployes mockedListe = mock(ch.hegfrederic.metier.ListeEmployes.class);
    Employe mockedEmploye = mock(ch.hegfrederic.domaine.Employe.class);
    when(mockedEmploye.toString()).thenReturn(EMP_TEXT);
    when(mockedListe.getCourant()).thenReturn(mockedEmploye);
    when(mockedListe.size()).thenReturn(1);
    fm = new FrmMain(mockedListe);
  }
  
  /*
  @Test(enabled=true)
  public void testUpdateComposantsEmploye(){
      fm.updateComposantsEmploye();
      assertEquals(fm.lblCommandes, EMP_TEXT);
  }
  */
  
}