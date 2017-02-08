/**
 * 
 */
package FR.IMIE;

/**
 * @author imiedev
 *
 */
public interface IBibliotheque {
	List <Livre> ListerToutLivres();
	Emprunt creerEmprunt(Livre livre, Adherent adherent);
}
