package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class view_accueil {

	private JFrame frmBibliothqueBienvenue;

	/**


	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public view_accueil() throws SQLException {
		mainMVC.getM().getAll();
		initialize();
		frmBibliothqueBienvenue.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliothqueBienvenue = new JFrame();
		frmBibliothqueBienvenue.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\oukil\\Downloads\\Icon_ap2.png"));
		frmBibliothqueBienvenue.setTitle("Bibliothèque - Bienvenue");
		frmBibliothqueBienvenue.setBounds(100, 100, 756, 549);
		frmBibliothqueBienvenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBibliothqueBienvenue.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue dans votre bibiliothèque");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(147, 58, 429, 54);
		frmBibliothqueBienvenue.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(147, 128, 441, 267);
		frmBibliothqueBienvenue.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Touchez l'écran pour continuer");
		btnNewButton.setBounds(69, 79, 307, 110);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBibliothqueBienvenue.setVisible(false);
				view_accueil_disconnect window_accueil_disconnect = new view_accueil_disconnect();
				
			}
		});
	}
}
