package mediatek2020.items;

import mediatek2020.Mediatheque;
import persistance.RequeteSQL;

public class Abonne implements Utilisateur {
	private String name;
	
	public Abonne(String login) {
		name = login;
	}

	@Override
	public Object[] data() {
		return this.data();
	}

	@Override
	public boolean isBibliothecaire() {
		boolean b = false;
		try {
			 b = RequeteSQL.executeIsBibliothecaire(name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public String name() {
		return name;
	}

}
