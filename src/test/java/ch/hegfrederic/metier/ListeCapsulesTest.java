/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegfrederic.metier;

import ch.hegfrederic.base.CapsuleDao;
import ch.hegfrederic.domaine.Capsule;
import org.mockito.*;
import static org.mockito.Mockito.when;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class ListeCapsulesTest {
  
  private ListeCapsules listeCapsules;
  
  @BeforeMethod
  public void init(){
    CapsuleDao mockedCapsuleDao = Mockito.mock(ch.hegfrederic.base.CapsuleDao.class);
    java.util.List<ch.hegfrederic.domaine.Capsule> list = new java.util.ArrayList<>();
    list.add(new Capsule(0, "capsuleTest", 0.50));
    when(mockedCapsuleDao.getListeCapsules()).thenReturn(list);
    listeCapsules = new ListeCapsules(mockedCapsuleDao);
    listeCapsules.init();
  }

}
