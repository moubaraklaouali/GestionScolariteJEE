package college.ing2.utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class BdConnection {
	//url de connexion à la base de données 
		private static final String URL ="jdbc:mysql://localhost:3306/gestion_college";
		
		//Driver de mySQL
		private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
		
		//nom de l'utilisateur de connexion à la base de données 
		private static final String USERNAME ="root";
		
		//mot de passe de connexion à la base de données 
		private static final String PASSWORD ="";
		
		//Variable pour contenir la connection à la base de données 
		private static Connection connection =null;
		
		//methode pour se connecter à la base de données
		public static Connection getConnection() {
			if(connection != null ) {
				//si la connection existe deja
				return connection;
			} else {
				// si la connexion n'est pas créée
				
				try {
					// Appel au driver
					Class.forName(DRIVER);
					//connexion à la base 
					connection =
							DriverManager.getConnection
							(URL, USERNAME, PASSWORD) ;
					} catch (Exception e) {
					//throw new Exception("il est impossible de se connecter à la base");
						e.printStackTrace();
					}
				return connection;
			     }
		       }
		
}
