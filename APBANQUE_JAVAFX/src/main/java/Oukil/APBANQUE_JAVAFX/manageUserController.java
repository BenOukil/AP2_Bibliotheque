package Oukil.APBANQUE_JAVAFX;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import Model.CLIENT;
import Model.CLIENTDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class manageUserController {

	@FXML
	private Label lblInfos;

	@FXML
	private TextField txtFieldNom ;

	@FXML
	private TextField txtFieldPrenom ;

	@FXML
	private RadioButton radioBtnH;

	@FXML
	private RadioButton radioBtnF;

	@FXML 
	private DatePicker datePickerNaissance;

	@FXML
	private TextField txtFieldCategorie ;

	@FXML
	private TextField txtFieldAdresse ;

	@FXML
	private TextField txtFieldTel ;

	@FXML
	private TextField txtFieldEmail ;

	@FXML
	private TextField txtFieldSelect ;

	@FXML
	private Label lblVerif ;
	
	@FXML
	private Label lblVerif2 ;

	@FXML
	private Label lblNom ;

	@FXML
	private Label lblPrenom ;

	@FXML
	private Label lblCategorie ;

	@FXML
	private Label lblDateNaissance ;

	@FXML
	private Label lblGenre ;

	@FXML
	private Label lblEmail ;

	@FXML
	private Label lblTel ;

	@FXML
	private Label lblAdresse ;
	
	@FXML
	private Button btnSelectUser ;
	
	@FXML
	private Button btnUpdateUser ;
	
	@FXML
	private Button btnHub ;
	
	@FXML
	private Pane paneInfo ;



	@FXML
	private void btnSelectUser() throws ClassNotFoundException, SQLException {

		CLIENTDAO clientdao = new CLIENTDAO();
		String email = txtFieldSelect.getText();
		

		if(clientdao.findClient(email)==null) {
			lblVerif.setVisible(true);
			lblVerif.setText("Cette email ne correspond à aucun email");
			lblVerif.setTextFill(Color.RED);
			paneInfo.setVisible(false);
		}
		else {
			
			

			CLIENT clientSelect = clientdao.findClient(email);

			paneInfo.setVisible(true);

			txtFieldNom.setVisible(true);
			txtFieldNom.setText(clientSelect.getNom());

			txtFieldPrenom.setVisible(true);
			txtFieldPrenom.setText(clientSelect.getPrenom());

			if(clientSelect.getGenre()==1) {
				radioBtnH.setSelected(true);
			}

			if(clientSelect.getGenre()==2) {
				radioBtnF.setSelected(true);
			}

			radioBtnF.setVisible(true);

			radioBtnH.setVisible(true);
			
			
			Date dateclient = clientSelect.getDate_de_naissance();
			LocalDate localdateclient = new java.sql.Date(dateclient.getTime()).toLocalDate();
			datePickerNaissance.setValue(localdateclient);

			datePickerNaissance.setVisible(true);

			txtFieldCategorie.setVisible(true);
			txtFieldCategorie.setText(clientSelect.getCateg_pro());

			txtFieldTel.setVisible(true);
			txtFieldTel.setText(clientSelect.getTel());

			txtFieldEmail.setVisible(true);
			txtFieldEmail.setText(clientSelect.getEmail());

			txtFieldAdresse.setVisible(true);
			txtFieldAdresse.setText(clientSelect.getAdresse_full());
			
			lblVerif.setVisible(false);
			lblVerif2.setVisible(false);
			
			
		}

	}

	@FXML
	private void btnUpdateUser() throws ClassNotFoundException, SQLException {
		String nom= txtFieldNom.getText();

		String prenom= txtFieldPrenom.getText();
		String categorie=txtFieldCategorie.getText();
		String adresse= txtFieldAdresse.getText();
		String tel=txtFieldTel.getText();
		String email=txtFieldEmail.getText();
		
		
		
		LocalDate dateNL= datePickerNaissance.getValue();
		Date dateN = java.sql.Date.valueOf(dateNL);
		
		int genre = 0;
		
		if (radioBtnH.isSelected()) {
			genre= 1;
		}
		
		if (radioBtnF.isSelected()) {
			genre= 2;
		}
		
		CLIENTDAO cdao = new CLIENTDAO();
		
		int id= cdao.findidClientEmail(email);
		
		boolean verif = cdao.UPDATE(id ,nom, prenom, genre, dateN, categorie, adresse, tel, email);
		
		if(verif) {
			lblVerif2.setVisible(true);
			lblVerif2.setText("Modification réussie.");
			lblVerif2.setTextFill(Color.GREEN);
		}
		else {
			lblVerif2.setVisible(true);
			lblVerif2.setText("Erreur de modification.");
			lblVerif2.setTextFill(Color.RED);
		}

	}






	@FXML
	private void btnHub() throws IOException {
		App.setRoot("primary");
	}
}