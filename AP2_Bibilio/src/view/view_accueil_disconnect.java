package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
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

public class view_accueil_disconnect {

	private JFrame frmBibliothqueAccueil;

	

	/**
	 * Create the application.
	 */
	public view_accueil_disconnect() {
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
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBibliothqueAccueil.setVisible(false);
				try {
					view_login window_login = new view_login();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnexion.setBounds(10, 88, 199, 52);
		panel.add(btnConnexion);
		
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
