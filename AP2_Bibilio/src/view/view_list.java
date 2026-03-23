package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.Color;
import java.awt.Toolkit;

public class view_list {

	private JFrame frmBibliothqueListe;
	private JTextField textFieldISBN;
	private JTextField textFieldTitre;
	private JTextField textFieldAuteur;
	ADHERENT adherentlogged = mainMVC.getM().adherentlogged ;



	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public view_list() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frmBibliothqueListe.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliothqueListe = new JFrame();
		frmBibliothqueListe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueListe.setTitle("Bibliothèque - Liste des livres");
		frmBibliothqueListe.setBounds(100, 100, 756, 569);
		frmBibliothqueListe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueListe.getContentPane().setLayout(null);

		JLabel lblListeDesLivres = new JLabel("Liste des livres");
		lblListeDesLivres.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesLivres.setFont(new Font("Arial", Font.PLAIN, 24));
		lblListeDesLivres.setBounds(159, 0, 429, 54);
		frmBibliothqueListe.getContentPane().add(lblListeDesLivres);
		
		List list_livre = new List();
		list_livre.setBounds(10, 111, 722, 378);
		frmBibliothqueListe.getContentPane().add(list_livre);
		mainMVC.getM().showBookList(list_livre);


		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adherentlogged== null) {
				frmBibliothqueListe.setVisible(false);
				view_accueil_disconnect window_accueil_disconnect = new view_accueil_disconnect();
				}
				else {
					frmBibliothqueListe.setVisible(false);
					view_accueil_connect window_accueil_connect = new view_accueil_connect();
				}

			}
		});
		btnAccueil.setBounds(322, 495, 107, 20);
		frmBibliothqueListe.getContentPane().add(btnAccueil);

		JLabel lblNewLabel = new JLabel("Rechercher un livre par ISBN :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 57, 256, 20);
		frmBibliothqueListe.getContentPane().add(lblNewLabel);

		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(10, 87, 134, 18);
		frmBibliothqueListe.getContentPane().add(textFieldISBN);
		textFieldISBN.setColumns(10);

		JLabel lblRechercherUnLivre = new JLabel("Rechercher un livre par Titre :");
		lblRechercherUnLivre.setHorizontalAlignment(SwingConstants.LEFT);
		lblRechercherUnLivre.setBounds(212, 54, 287, 27);
		frmBibliothqueListe.getContentPane().add(lblRechercherUnLivre);

		textFieldTitre = new JTextField();
		textFieldTitre.setColumns(10);
		textFieldTitre.setBounds(212, 87, 191, 18);
		frmBibliothqueListe.getContentPane().add(textFieldTitre);

		JLabel lblNewLabel_1_1 = new JLabel("Rechercher un livre par Auteur :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(480, 54, 252, 27);
		frmBibliothqueListe.getContentPane().add(lblNewLabel_1_1);

		textFieldAuteur = new JTextField();
		textFieldAuteur.setColumns(10);
		textFieldAuteur.setBounds(482, 87, 197, 18);
		frmBibliothqueListe.getContentPane().add(textFieldAuteur);

		JButton btnISBN = new JButton("");
		btnISBN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = textFieldISBN.getText();
				mainMVC.getM().showBookListISBN(list_livre, ISBN);

			}
		});
		btnISBN.setBackground(new Color(128, 128, 128));
		btnISBN.setBounds(154, 85, 33, 20);
		frmBibliothqueListe.getContentPane().add(btnISBN);

		JButton btnTitre = new JButton("");
		btnTitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textFieldTitre.getText();
				mainMVC.getM().showBookListTitle(list_livre, title);
			}
		});
		btnTitre.setBackground(new Color(128, 128, 128));
		btnTitre.setBounds(413, 85, 33, 20);
		frmBibliothqueListe.getContentPane().add(btnTitre);

		JButton btnAuteur = new JButton("");
		btnAuteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String author =textFieldAuteur.getText();
				mainMVC.getM().showBookListAuthor(list_livre, author);
			}
		});
		btnAuteur.setBackground(new Color(128, 128, 128));
		btnAuteur.setBounds(688, 85, 33, 20);
		frmBibliothqueListe.getContentPane().add(btnAuteur);

		
		
		JButton btnDisconnect = new JButton("Deconnexion");
		if (adherentlogged==null) {
			btnDisconnect.setVisible(false);
		}
		else {
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMVC.getM().disconnect(frmBibliothqueListe);
			}
		});
		btnDisconnect.setBounds(616, 495, 116, 20);
		frmBibliothqueListe.getContentPane().add(btnDisconnect); }
		
		JButton btnReset = new JButton("Réinitialiser");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMVC.getM().showBookList(list_livre);
			}
		});
		btnReset.setBounds(20, 495, 116, 20);
		frmBibliothqueListe.getContentPane().add(btnReset);
	}
}
