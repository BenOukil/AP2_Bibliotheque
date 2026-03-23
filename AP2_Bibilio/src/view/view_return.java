package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class view_return {

	private JFrame frmBibliothqueRetourner;
	private JTextField textISBNReturn;
	ADHERENT adherentlogged = mainMVC.getM().adherentlogged ;



	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public view_return() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frmBibliothqueRetourner.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliothqueRetourner = new JFrame();
		frmBibliothqueRetourner.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueRetourner.setTitle("Bibliothèque - Retourner un Livre");
		frmBibliothqueRetourner.setBounds(100, 100, 777, 500);
		frmBibliothqueRetourner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueRetourner.getContentPane().setLayout(null);



		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adherentlogged== null) {
					frmBibliothqueRetourner.setVisible(false);
					view_accueil_disconnect window_accueil_disconnect = new view_accueil_disconnect();
				}
				else {
					frmBibliothqueRetourner.setVisible(false);
					view_accueil_connect window_accueil_connect = new view_accueil_connect();
				}
			}
		});
		btnAccueil.setBounds(328, 433, 107, 20);
		frmBibliothqueRetourner.getContentPane().add(btnAccueil);

		JLabel lblRetourLivre = new JLabel("Retourner un Livre");
		lblRetourLivre.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetourLivre.setFont(new Font("Arial", Font.PLAIN, 24));
		lblRetourLivre.setBounds(167, 10, 429, 54);
		frmBibliothqueRetourner.getContentPane().add(lblRetourLivre);

		JLabel lblVerif = new JLabel("Erreur. Cette ISBN ne correspond à aucun livre.");
		lblVerif.setForeground(new Color(255, 0, 0));
		lblVerif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVerif.setVisible(false);
		lblVerif.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerif.setBounds(220, 273, 322, 36);
		frmBibliothqueRetourner.getContentPane().add(lblVerif);

		JLabel lblEntrerISBN = new JLabel("Entrez l'ISBN du livre que vous souhaitez rendre :");
		lblEntrerISBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntrerISBN.setBounds(220, 110, 322, 54);
		frmBibliothqueRetourner.getContentPane().add(lblEntrerISBN);

		textISBNReturn = new JTextField();
		textISBNReturn.setHorizontalAlignment(SwingConstants.CENTER);
		textISBNReturn.setBounds(220, 174, 322, 18);
		frmBibliothqueRetourner.getContentPane().add(textISBNReturn);
		textISBNReturn.setColumns(10);

		JButton btnReturnLivre = new JButton("Confirmer");
		btnReturnLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBNreturn = textISBNReturn.getText();
				Connection conn = mainMVC.getM().conn;
				

				LIVRE l = mainMVC.getM().findLivre(ISBNreturn);

				if(l==null) {
					lblVerif.setText("Erreur. Cette ISBN ne correspond à aucun livre.");
					lblVerif.setForeground(new Color(255,0, 0));
					lblVerif.setVisible(true);
				}

				else {

					if (l.getEmprunteur()==null) {	
						lblVerif.setText("Erreur. Cette ISBN correspond à un livre disponible.");
						lblVerif.setForeground(new Color(255,0, 0));
						lblVerif.setVisible(true);
					}
					else {

						mainMVC.getM().return_book(l);
						lblVerif.setText("Votre livre a été retourné.");
						lblVerif.setForeground(new Color(0, 255, 0));
						lblVerif.setVisible(true);


					}



				}
			}
		});
		btnReturnLivre.setBounds(304, 228, 147, 20);
		frmBibliothqueRetourner.getContentPane().add(btnReturnLivre);

		JButton btnDisconnect = new JButton("Deconnexion");
		if (adherentlogged==null) {
			btnDisconnect.setVisible(false);
		}
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMVC.getM().disconnect(frmBibliothqueRetourner);
			}
		});
		btnDisconnect.setBounds(637, 433, 116, 20);
		frmBibliothqueRetourner.getContentPane().add(btnDisconnect);


	}
}
