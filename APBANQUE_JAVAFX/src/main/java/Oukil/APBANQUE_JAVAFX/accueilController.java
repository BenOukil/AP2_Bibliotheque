package Oukil.APBANQUE_JAVAFX;

import java.io.IOException;

import javafx.fxml.FXML;



public class accueilController {

	
	



	

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

	

	
	
	
	
	
	
	

}
