
public class LIVRE {
	private String ISBN;
	private String titre;
	@Override
	public String toString() {
		return "LIVRE [ISBN=" + ISBN + ", titre=" + titre + ", prix=" + prix + ", emprunteur=" + emprunteur
				+ ", auteur=" + auteur + "]";
	}
	public LIVRE(String iSBN, String titre, Float prix, ADHERENT emprunteur, AUTEUR auteur) {
		super();
		ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;
		this.emprunteur = emprunteur;
		this.auteur = auteur;
	}
	private Float prix;
	private ADHERENT emprunteur;
	private AUTEUR auteur;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public ADHERENT getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(ADHERENT emprunteur) {
		this.emprunteur = emprunteur;
	}
	public AUTEUR getAuteur() {
		return auteur;
	}
	public void setAuteur(AUTEUR auteur) {
		this.auteur = auteur;
	}

}
