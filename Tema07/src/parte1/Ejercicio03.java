package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio03 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			String sql = "DELETE FROM Estudiantes WHERE nombre = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Luis");
			stmt.executeUpdate();
			System.out.println("Estudiante eliminado correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
