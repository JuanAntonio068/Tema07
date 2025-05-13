package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio02 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			String sql = "UPDATE Estudiantes SET email = ? WHERE nombre = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "nuevo.email@email.com");
			stmt.setString(2, "Ana");
			stmt.executeUpdate();
			System.out.println("Correo actualizado correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
