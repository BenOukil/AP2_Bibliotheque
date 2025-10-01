import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TD_SQL_ARRAY_LIST {

	private static ArrayList<LIVRE> ListLivre = new ArrayList<>();
	private static ArrayList<AUTEUR> ListAuteur=new ArrayList<>();
	private static ArrayList<ADHERENT> ListAdherent = new ArrayList<>();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String URL = "jdbc:mysql://localhost/ap2";
		String USERNAME = "root";
		String PASSWORD = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");
		String fullURL = URL + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		Connection conn = DriverManager.getConnection(fullURL, USERNAME, PASSWORD);
		System.out.println("yes");

		ResultSet result;
		String requete = "SELECT * FROM LIVRE";

		Statement stmt=conn.createStatement();

		result=stmt.executeQuery(requete);
		System.out.println("ok");

		while(result.next()) {
			System.out.println(result.getString(1)+" - "+ result.getString(2)+" - "+ result.getFloat(3)+ " - "+ result.getString(4)+ " - " + result.getString(5) );
		}



		// AJOUT d'un Livre int maj = stmt.executeUpdate("INSERT INTO LIVRE VALUES ('9545254', 'Petit_Prince', 10, null, null)");

		ResultSet result2;
		String requete2 = "SELECT * FROM AUTEUR";
		Statement stmt2=conn.createStatement();

		result2=stmt2.executeQuery(requete2);

		while (result2.next()) {
			String num = result2.getString("num"); // adaptez le nom de colonne
			String nom = result2.getString("nom");
			String prenom = result2.getString("prenom");
			String date_naissance = result2.getString("date_naissance");
			String description = result2.getString("description");


			AUTEUR auteurnew = new AUTEUR(num, nom, prenom, date_naissance, description);

			ListAuteur.add(auteurnew);
		}

		System.out.println();
		System.out.println(ListAuteur.get(0).getNom());

		ResultSet result3;
		String requete3 = "SELECT * FROM ADHERENT";
		Statement stmt3=conn.createStatement();

		result3=stmt3.executeQuery(requete3);

		while (result3.next()) {
			String num = result3.getString("num"); // adaptez le nom de colonne
			String nom = result3.getString("nom");
			String prenom = result3.getString("prenom");
			String email = result3.getString("email");



			ADHERENT adherentnew = new ADHERENT(num, nom, prenom, email,new ArrayList<LIVRE>());

			ListAdherent.add(adherentnew);
		}

		System.out.println();
		System.out.println(ListAdherent.get(0).getNom());

		ResultSet result4;
		String requete4 = "SELECT * FROM LIVRE";
		Statement stmt4=conn.createStatement();

		result4=stmt4.executeQuery(requete4);

		while (result4.next()) {
			String ISBN = result4.getString("ISBN"); // adaptez le nom de colonne
			String titre = result4.getString("titre");
			Float prix = result4.getFloat("prix");
			String emprunteur = result4.getString("emprunteur");
			String auteur = result4.getString("auteur"); 
			LIVRE livrenew = new LIVRE (ISBN, titre, prix, null, null  );
			if (auteur!= null) {
				livrenew.setAuteur(findAuteur(auteur));
			}
			
			if (emprunteur!= null) {
				livrenew.setEmprunteur(findAdherent(emprunteur));
			}




			ListLivre.add(livrenew);

			//  System.out.println(adherent1.getListLivre().size());

			// for(int i=0; i<adh1.getListLivre().size())
		}






	}


	public static AUTEUR findAuteur (String num) {

		for(int i=0; i<ListAuteur.size();i++) {
			if(ListAuteur.get(i).getNum().equalsIgnoreCase(num)) {
				return ListAuteur.get(i);
			}

		}
		return null;

	}


	public static ADHERENT findAdherent (String num) {

		for(int i=0; i<ListAdherent.size();i++) {
			if(ListAuteur.get(i).getNum().equalsIgnoreCase(num)) {
				return ListAdherent.get(i);
			}

		}
		return null;

	}




	public static LIVRE findLivre (String num) {

		for(int i=0; i<ListLivre.size();i++) {
			if(ListLivre.get(i).getISBN().equalsIgnoreCase(num)) {
				return ListLivre.get(i);
			}

		}
		return null;

	}}


