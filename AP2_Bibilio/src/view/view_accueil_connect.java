package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controller.mainMVC;
import model.ADHERENT;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class view_accueil_connect {

	private JFrame frmBibliothqueAccueil;
	ADHERENT adherentlogged = mainMVC.getM().adherentlogged ;

	

	/**
	 * Create the application.
	 */
	public view_accueil_connect() {
		initialize();
		frmBibliothqueAccueil.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliothqueAccueil = new JFrame();
		frmBibliothqueAccueil.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueAccueil.setTitle("Bibliothèque - Accueil");
		frmBibliothqueAccueil.setBounds(100, 100, 756, 549);
		frmBibliothqueAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueAccueil.getContentPane().setLayout(null);
		
		JLabel lblInfoCompte = new JLabel("New label");
		lblInfoCompte.setBounds(10, 490, 542, 12);
		frmBibliothqueAccueil.getContentPane().add(lblInfoCompte);
		lblInfoCompte.setText("Vous êtes connecté en tant que : " + adherentlogged.getPrenom()+ " "+ adherentlogged.getNom() );
		
		JLabel lblTouchezUneOption = new JLabel("Touchez une option ci-dessous pour commencer");
		lblTouchezUneOption.setBounds(148, 91, 438, 24);
		lblTouchezUneOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblTouchezUneOption.setFont(new Font("Arial", Font.PLAIN, 20));
		frmBibliothqueAccueil.getContentPane().add(lblTouchezUneOption);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(87, 181, 219, 228);
		frmBibliothqueAccueil.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEmprunter = new JButton("Emprunter");
		btnEmprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBibliothqueAccueil.setVisible(false);
				try {
					view_borrow window_borrow = new view_borrow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEmprunter.setBounds(10, 45, 199, 52);
		panel.add(btnEmprunter);
		
		JButton btnVosInfos = new JButton("Vos informations");
		btnVosInfos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBibliothqueAccueil.setVisible(false);
				try {
					view_infos window_infos = new view_infos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVosInfos.setBounds(10, 127, 199, 52);
		panel.add(btnVosInfos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setLayout(null);
		panel_1.setBounds(411, 181, 219, 228);
		frmBibliothqueAccueil.getContentPane().add(panel_1);
		
		JButton btnListeDesLivres = new JButton("Liste des livres");
		btnListeDesLivres.setBounds(10, 44, 199, 52);
		panel_1.add(btnListeDesLivres);
		
		JButton btnRetournezUnLivre = new JButton("Retournez un livre");
		btnRetournezUnLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBibliothqueAccueil.setVisible(false);
				try {
					view_return window_return = new view_return();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRetournezUnLivre.setBounds(10, 125, 199, 52);
		panel_1.add(btnRetournezUnLivre);
		
		JButton btnDisconnect = new JButton("Deconnexion");
		if (adherentlogged==null) {
			btnDisconnect.setVisible(false);
		}
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMVC.getM().disconnect(frmBibliothqueAccueil);
			}
		});
		btnDisconnect.setBounds(616, 482, 116, 20);
		frmBibliothqueAccueil.getContentPane().add(btnDisconnect);
		
		
		btnListeDesLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBibliothqueAccueil.setVisible(false);
				try {
					view_list window_list = new view_list();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
