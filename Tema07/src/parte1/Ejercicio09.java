package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio09 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			String sql = "SELECT nombre, fecha_nacimiento FROM Estudiantes";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("nombre") + " - " + rs.getString("fecha_nacimiento"));
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
