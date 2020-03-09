package persistance;

import java.sql.*;

import data.User;
import mediatek2020.Mediatheque;
import mediatek2020.items.Abonne;
import mediatek2020.items.Utilisateur;

public class RequeteSQL {
	private static String[] requetesSQL = {
			"select numvol,heuredepart,villearrivee from vol where villedepart = ?",
			"select numvol,villedepart,villearrivee from vol where heuredepart = ?",
			"select * from utilisateur where LoginUtilisateur = ? and PasswordUtilisateur = ?",
			"select * from utilisateur where LoginUtilisateur = ?"
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

	private static boolean executeUserExist(String login , String passwd) throws SQLException {
	
	
		synchronized (requetes[2]) {
			requetes[2].setString(1,login);
			requetes[2].setString(2,passwd);
			try{
				ResultSet resultSet = requetes[2].executeQuery();
				 if (resultSet.next() == false) {
				        return false;
				      } else {
				          return true;
				      }

			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			return false ;
		}
	}
	
	private static Utilisateur executeUserExist(String login , String passwd) throws SQLException {
		
		
		synchronized (requetes[2]) {
			requetes[2].setString(1,login);
			requetes[2].setString(2,passwd);
			try{
				ResultSet resultSet = requetes[2].executeQuery();
				 if (resultSet.next() == false) {
				        return false;
				      } else {
				          return new Abonne(new Object[]( resultSet.get));
				      }

			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			return false ;
		}
	}
	
	public static boolean executeIsBibliothecaire(String login) throws SQLException {
		
		synchronized (requetes[3]) {
			requetes[3].setString(1,login);

			try{
				ResultSet resultSet = requetes[3].executeQuery();
				 if (resultSet.next() == false) {
				        return false;
				      } else {
				    	  return resultSet.getBoolean("Bibliothequaire");
				      }
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			return false ;
		}
	}
}
