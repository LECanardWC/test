import java.sql.*;
import java.util.ArrayList;

public class connectDB {

	private static String database;
	private static String serveur;
	private static String mdp;
	private static Connection connect = null;
	private static ArrayList<Contact> LesContacts;
	
	connectDB() {

		connectDB db1 = new connectDB();
		
	}
	

	public static  Connection connecterdb() {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		connect = DriverManager.getConnection("jdbc:mysql://localhost/contacts" , "root" , "");
		}
		catch (SQLException erreur) {
			System.out.println("Erreur connexion");
		}
	
	catch (ClassNotFoundException e) {
		
		System.out.println("Driver non chargé");
	}
	
	
	return connect;
}
	public static boolean deconnecterdb() {
		boolean bool;
		try {
			connect.close();
			bool = true ;
		}
		catch (SQLException erreur) {
			bool = false;
			
		}
		return bool;
	}
	public static String ajoutercontact(int num, String nom, String prenom, String email, String commentaires){
		String result;
		try {
			Statement st1 = connect.createStatement();
			st1.executeUpdate("INSERT INTO contact (Numero , Nom, Prenom, Email, Commentaires) " +
			"VALUES('"+ num + "' , '"+nom+"' , '"+prenom+"' , '"+email+"' , '"+commentaires+"');" );
			 
			result=("SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = ("Erreur requete");
		}
		return result;
		
	}
	public static ArrayList<Contact> inserer() {
		LesContacts = new ArrayList<Contact>();
		Statement st2;
		try {
			connect = connecterdb();
			st2 = connect.createStatement();
			ResultSet rs = st2.executeQuery("Select * FROM contact ;");
			while (rs.next()) {
			LesContacts.add(new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				
			}
		} catch (SQLException e) {
		
			System.out.println("Erreur requete");
		}

		return LesContacts;
		
	}
}
