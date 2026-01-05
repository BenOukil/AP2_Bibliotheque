package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CLIENTDAO {
	
	public void ADD(String nom, String prenom, int genre, Date dateN, String categ, String adresse, String tel, String email) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionFactory.get();
		Statement stmt = conn.createStatement();
		String requete = "INSERT INTO client (nom, prenom, genre, dateN, categ, adresse, tel, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(requete);
		pstmt.setString(1, nom);
		pstmt.setString(2, prenom);
		pstmt.setInt(3, genre);

		pstmt.setDate(4, dateN);

		pstmt.setString(5, categ);
		pstmt.setString(6, adresse);
		pstmt.setString(7, tel);
		pstmt.setString(8, email);

		int rowsAffected = pstmt.executeUpdate();
		
		


	}
	
	public boolean UPDATE(int id, String nom, String prenom, int genre, Date dateN, String categ, String adresse, String tel, String email) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.get();
		Statement stmt = conn.createStatement();
		String requete = "UPDATE client SET nom= ?,"
				+ "prenom= ?,"
				+ "genre = ?,"
				+ "dateN = ?,"
				+ "categ= ?,"
				+ "adresse = ?,"
				+ "tel= ?,"
				+ "email = ?"
				+ "WHERE id = ?  ";

		PreparedStatement pstmt = conn.prepareStatement(requete);
		pstmt.setString(1, nom);
		pstmt.setString(2, prenom);
		pstmt.setInt(3, genre);

		pstmt.setDate(4, dateN);

		pstmt.setString(5, categ);
		pstmt.setString(6, adresse);
		pstmt.setString(7, tel);
		pstmt.setString(8, email);
		pstmt.setInt(9, id);

		int rowsAffected = pstmt.executeUpdate();
		
		if (rowsAffected==1) {
			return true;
		}
		else return false;
	}
	
	public int findidClientEmail(String email) throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.get();
		String requete = "SELECT id FROM client WHERE email = ?";
		PreparedStatement stmt = conn.prepareStatement(requete);

		stmt.setString(1, email);
		

		ResultSet resultat = stmt.executeQuery(); 

		if (resultat.next()) {
			int id = resultat.getInt("id");
			return id;
		} else {
			return 0; 
		}
		
	}
	
	public CLIENT findClient(String email) throws SQLException, ClassNotFoundException {
		
		CLIENT newclient = new CLIENT(null, null, null, null, null, null, null, null);
		
		Connection conn = ConnectionFactory.get();
		String requete = "SELECT * FROM client WHERE email = ?";
		PreparedStatement pstmt = conn.prepareStatement(requete);
		pstmt.setString(1, email);
		
		ResultSet resultat = pstmt.executeQuery();
		
		if (resultat.next()) { // revoir la gestion des données
			
			newclient.setNom(resultat.getString("nom"));
			newclient.setPrenom(resultat.getString("prenom"));
			newclient.setGenre(resultat.getInt("genre"));
			newclient.setDate_de_naissance(resultat.getDate("dateN"));
			newclient.setCateg_pro(resultat.getString("categ"));
			newclient.setAdresse_full(resultat.getString("adresse"));
			newclient.setTel(resultat.getString("tel"));
			newclient.setEmail(resultat.getString("email"));
			
			return newclient;
			
		} else {
			return null; 
		}
		
		
		
	}

}
