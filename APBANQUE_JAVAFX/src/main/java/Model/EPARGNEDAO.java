package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EPARGNEDAO {
	
	public int ADD(int numero, float solde, String devise, int idClient, float interet ) throws SQLException, ClassNotFoundException {

		Connection conn = ConnectionFactory.get();
		
		
		String requete = "INSERT INTO compte (numero, solde, devise, idClient) VALUES (?, ?, ?, ?)";
		System.out.println(requete);
		PreparedStatement pstmt = conn.prepareStatement(requete);
		pstmt.setInt(1, numero);
		pstmt.setFloat(2, (float) solde);
		pstmt.setString(3, devise);

		pstmt.setInt(4, idClient);
		
		System.out.println(pstmt);
		

		int lignesModifiees = pstmt.executeUpdate();
		
		requete = "SELECT MAX(id) FROM compte";
		PreparedStatement pstmt2 = conn.prepareStatement(requete);
		System.out.println(pstmt2);
		ResultSet resultat = pstmt2.executeQuery();

		int idCompte = 0; 
		if (resultat.next()) {
		    idCompte = resultat.getInt(1);
		   
		}
		System.out.println(idCompte);
		
		
		
		requete = "INSERT INTO epargne (id, interet ) VALUES (?,?) ";
		PreparedStatement pstmt3 = conn.prepareStatement(requete);
		
		
		pstmt3.setInt(1, idCompte);
		pstmt3.setFloat(2, interet);
		
		System.out.println(pstmt3);
		int verif = pstmt3.executeUpdate();
		System.out.println(verif);
		
		return verif;



	}
}
