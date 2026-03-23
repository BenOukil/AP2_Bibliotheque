package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.List;

public class view_borrow {

	private JFrame frmBibliothqueEmprunt;
	ADHERENT adherentlogged = mainMVC.getM().adherentlogged ;
	private JTextField textFieldBorrow;
	

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public view_borrow() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frmBibliothqueEmprunt.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliothqueEmprunt = new JFrame();
		frmBibliothqueEmprunt.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueEmprunt.setTitle("Bibliothèque - Emprunt");
		frmBibliothqueEmprunt.setBounds(100, 100, 779, 663);
		frmBibliothqueEmprunt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueEmprunt.getContentPane().setLayout(null);
		
		
		JLabel lblVerif = new JLabel("New label");
		lblVerif.setVisible(false);
		lblVerif.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVerif.setBounds(215, 215, 322, 12);
		frmBibliothqueEmprunt.getContentPane().add(lblVerif);
		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adherentlogged== null) {
					frmBibliothqueEmprunt.setVisible(false);
					view_accueil_disconnect window_accueil_disconnect = new view_accueil_disconnect();
					}
					else {
						frmBibliothqueEmprunt.setVisible(false);
						view_accueil_connect window_accueil_connect = new view_accueil_connect();
					}
			}
		});
		btnAccueil.setBounds(321, 596, 107, 20);
		frmBibliothqueEmprunt.getContentPane().add(btnAccueil);
		
		JButton btnDisconnect = new JButton("Deconnexion");
		if (adherentlogged==null) {
			btnDisconnect.setVisible(false);
		}
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMVC.getM().disconnect(frmBibliothqueEmprunt);
			}
		});
		btnDisconnect.setBounds(639, 596, 116, 20);
		frmBibliothqueEmprunt.getContentPane().add(btnDisconnect);
		
		JLabel lblEmprunterUnLivre = new JLabel("Emprunter un livre");
		lblEmprunterUnLivre.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprunterUnLivre.setFont(new Font("Arial", Font.PLAIN, 24));
		lblEmprunterUnLivre.setBounds(153, 10, 429, 54);
		frmBibliothqueEmprunt.getContentPane().add(lblEmprunterUnLivre);
		
		List list = new List();
		list.setBounds(53, 260, 655, 312);
		frmBibliothqueEmprunt.getContentPane().add(list);
		
		JLabel lblListeDesLivres = new JLabel("Liste des livres disponibles :");
		lblListeDesLivres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListeDesLivres.setBounds(53, 215, 356, 54);
		frmBibliothqueEmprunt.getContentPane().add(lblListeDesLivres);
		
		mainMVC.getM().showBookListAvailable(list);
		
		JLabel lblEntrerISBN = new JLabel("Entrez l'ISBN du livre que vous souhaitez emprunter :");
		lblEntrerISBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntrerISBN.setBounds(203, 93, 356, 54);
		frmBibliothqueEmprunt.getContentPane().add(lblEntrerISBN);
		
		textFieldBorrow = new JTextField();
		textFieldBorrow.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldBorrow.setColumns(10);
		textFieldBorrow.setBounds(215, 157, 322, 18);
		frmBibliothqueEmprunt.getContentPane().add(textFieldBorrow);
		
		JButton btnBorrowLivre = new JButton("Confirmer");
		btnBorrowLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ISBNborrow = textFieldBorrow.getText();
				Connection conn = mainMVC.getM().conn;
			

				LIVRE l = mainMVC.getM().findLivre(ISBNborrow);
				ADHERENT a = mainMVC.getM().adherentlogged;
				
				if(l==null) {
					lblVerif.setText("Erreur. Cette ISBN ne correspond à aucun livre.");
					lblVerif.setForeground(new Color(255,0, 0));
					lblVerif.setVisible(true);
				}
				else if (l.getEmprunteur()==null) {
					mainMVC.getM().borrow_book(l, a);
					try {
						mainMVC.getM().getAll();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainMVC.getM().showBookListAvailable(list);
					lblVerif.setText("Vous avez emprunté le livre avec succès.");
					lblVerif.setForeground(new Color(0, 255, 0));
					lblVerif.setVisible(true);
					
				}
				else {
					lblVerif.setText("Erreur. Cette ISBN correspond à un livre non disponible.");
					lblVerif.setForeground(new Color(255,0, 0));
					lblVerif.setVisible(true);
				}
				
				
		
							
					
				
				
				
			}
		});
		btnBorrowLivre.setBounds(300, 185, 147, 20);
		frmBibliothqueEmprunt.getContentPane().add(btnBorrowLivre);
		
		
		
		
	}
}
