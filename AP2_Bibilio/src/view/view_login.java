package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.mainMVC;
import model.ADHERENT;
import model.model;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class view_login {

	private JFrame frmBibliothqueConnexion;
	private JTextField textFieldNomUtilisateur;
	private JTextField textFieldMotDePasse;
	private String login="";
	private String mdp="";
	private int verif = 0;
	ADHERENT adherentlogged = mainMVC.getM().adherentlogged ;
	

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public view_login() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frmBibliothqueConnexion.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliothqueConnexion = new JFrame();
		frmBibliothqueConnexion.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueConnexion.setTitle("Bibliothèque - Connexion");
		frmBibliothqueConnexion.setBounds(100, 100, 771, 568);
		frmBibliothqueConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueConnexion.getContentPane().setLayout(null);
		
		
		JLabel lblVerif = new JLabel("Erreur de connexion.");
		lblVerif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVerif.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerif.setForeground(new Color(255, 0, 0));
		lblVerif.setBounds(153, 273, 379, 12);
		frmBibliothqueConnexion.getContentPane().add(lblVerif);
		lblVerif.setVisible(false);
		
		JLabel lblConnexion = new JLabel("Connexion à votre compte");
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setFont(new Font("Arial", Font.PLAIN, 24));
		lblConnexion.setBounds(153, 10, 429, 54);
		frmBibliothqueConnexion.getContentPane().add(lblConnexion);
		
		JLabel lblNomUtilisateur = new JLabel("Email de l'utilisateur :");
		lblNomUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomUtilisateur.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomUtilisateur.setBounds(153, 151, 152, 27);
		frmBibliothqueConnexion.getContentPane().add(lblNomUtilisateur);
		
		JLabel lblmdp = new JLabel("Numéro de carte :");
		lblmdp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmdp.setHorizontalAlignment(SwingConstants.LEFT);
		lblmdp.setBounds(153, 220, 152, 27);
		frmBibliothqueConnexion.getContentPane().add(lblmdp);
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setBounds(315, 151, 217, 27);
		frmBibliothqueConnexion.getContentPane().add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		
		textFieldMotDePasse = new JTextField();
		textFieldMotDePasse.setColumns(10);
		textFieldMotDePasse.setBounds(315, 220, 217, 27);
		frmBibliothqueConnexion.getContentPane().add(textFieldMotDePasse);
		
		JButton btnConnexion = new JButton("Confirmer");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login=textFieldNomUtilisateur.getText();
				mdp=textFieldMotDePasse.getText();
				ArrayList<ADHERENT> listAdherents= mainMVC.getM().getListadherent();
				for(int i=0;i<listAdherents.size(); i++) {
					if(login.equalsIgnoreCase(listAdherents.get(i).getEmail()) && mdp.equalsIgnoreCase(listAdherents.get(i).getNum()) ) {
						mainMVC.getM();
						model.setADHERENTlogged(listAdherents.get(i));
						verif=1;
					}
					
				}
				if (verif==1) {
					frmBibliothqueConnexion.setVisible(false);
					view_accueil_connect window_accueil_connnect = new view_accueil_connect();
				}
				else {
					lblVerif.setVisible(true);
				}
				
			  
			}
		});
		btnConnexion.setBounds(291, 308, 160, 27);
		frmBibliothqueConnexion.getContentPane().add(btnConnexion);
		
		JButton btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adherentlogged== null) {
					frmBibliothqueConnexion.setVisible(false);
					view_accueil_disconnect window_accueil_disconnect = new view_accueil_disconnect();
					}
					else {
						frmBibliothqueConnexion.setVisible(false);
						view_accueil_connect window_accueil_connect = new view_accueil_connect();
					}
			}
		});
		btnAccueil.setBounds(317, 501, 107, 20);
		frmBibliothqueConnexion.getContentPane().add(btnAccueil);
		
		
	}
}
