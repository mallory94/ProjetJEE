package persistance;

import java.sql.SQLException;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.EmpruntException;
import mediatek2020.items.ReservationException;
import mediatek2020.items.RetourException;
import mediatek2020.items.Utilisateur;

public class DocumentEmpruntable implements Document {
	private int idDocument;
	private String NomDocument;
	private String AuteurDocument;
	private boolean Disponible;
	
	public DocumentEmpruntable(int idDocument, String NomDocument, String AuteurDocument, boolean Disponible) {
		this.idDocument = idDocument;
		this.NomDocument = NomDocument;
		this.AuteurDocument = AuteurDocument;
		this.Disponible = Disponible;
	}
	
	@Override
	public Object[] data() {
		return new Object[] { idDocument, NomDocument, AuteurDocument , Disponible };
	}

	@Override
	public void emprunter(Utilisateur utilisateur) throws EmpruntException {
		try {
			RequeteSQL.executeEmprunte((int) utilisateur.data()[0], idDocument);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rendre(Utilisateur utilisateur) throws RetourException {
		try {
			RequeteSQL.executeRendre((int) utilisateur.data()[0], idDocument);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void reserver(Utilisateur arg0) throws ReservationException {
		return ;
	}

}
