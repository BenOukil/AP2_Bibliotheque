package Oukil.APBANQUE_JAVAFX;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


import Model.CLIENT;
import Model.CLIENTDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PrimaryController {

	@FXML
	private ArrayList<CLIENT> lstclient= new ArrayList<CLIENT>();

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
	private TextField txtFieldDecouvert;
	
	@FXML
	private TextField txtFieldCbTaux;
	
	@FXML
	private RadioButton radioBtnCompteE;
	
	@FXML
	private RadioButton radioBtnCompteC;
	
	@FXML
	private Label lblDecouvert;
	
	@FXML
	private Label lblTaux;
	
	@FXML
	private Label lblnCB;
	
	@FXML
	private Button btnAddAccount;
	
	@FXML
	private TextField txtFieldEmailUser;



	/*@FXML
	private ChoiceBox<String> choiceBoxGenre;*/




	

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}

	@FXML
	private void btnCreateUser() throws IOException {
		App.setRoot("create_user");

	}

	
	
	@FXML
	private void btnCreateAccount() throws IOException {
		App.setRoot("create_account");
	}

	@FXML
	private void btnManageUser() throws IOException {
		App.setRoot("manage_user");
	}

	@FXML
	private void btnManageAccount() throws IOException {
		App.setRoot("manage_account");
	}

	@FXML
	private void btnHub() throws IOException {
		App.setRoot("primary");
	}

	@FXML
	public void btnAddUser() throws IOException, ClassNotFoundException, SQLException {
		

		String nom= txtFieldNom.getText();

		String titre= txtFieldPrenom.getText();
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
		
		cdao.ADD(nom, titre, genre, dateN, categorie, adresse, tel, email);

		
		App.setRoot("create_user");



	}
	
	
	
	
	
	
	

}
