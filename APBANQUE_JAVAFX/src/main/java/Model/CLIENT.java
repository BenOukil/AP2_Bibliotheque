package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CLIENT {

	


	private String nom;
	private String prenom;
	private int genre;
	private Date date_de_naissance;
	private String categ_pro;
	private String adresse_full;
	private String tel;
	private String email;
	private ArrayList<COMPTE> lstcompte;

	// Q2

	public CLIENT(String nom, String prenom,  Date date_de_naissance, String categ_pro, String adresse_full,
			String tel, String email, ArrayList<COMPTE> lstcompte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		
		this.date_de_naissance = date_de_naissance;
		this.categ_pro = categ_pro;
		this.adresse_full = adresse_full;
		this.tel = tel;
		this.email = email;
		this.lstcompte = lstcompte;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public Date getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	public String getCateg_pro() {
		return categ_pro;
	}
	public void setCateg_pro(String categ_pro) {
		this.categ_pro = categ_pro;
	}
	public String getAdresse_full() {
		return adresse_full;
	}
	public void setAdresse_full(String adresse_full) {
		this.adresse_full = adresse_full;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<COMPTE> getLstcompte() {
		return lstcompte;
	}
	public void setLstcompte(ArrayList<COMPTE> lstcompte) {
		this.lstcompte = lstcompte;
	}

	// Q5

	








/*public ArrayList<CLIENT> getLstClient(){

	}*/






}

