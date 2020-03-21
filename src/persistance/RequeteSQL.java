package persistance;

import java.sql.*;
import java.util.ArrayList;

import mediatek2020.Mediatheque;
import mediatek2020.items.Document;
import mediatek2020.items.Utilisateur;

public class RequeteSQL {
	
	private static String[] requetesSQL = {
			"select * from utilisateur where IdUtilisateur = ?",
			"select * from Document",
			"select * from utilisateur where LoginUtilisateur = ? and PasswordUtilisateur = ?",
			"select * from document where IdDocument = ?",
			"UPDATE document SET IdUtilisateurEmprunteur = ? WHERE IdDocument = ?",
			"UPDATE document SET IdUtilisateurEmprunteur = NULL WHERE IdDocument = ?",
			"INSERT INTO document(NomDocument,AuteurDocument) VALUES (?,?)"
			
			
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
		}
		return null;
	}
	 

public static ArrayList<Document> executeGetTousLesDocuments() {
			PreparedStatement ps = requetes[1];
			ArrayList<Document> liste = new ArrayList<>();
			try {
				synchronized (requetes) {
					ResultSet resultat = ps.executeQuery();
					while (resultat.next()) {
						liste.add(new DocumentEmpruntable(resultat.getInt("IdDocument"), resultat.getString("NomDocument"), 
								resultat.getString("AuteurDocument"), resultat.getInt("IdUtilisateurEmprunteur")));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return liste;
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return reponse;
		}

	private static UtilisateurBibli executeGetUser(String login , String passwd) throws SQLException {
	
	
		synchronized (requetes) {
			requetes[2].setString(1,login);
			requetes[2].setString(2,passwd);
			try{
				ResultSet resultSet = requetes[2].executeQuery();
				 if (resultSet.next() == false) {
				        return null;
				      } else {
				          return new UtilisateurBibli(resultSet.getInt("IdUtilisateur"), resultSet.getString("LoginUtilisateur"),
				        		  (resultSet.getInt("Bibliothequaire") == 1));
				      }
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			return null ;
		}
	}
	
	public static Utilisateur executeGetUtilisateur(String login , String passwd) throws SQLException {
	
		synchronized (requetes) {
			requetes[2].setString(1,login);
			requetes[2].setString(2,passwd);
			try{
				ResultSet resultSet = requetes[2].executeQuery();
				 if (resultSet.next() == false) {
				        return null;
				      } else {
				    	  System.out.println("id user = "  + resultSet.getInt("IdUtilisateur"));
				          return new UtilisateurBibli(resultSet.getInt("IdUtilisateur"), resultSet.getString("LoginUtilisateur"), 
				        		  resultSet.getInt("Bibliothequaire") == 1);
				      }

			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			return null ;
		}
	}
	
public static Document executeGetDocument(int numDoc) throws SQLException {
		Document docRenvoyé;
		synchronized (requetes) {
			requetes[3].setInt(1,numDoc);
			try{
				ResultSet resultSet = requetes[3].executeQuery();
				 if (resultSet.next() == false) {
				        return null;
				      } else {
				    	  return new DocumentEmpruntable(resultSet.getInt("IdDocument"), resultSet.getString("NomDocument"), 
				    			  resultSet.getString("AuteurDocument"), resultSet.getInt("IdUtilisateurEmprunteur"));
				      }

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null ;
		}
	}
	
	public static boolean executeIsBibliothecaire(int idUtilisateur) throws SQLException {
		
		synchronized (requetes) {
			requetes[0].setInt(1,idUtilisateur);

			try{
				ResultSet resultSet = requetes[0].executeQuery();
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
	
	
	public static void executeEmprunte(int idUtilisateur, int idDocument) throws SQLException {

		synchronized (requetes) {
			requetes[4].setInt(1,idUtilisateur);
			requetes[4].setInt(2,idDocument);
			try{
				Statement st = BDConnexion.getConnection().createStatement ();
				int b = requetes[4].executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
	
	
	public static void executeRendre(int idUtilisateur, int idDocument) throws SQLException {
		
		synchronized (requetes) {
			requetes[5].setInt(1,idDocument);
			try{
				Statement st = BDConnexion.getConnection().createStatement ();
				int b = requetes[5].executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	
	public static void executeNouveauDocument(String NomDocument, String AuteurDocument, String Type) throws SQLException {
		
		synchronized (requetes) {
			requetes[6].setString(1,NomDocument);
			requetes[6].setString(2,AuteurDocument);
			try{
				Statement st = BDConnexion.getConnection().createStatement ();
				int b = requetes[6].executeUpdate();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
