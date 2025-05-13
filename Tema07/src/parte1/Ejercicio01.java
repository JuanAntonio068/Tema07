package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");

			String sql = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Pedro");
			stmt.setString(2, "Ramírez");
			stmt.setString(3, "2007-01-25");
			stmt.setString(4, "pedro.ramirez@email.com");
			stmt.setString(5, "111222333");
			stmt.executeUpdate();
			System.out.println("Estudiante insertado correctamente.");

		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
