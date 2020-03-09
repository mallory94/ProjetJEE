package persistance;

import mediatek2020.items.Utilisateur;

public class UtilisateurBibli implements Utilisateur {
	private int idUtilisateur;
	private String login;
	private boolean isBiliothecaire;
	
	
	public UtilisateurBibli(int idUtilisateur, String login, boolean isBiliothecaire) {
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.isBiliothecaire = isBiliothecaire;
	}

	@Override
	public Object[] data() {
		return new Object[] { idUtilisateur, login, isBiliothecaire };
	}

	@Override
	public boolean isBibliothecaire() {
		boolean b = false;
		try {
			 b = RequeteSQL.executeIsBibliothecaire(idUtilisateur);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public String name() {
		return login;
	}
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

}
