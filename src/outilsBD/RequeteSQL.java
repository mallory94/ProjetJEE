package outilsBD;

import java.sql.*;

import data.User;

public class RequeteSQL {
	private static String[] requetesSQL = {
			"select numvol,heuredepart,villearrivee from vol where villedepart = ?",
			"select numvol,villedepart,villearrivee from vol where heuredepart = ?",
			"select * from user where login = ? and passwd = ?"
		};
	private static PreparedStatement [] requetes ;
	static {
		try {requetes = new PreparedStatement [requetesSQL.length];
			for (int i = 0; i<requetesSQL.length;i++)
				requetes[i] = BDConnexion.getConnection().prepareStatement(requetesSQL[i]);
			
		} catch (SQLException e) {
			// problème, on arrête le serveur
			System.out.println(e);
			System.exit(1);
		}
	}
	
	 public static Object execute(int numeroRequete, Object argument) throws Exception {	 
		switch (numeroRequete) {
		case 0 : return execute0(argument);
		case 1 : return execute1(argument);
		case 2 : return execute2(argument);
		}
		return null;
	}
	 
// ***************************************
// méthodes private : 1 par fonctionnalité 
// ***************************************
private static String execute1(Object argument) {
			String reponse = "";
			PreparedStatement ps = requetes[1];
			try {
				synchronized (ps) {
					ps.setDate(1,(Date) argument);
					ResultSet resultat = ps.executeQuery();
					while (resultat.next()) {
						reponse += resultat.getString("numvol")+" "+resultat.getString("villedepart")+" "+
		     				resultat.getString("villearrivee")+"\n";
					}
				}
			} catch (SQLException e) {/*debug*/}
			return reponse;
		}
	 
private static String execute0(Object argument) {
			String reponse = null;
			PreparedStatement ps = requetes[0];
			synchronized (ps) {
				try{
					ps.setString(1,(String) argument);
					ResultSet resultat = ps.executeQuery();
					// mise en forme du resultset
					while (resultat.next())
						reponse += resultat.getString("numvol")+" "+resultat.getDate("heuredepart")+" "+
							resultat.getString("villearrivee")+"***";
				} catch (SQLException e) {/* debug */}
			}
			return reponse;
		}

private static User execute2(Object argument) throws SQLException {
	
	String [] args = (String[]) argument;
		String login = args[0];
		String passwd = args[1];
		synchronized (requetes[2]) {
			requetes[2].setString(1,login);
			requetes[2].setString(2,passwd);
			ResultSet resultSet = requetes[2].executeQuery();
			if (!resultSet.next()) return null;
			return new User (login, passwd); // à faire : étoffer User et renvoyer tous les champs...
		}
	}
}
