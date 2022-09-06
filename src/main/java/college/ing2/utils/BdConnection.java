package college.ing2.utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class BdConnection {
	//url de connexion � la base de donn�es 
		private static final String URL ="jdbc:mysql://localhost:3306/gestion_college";
		
		//Driver de mySQL
		private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
		
		//nom de l'utilisateur de connexion � la base de donn�es 
		private static final String USERNAME ="root";
		
		//mot de passe de connexion � la base de donn�es 
		private static final String PASSWORD ="";
		
		//Variable pour contenir la connection � la base de donn�es 
		private static Connection connection =null;
		
		//methode pour se connecter � la base de donn�es
		public static Connection getConnection() {
			if(connection != null ) {
				//si la connection existe deja
				return connection;
			} else {
				// si la connexion n'est pas cr��e
				
				try {
					// Appel au driver
					Class.forName(DRIVER);
					//connexion � la base 
					connection =
							DriverManager.getConnection
							(URL, USERNAME, PASSWORD) ;
					} catch (Exception e) {
					//throw new Exception("il est impossible de se connecter � la base");
						e.printStackTrace();
					}
				return connection;
			     }
		       }
		
}
