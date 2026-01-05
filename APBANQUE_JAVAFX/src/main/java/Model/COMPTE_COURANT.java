package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;





public class COMPTE_COURANT extends COMPTE {
	private String numero_cb;
	private float decouvert_max;



	public COMPTE_COURANT(long numero, CLIENT titulaire, float solde, String devise, String numero_cb,
			float decouvert_max) {
		super(numero, titulaire, solde, devise);
		this.numero_cb = numero_cb;
		this.decouvert_max = decouvert_max;
	}
	public String getNumero_cb() {
		return numero_cb;
	}
	public void setNumero_cb(String numero_cb) {
		this.numero_cb = numero_cb;
	}
	public float getDecouvert_max() {
		return decouvert_max;
	}
	public void setDecouvert_max(float decouvert_max) {
		this.decouvert_max = decouvert_max;
	}

	public void debiter(float montant) {
		if (montant<= (super.solde) / 2){
			super.solde= super.solde - montant ;
		}
	}








}
