/**
 * 
 */
package FR.IMIE;

/**
 * @author imiedev
 *
 */
public class Livre extends Object {
	private String nom;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nom;
	}
	
}
