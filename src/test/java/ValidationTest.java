import ch.hegfrederic.outils.Validation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class ValidationTest {
  
  private String strTrueInt, strTrueDouble, strFalse;
  
  @BeforeMethod
  public void init(){
    strTrueInt = "4"; strTrueDouble = "4.1"; strFalse = "03.ab";
  }
  
  @Test
  public void testIsIntValid(){
    assertTrue(Validation.isIntValid(strTrueInt));
    assertFalse(Validation.isIntValid(strTrueDouble));
    assertFalse(Validation.isIntValid(strFalse));
  }
  
  @Test
  public void testIsDoubleValid(){
    assertTrue(Validation.isDoubleValid(strTrueInt));
    assertTrue(Validation.isDoubleValid(strTrueDouble));
    assertFalse(Validation.isDoubleValid(strFalse));
  }
}
