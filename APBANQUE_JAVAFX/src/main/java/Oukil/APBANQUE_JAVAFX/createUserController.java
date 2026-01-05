package Oukil.APBANQUE_JAVAFX;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import Model.CLIENTDAO;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class createUserController {

	

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
	private void btnHub() throws IOException {
		App.setRoot("primary");
	}

	@FXML
	public void btnAddUser() throws IOException, ClassNotFoundException, SQLException {
		

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
		
		cdao.ADD(nom, prenom, genre, dateN, categorie, adresse, tel, email);

		
		App.setRoot("create_user");



	}
	
	
	
	
	
	
	

}
