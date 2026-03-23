package model;
import java.awt.Color;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.mainMVC;
import view.view_accueil_disconnect;

public class model {

	// Déclarer listes et connection

	public Connection conn;
	private static ArrayList<LIVRE> ListLivre;
	private static ArrayList<AUTEUR> ListAuteur;
	private static ArrayList<ADHERENT> ListAdherent;
	public static ADHERENT adherentlogged;

	public ArrayList<ADHERENT> getListadherent(){
		return ListAdherent;
	}

	public ArrayList<AUTEUR> getListauteur(){
		return ListAuteur;
	}

	public ArrayList<LIVRE> getListlivre(){
		return ListLivre;
	}


	// Constructeur du modèle

	public model() throws ClassNotFoundException, SQLException {

		// Initialisation des listes

		ListLivre= new ArrayList<LIVRE>();
		ListAdherent= new ArrayList<ADHERENT>();
		ListAuteur= new ArrayList<AUTEUR>();

		// Connexion


		String URL = "jdbc:mysql://localhost/ap2";
		String USERNAME = "root";
		String PASSWORD = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");
		String fullURL = URL + "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		conn = DriverManager.getConnection(fullURL, USERNAME, PASSWORD);

	}

	// Renvoie l'objet auteur à partir de son num

	public static AUTEUR findAuteur (String num) {

		for(int i=0; i<ListAuteur.size();i++) {
			if(ListAuteur.get(i).getNum().equalsIgnoreCase(num)) {
				return ListAuteur.get(i);
			}

		}
		return null;

	}

	public static void setADHERENTlogged (ADHERENT newadherentlogged) {
		adherentlogged= newadherentlogged;
	}

	// Renvoie l'objet adherent à partir de son num

	public static ADHERENT findAdherent (String num) {

		for(int i=0; i<ListAdherent.size();i++) {
			if(ListAdherent.get(i).getNum().equalsIgnoreCase(num)) {
				return ListAdherent.get(i);
			}

		}
		return null;

	}


	// Renvoie l'objet livre à partir de son ISBN

	public static LIVRE findLivre (String num) {

		for(int i=0; i<ListLivre.size();i++) {
			if(ListLivre.get(i).getISBN().equalsIgnoreCase(num)) {
				return ListLivre.get(i);
			}

		}
		return null;

	}


	// Méthode pour recharger la bdd dans les listes

	public void getAll() throws SQLException {

		// On efface le contenu des listes

		ListAdherent.clear();
		ListLivre.clear();
		ListAuteur.clear();

		ListLivre = new ArrayList<LIVRE>();
		ListAuteur=new ArrayList<AUTEUR>();
		ListAdherent = new ArrayList<ADHERENT>();
		ResultSet resultat;
		String requete;
		Statement stmt = conn.createStatement();

		// On charge les auteurs de la BDD dans la liste

		requete = "SELECT * FROM AUTEUR";
		stmt=conn.createStatement();

		resultat=stmt.executeQuery(requete);

		while (resultat.next()) {
			String num = resultat.getString("num"); 
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String date_naissance = resultat.getString("date_naissance");
			String description = resultat.getString("description");


			AUTEUR auteurnew = new AUTEUR(num, nom, prenom, date_naissance, description);

			ListAuteur.add(auteurnew);
		}

		// On charge les adhérents de la bdd dans la liste

		requete = "SELECT * FROM ADHERENT";
		stmt=conn.createStatement();

		resultat=stmt.executeQuery(requete);

		while (resultat.next()) {
			String num = resultat.getString("num"); 
			String nom = resultat.getString("nom");
			String prenom = resultat.getString("prenom");
			String email = resultat.getString("email");



			ADHERENT adherentnew = new ADHERENT(num, nom, prenom, email,new ArrayList<LIVRE>());

			ListAdherent.add(adherentnew);
		}

		// On charge les livres

		ResultSet result4;
		String requete4 = "SELECT * FROM LIVRE";
		Statement stmt4=conn.createStatement();

		result4=stmt4.executeQuery(requete4);

		while (result4.next()) {
			String ISBN = result4.getString("ISBN"); 
			String titre = result4.getString("titre");
			Float prix = result4.getFloat("prix");
			String emprunteur = result4.getString("adherent");
			String auteur = result4.getString("auteur"); 
			LIVRE livrenew = new LIVRE (ISBN, titre, prix, null, null);
			if (auteur!= null) {
				livrenew.setAuteur(findAuteur(auteur));
			}

			if (emprunteur!= null) {
				ADHERENT newadherent = findAdherent(emprunteur);
				livrenew.setEmprunteur(newadherent);

				livrenew.getEmprunteur().getListLivre().add(livrenew);		





			}




			ListLivre.add(livrenew);		


		}






	}

