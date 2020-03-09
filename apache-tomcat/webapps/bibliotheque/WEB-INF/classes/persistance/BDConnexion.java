package persistance;

import java.sql.*;

public class BDConnexion {
	private static String driver ;
	private static String url, login, passwd ;
	private static Connection connection ;
	
	static { 
		try {
			System.out.println("avant le driver");
			driver = "oracle.jdbc.OracleDriver";
			System.out.println("apres le driver");
			System.out.println("Class.forName(driver);");
			Class.forName(driver);
			System.out.println("fin de Class.forName(driver);");
			url = "jdbc:oracle:thin:@localhost:1521:XE";
			login = "ETUDIANT";
			passwd = "ETUDIANT";
			connection = DriverManager.getConnection(url,login,passwd);
		}
		catch (Exception e) {
			// problème, on arrête le serveur
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
