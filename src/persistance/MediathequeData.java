package persistance;

import java.sql.SQLException;
import java.util.List;

import mediatek2020.*;
import mediatek2020.items.*;

// classe mono-instance  dont l'unique instance est inject�e dans Mediatheque
// via une auto-d�claration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-Fran�ois Brette 01/01/2018
	
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}
	
	private MediathequeData() {
	}
	
	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> tousLesDocuments() {
		return RequeteSQL.executeGetTousLesDocuments();
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		try {
			return RequeteSQL.executeGetUtilisateur(login,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		try {
			return RequeteSQL.executeGetDocument(numDocument);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void nouveauDocument(int type, Object... args) {
		//args[0] = NomDocument | args[1] = AuteurDocument
		try {
			RequeteSQL.executeNouveauDocument((String) args[0], (String)args[1]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