	public void return_book (LIVRE livre) {
		String ISBN = livre.getISBN();
		String requete = "UPDATE livre SET adherent = null WHERE ISBN = ?";


		PreparedStatement pstmt;

		try {
			pstmt = conn.prepareStatement(requete);


			pstmt.setString(1, ISBN);


			int lignesModifiees = pstmt.executeUpdate();


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void borrow_book(LIVRE livre, ADHERENT adherent) {
		String ISBN=livre.getISBN();
		String a = adherent.getNum();
		String requete = "UPDATE livre SET adherent = ? WHERE ISBN = ?";
		
		PreparedStatement pstmt;
		
		try {
			pstmt=conn.prepareStatement(requete);
			
			pstmt.setString(1, a);
			pstmt.setString(2, ISBN);
			
			int lignesModifiees = pstmt.executeUpdate();
			
		}
		
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void showBookList(List list_livre) {
		list_livre.clear();
		for (int i=0; i<mainMVC.getM().getListlivre().size(); i++) {
			if ((mainMVC.getM().getListlivre().get(i).getAuteur())!=null) {
				list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
						" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
						" Auteur : " + (mainMVC.getM().getListlivre().get(i).getAuteur().getNom())) +
						" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix()));
			}
			else {
				list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
						" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
						" Auteur : Inconnu"  +
						" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix())));
			}
		}
	}

	public void showBookListAvailable(List list_livre) {
		list_livre.clear();
		for (int i=0; i<mainMVC.getM().getListlivre().size(); i++) {
			if(mainMVC.getM().getListlivre().get(i).getEmprunteur()==null) {
				if ((mainMVC.getM().getListlivre().get(i).getAuteur())!=null) {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : " + (mainMVC.getM().getListlivre().get(i).getAuteur().getNom())) +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix()));
				}
				else {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : Inconnu"  +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix())));
				}
			}
		}
	}



	public void showBookListISBN(List list_livre, String ISBN) {
		list_livre.clear();
		for (int i=0; i<mainMVC.getM().getListlivre().size(); i++) {
			if ((mainMVC.getM().getListlivre().get(i).getISBN()).equalsIgnoreCase(ISBN)) {
				if ((mainMVC.getM().getListlivre().get(i).getAuteur())!=null) {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : " + (mainMVC.getM().getListlivre().get(i).getAuteur().getNom())) +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix()));
				}
				else {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : Inconnu"  +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix())));
				}
			}
		}

	}

	public void showBookListTitle(List list_livre, String title) {
		list_livre.clear();
		for (int i=0; i<mainMVC.getM().getListlivre().size(); i++) {
			if ((mainMVC.getM().getListlivre().get(i).getTitre()).equalsIgnoreCase(title)) {
				if ((mainMVC.getM().getListlivre().get(i).getAuteur())!=null) {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : " + (mainMVC.getM().getListlivre().get(i).getAuteur().getNom())) +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix()));
				}
				else {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : Inconnu"  +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix())));
				}
			}
		}
	}

	public void showBookListAuthor(List list_livre, String author) {
		list_livre.clear();
		for (int i=0; i<mainMVC.getM().getListlivre().size(); i++) {
			if(mainMVC.getM().getListlivre().get(i).getAuteur()!=null) {
				if(mainMVC.getM().getListlivre().get(i).getAuteur().getNom().equalsIgnoreCase(author)) {
					list_livre.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : " + (mainMVC.getM().getListlivre().get(i).getAuteur().getNom())) +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix()));
				}
			}

		}

	}


	public void disconnect(JFrame frame) {
		mainMVC.getM().setADHERENTlogged(null);
		frame.setVisible(false);
		view_accueil_disconnect window_accueil_disconncect = new view_accueil_disconnect();
	}
}

