
public class Contact {
	//methode prive
	private int numero;
	private String nom;
	private String prenom;
	private String email;
	private String commentaire;
	int n =0;
	
	//methode public
	public Contact(int num, String nom, String prenom, String email, String commentaire) {
		this.numero=num;
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.commentaire=commentaire;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
}
