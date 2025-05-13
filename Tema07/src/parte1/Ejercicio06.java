package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio06 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			String sql = "UPDATE Calificaciones SET nota = nota + 1 WHERE id_estudiante = 1 AND id_curso = 1";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("Nota actualizada correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
