public class Livre {

	String titre ;
	String nom;
	String prenom;
	String auteur;
	String presentation;
	int parution;
	int colonne; 
	int range;
	
	public Livre() {
		
		this.titre = "";
		this.auteur = "";
		this.presentation = "";
		this.parution = 0; 
		this.colonne = 0;
		this.range = 0;
	}
	
	public Livre(String titre, String presentation,String auteur, int parution, int colonne, int range) {
		super();
		this.titre = titre;
		this.presentation = presentation;
		this.auteur= auteur;
		this.parution = parution;
		this.colonne = colonne;
		this.range = range;
	}
	
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public int getParution() {
		return parution;
	}
	public void setParution(int parution) {
		this.parution = parution;
	}
	public int getColonne() {
		return colonne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	
	
}
