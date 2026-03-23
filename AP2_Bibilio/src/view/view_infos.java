package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class view_infos {

	private JFrame frmBibliothqueInformations;
	ADHERENT adherentlogged = mainMVC.getM().adherentlogged ;



	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public view_infos() throws SQLException {
		mainMVC.getM().getAll();

		initialize();
		frmBibliothqueInformations.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmBibliothqueInformations = new JFrame();
		frmBibliothqueInformations.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueInformations.setTitle("Bibliothèque - Informations de Compte");
		frmBibliothqueInformations.setBounds(100, 100, 772, 638);
		frmBibliothqueInformations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueInformations.getContentPane().setLayout(null);

		JLabel lblVosInfos = new JLabel("Vos informations de compte");
		lblVosInfos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVosInfos.setFont(new Font("Arial", Font.PLAIN, 24));
		lblVosInfos.setBounds(169, 10, 429, 54);
		frmBibliothqueInformations.getContentPane().add(lblVosInfos);

		JLabel lblVotreEmail = new JLabel("Votre Email :");
		lblVotreEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblVotreEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVotreEmail.setBounds(169, 84, 101, 27);
		frmBibliothqueInformations.getContentPane().add(lblVotreEmail);

		JLabel lblVotreNom = new JLabel("Votre nom :");
		lblVotreNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblVotreNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVotreNom.setBounds(169, 121, 101, 27);
		frmBibliothqueInformations.getContentPane().add(lblVotreNom);

		JLabel lblVotrePrnom = new JLabel("Votre Prénom :");
		lblVotrePrnom.setHorizontalAlignment(SwingConstants.LEFT);
		lblVotrePrnom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVotrePrnom.setBounds(169, 158, 110, 27);
		frmBibliothqueInformations.getContentPane().add(lblVotrePrnom);

		JLabel lblEmail = new JLabel("New label");
		lblEmail.setText(adherentlogged.getEmail());
		lblEmail.setBounds(345, 93, 253, 12);
		frmBibliothqueInformations.getContentPane().add(lblEmail);

		JLabel lblnom = new JLabel("New label");
		lblnom.setText(adherentlogged.getNom());
		lblnom.setBounds(345, 130, 253, 12);
		frmBibliothqueInformations.getContentPane().add(lblnom);

		JLabel lblprenom = new JLabel("New label");
		lblprenom.setText(adherentlogged.getPrenom());
		lblprenom.setBounds(345, 167, 253, 12);
		frmBibliothqueInformations.getContentPane().add(lblprenom);

		List listEmprunt = new List();
		listEmprunt.setBounds(169, 230, 429, 300);
		frmBibliothqueInformations.getContentPane().add(listEmprunt);

		for (int i=0;i<mainMVC.getM().getListlivre().size();i++) {
			if((mainMVC.getM().getListlivre().get(i).getEmprunteur()!=null)) {
				if(mainMVC.getM().getListlivre().get(i).getEmprunteur().getNum().equalsIgnoreCase(adherentlogged.getNum())) {
					if (mainMVC.getM().getListlivre().get(i).getAuteur()!=null) {
					listEmprunt.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
							" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
							" Auteur : " + (mainMVC.getM().getListlivre().get(i).getAuteur().getNom())) +
							" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix()));
					}
					else {
						listEmprunt.add(("ISBN : " + (mainMVC.getM().getListlivre().get(i).getISBN()) +
								" Titre : " + (mainMVC.getM().getListlivre().get(i).getTitre()) +
								" Auteur : Inconnu"  +
								" Prix : " + (mainMVC.getM().getListlivre().get(i).getPrix())));
					}
				}
				
			}
		}


		JLabel lblListeDesLivres = new JLabel("Liste des livres empruntés :");
		lblListeDesLivres.setHorizontalAlignment(SwingConstants.LEFT);
		lblListeDesLivres.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListeDesLivres.setBounds(169, 195, 338, 27);
		frmBibliothqueInformations.getContentPane().add(lblListeDesLivres);
		
		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adherentlogged== null) {
					frmBibliothqueInformations.setVisible(false);
					view_accueil_disconnect window_accueil_disconnect = new view_accueil_disconnect();
					}
					else {
						frmBibliothqueInformations.setVisible(false);
						view_accueil_connect window_accueil_connect = new view_accueil_connect();
					}
			}
		});
		btnAccueil.setBounds(317, 571, 107, 20);
		frmBibliothqueInformations.getContentPane().add(btnAccueil);
		JButton btnDisconnect = new JButton("Deconnexion");
		if (adherentlogged==null) {
			btnDisconnect.setVisible(false);
		}
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMVC.getM().disconnect(frmBibliothqueInformations);
			}
		});
		btnDisconnect.setBounds(632, 571, 116, 20);
		frmBibliothqueInformations.getContentPane().add(btnDisconnect);
	}
}
