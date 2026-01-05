package Oukil.APBANQUE_JAVAFX;

import java.io.IOException;
import java.sql.SQLException;

import Model.CLIENTDAO;
import Model.COURANTDAO;
import Model.EPARGNEDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class createAccountController {


	@FXML
	private TextField txtFieldDecouvert;

	@FXML
	private TextField txtFieldNumCompte;

	@FXML
	private TextField txtFieldSolde;

	@FXML
	private TextField txtFieldDevise;

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

	@FXML
	private Label lblVerif;












	@FXML
	private void btnHub() throws IOException {
		App.setRoot("primary");
	}








	public void btnAddAccount() throws ClassNotFoundException, SQLException {
		int numCompte= Integer.parseInt(txtFieldNumCompte.getText());
		Float solde= Float.parseFloat(txtFieldSolde.getText());
		String devise = txtFieldDevise.getText();



		if (radioBtnCompteC.isSelected()) {

			String userEmail= txtFieldEmailUser.getText();
			CLIENTDAO cdao= new CLIENTDAO();
			int id_client = cdao.findidClientEmail(userEmail);

			if(id_client==0) {

				lblVerif.setVisible(true);
				lblVerif.setTextFill(Color.RED);
				lblVerif.setText("Erreur l'email ne correspond à aucun client.");

			}
			else {

				System.out.println(userEmail);
				int decouvert= Integer.parseInt(txtFieldDecouvert.getText());
				System.out.println(decouvert);
				int numCB= Integer.parseInt(txtFieldCbTaux.getText());
				System.out.println(numCB);

				System.out.println(id_client);
				COURANTDAO comptecdao = new COURANTDAO();
				int verif = comptecdao.ADD( numCompte, solde, devise, id_client, numCB, decouvert);
				if (verif==1) {
					lblVerif.setVisible(true);
					lblVerif.setTextFill(Color.GREEN);
					lblVerif.setText("Le compte a été créé avec succès.");
				}
				else {
					lblVerif.setVisible(true);
					lblVerif.setTextFill(Color.RED);
					lblVerif.setText("Erreur le compte n'a pas pu être crée.");

				}

			}
		}
		else if (radioBtnCompteE.isSelected()) {

			String userEmail= txtFieldEmailUser.getText();
			CLIENTDAO cdao= new CLIENTDAO();
			int id_client = cdao.findidClientEmail(userEmail);

			if(id_client==0) {

				lblVerif.setVisible(true);
				lblVerif.setTextFill(Color.RED);
				lblVerif.setText("Erreur l'email ne correspond à aucun client.");

			}
			else {

				System.out.println(userEmail);
				float interet= Float.parseFloat(txtFieldCbTaux.getText());
				System.out.println(interet);


				System.out.println(id_client);
				EPARGNEDAO compteedao = new EPARGNEDAO();
				int verif = compteedao.ADD( numCompte, solde, devise, id_client, interet);

				if (verif==1) {
					lblVerif.setVisible(true);
					lblVerif.setTextFill(Color.GREEN);
					lblVerif.setText("Le compte a été créé avec succès.");
				}
				else {
					lblVerif.setVisible(true);
					lblVerif.setTextFill(Color.RED);
					lblVerif.setText("Erreur le compte n'a pas pu être crée.");

				}


			}
		}

	}

	public void radioBtnCompteC () {
		if (radioBtnCompteC.isSelected()) {

			txtFieldCbTaux.setVisible(true);
			txtFieldDecouvert.setVisible(true);
			lblDecouvert.setVisible(true);
			lblnCB.setVisible(true);
			lblTaux.setVisible(false);
			btnAddAccount.setVisible(true);


		}

	}

	public void radioBtnCompteE () {
		if (radioBtnCompteE.isSelected()) {
			btnAddAccount.setVisible(true);
			txtFieldCbTaux.setVisible(true);
			txtFieldDecouvert.setVisible(true);
			lblDecouvert.setVisible(false);
			lblnCB.setVisible(false);
			lblTaux.setVisible(true);
			txtFieldDecouvert.setVisible(false);


		}
	}

}
