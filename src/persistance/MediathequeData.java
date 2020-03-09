package persistance;

import java.sql.SQLException;
import java.util.List;

import mediatek2020.*;
import mediatek2020.items.*;

// classe mono-instance  dont l'unique instance est injectée dans Mediatheque
// via une auto-déclaration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-François Brette 01/01/2018
	
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	}
	
	private MediathequeData() {
	}
	
	// renvoie la liste de tous les documents de la bibliothèque
	@Override
	public List<Document> tousLesDocuments() {
		return RequeteSQL.executeGetTousLesDocuments();
	}

	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		try {
			return RequeteSQL.executeGetUtilisateur(login,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null
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
