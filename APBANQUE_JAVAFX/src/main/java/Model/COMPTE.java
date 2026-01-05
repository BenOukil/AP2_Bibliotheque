package Model;
import java.util.Date;

public abstract class  COMPTE {
	protected long numero;
	protected CLIENT titulaire;
	protected float solde;
	protected String devise;
	
	// Q2
	
	public COMPTE(long numero, CLIENT titulaire, float solde, String devise) {
		super();
		this.numero = numero;
		this.titulaire = titulaire;
		this.solde = solde;
		this.devise = devise;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public CLIENT getTitulaire() {
		return titulaire;
	}
	public void setTitulaire(CLIENT titulaire) {
		this.titulaire = titulaire;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	
	// Q3
	
	public void debiter(float montant) {
		solde=solde - montant;
	}
	
	public void crediter(float montant) {
		solde=solde + montant;
	}
	
	// Q4
	
	public void Decrire() {
		System.out.println("n° de compte : " + numero + " - solde : " + solde + " €");
	}
	
	
	
	
	
}
