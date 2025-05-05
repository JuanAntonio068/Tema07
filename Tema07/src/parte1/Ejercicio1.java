package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");

			Statement st = con.createStatement();
			
			ResultSet res = (st.executeQuery("SELECT * FROM estudiantes"));
			
			while(res.next()) {
				System.out.println(res.getString(1) + " " + res.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
