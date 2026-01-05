package Model;


public class EPARGNE extends COMPTE {

	private float interet;

	public EPARGNE(long numero, CLIENT titulaire, float solde, String devise, float interet) {
		super(numero, titulaire, solde, devise);
		this.interet = interet;
	}

	public float getInteret() {
		return interet;
	}

	public void setInteret(float interet) {
		this.interet = interet;
	}

	// Q9

	public void Decrire() {
		System.out.println("n° de compte : " + super.numero + " - solde : " + super.solde + " € - taux = " + interet*100 + " %");
	}

	//Q10

	public void ajouter_interet() {
		if (super.solde > 0)
			super.solde = super.solde + super.solde*interet;
	}



}


