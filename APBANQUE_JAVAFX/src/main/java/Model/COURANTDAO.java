package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class COURANTDAO {
	
	public int ADD(int numero, float solde, String devise, int idClient, int numCB, int decouvert ) throws SQLException, ClassNotFoundException {

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
		
		
		
		requete = "INSERT INTO courant (id, numCB, decouvert ) VALUES (?,?,?) ";
		PreparedStatement pstmt3 = conn.prepareStatement(requete);
		
		
		pstmt3.setInt(1, idCompte);
		pstmt3.setInt(2, numCB);
		pstmt3.setInt(3, decouvert);
		System.out.println(pstmt3);
		int verif = pstmt3.executeUpdate();
		
		return verif;



	}
	
	public int findIdCompte(int numero) throws SQLException, ClassNotFoundException {
		
		Connection conn = ConnectionFactory.get();
		String requete = "SELECT id FROM compte WHERE numero = ?";
		PreparedStatement stmt = conn.prepareStatement(requete);

		stmt.setInt(1, numero);
		

		ResultSet resultat = stmt.executeQuery(); 

		if (resultat.next()) {
			int id = resultat.getInt("id");
			return id;
		} else {
			return 0; 
		}
		
		
	}
	
		/*public boolean findCourantOrEpargne (int numero) throws ClassNotFoundException, SQLException {
			
			int id = findIdCompte(numero);
			Connection conn = ConnectionFactory.get();
			String requete = "SELECT id FROM epargne WHERE  id = ?";
			PreparedStatement pstmt = conn.prepareStatement(requete);
			pstmt.setInt(1, id);
			ResultSet resultat = pstmt.executeQuery(); 

			if (resultat.next()) {
				int id = resultat.getInt("id");
				return id;
			} else {
				return 0; 
			}
			*/
			
				
				
			
			
			
		
	
	
	/*public COMPTE_COURANT findCompteNumero(int numero) {
		
	COMPTE_COURANT newcompte = new COMPTE_COURANT(0, null, 0, null, null, 0);
			
			Connection conn = ConnectionFactory.get();
			String requete = "SELECT * FROM compte WHERE numero = ?";
			PreparedStatement pstmt = conn.prepareStatement(requete);
			pstmt.setInt(1, numero);
			
			ResultSet resultat = pstmt.executeQuery();
			
			if (resultat.next()) { // revoir la gestion des données
				
				newcompte.setNom(resultat.getString("nom"));
				newcompte.setPrenom(resultat.getString("prenom"));
				newcompte.setGenre(resultat.getInt("genre"));
				newcompte.setDate_de_naissance(resultat.getDate("dateN"));
				newcompte.setCateg_pro(resultat.getString("categ"));
				newcompte.setAdresse_full(resultat.getString("adresse"));
				newcompte.setTel(resultat.getString("tel"));
				newcompte.setEmail(resultat.getString("email"));
				
				return newcompte;
				
			} else {
				return null; 
			}
			*/
		} 


