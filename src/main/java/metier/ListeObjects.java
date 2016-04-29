package metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Liste d'Objects avec une position courante - abstract: aucune instance de ce
 * composant ne doit être créée - visibilité package: outil de base pour créer
 * des listes spécialisées dans le package.
 *
 * @author lopesmagalhaesfrederic
 *
 */
public class ListeObjects<T> {

  public static final int NO_POS = -1;
  /* Valeur de la position courante non définie */

  private List<T> liste = new ArrayList<>();
  /* Liste des Objects */
  private int pos = NO_POS;

  /* La position courante: initialement, pas de position courante */

  /**
   * Retourne la position courante. NO_POS s'il n'y en a pas.
   */
  public final int getPos() {
    return pos;
  }

  /**
   * Définit la position courante. NO_POS signifie qu'il n'y en a pas. Aucune
   * validation n'est effectuée.
   */
  public final void setPos(int pos) {
    this.pos = pos;
  }

  /**
   * Retourne le nombre d'Objects de la liste.
   */
  public final int size() {
    return liste.size();
  }

  /**
   * Retourne true ssi la liste contient l'Object o.
   */
  public final boolean contains(T o) {
    return liste.contains(o);
  }

  /**
   * Supprime l'Objet courant. Sans effet si la position courante n'est par
   * correctement définie. Postcondition: la liste n'a plus de position
   * courante.
   */
  public final void delCourant() {
    if (pos < 0 || pos >= liste.size()) {
      return;
    }
    liste.remove(pos);
    pos = NO_POS;
  } // delCourant

  /**
   * Supprime l'Objet d'indice k. Sans effet si k n'est par correctement défini.
   * Postcondition: si k == pos, la liste n'a plus de position courante.
   */
  public final void del(int k) {
    if (k < 0 || k >= liste.size()) {
      return;
    }
    liste.remove(k);
    if (pos == k) {
      pos = NO_POS;
    } else if (pos > k) {
      pos--;
    }
  }

  /**
   * Ajoute l'Objet obj en position k. Sans effet si k n'est pas correctement
   * défini.
   */
  public final void add(T obj, int k) {
    if (k < 0 || k > liste.size()) {
      return;
    }
    liste.add(k, obj);
    if (pos >= k) {
      pos++;
    }
  }

  /**
   * Retourne l'Object courant, null si la position courante n'est pas
   * correctement définie.
   */
  public T getCourant() {
    if (pos < 0 || pos >= liste.size()) {
      return null;
    }
    return liste.get(pos);
  }

  /**
   * Retourne l'Object d'indice k, null si k n'est pas correctement défini.
   */
  public T get(int k) {
    if (k < 0 || k >= liste.size()) {
      return null;
    }
    return liste.get(k);
  }

  protected void setObjects(Collection<T> objects) {
    liste.retainAll(Collections.EMPTY_LIST);
    liste.addAll(objects);
  }
}
