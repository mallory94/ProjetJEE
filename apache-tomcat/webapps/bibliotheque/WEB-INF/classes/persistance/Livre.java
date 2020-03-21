package persistance;

public class Livre extends DocumentEmpruntable {

	public Livre(int idDocument, String NomDocument, String AuteurDocument, int IdUtilisateurEmprunteur) {
		super(idDocument, NomDocument, AuteurDocument, IdUtilisateurEmprunteur);
	}
}