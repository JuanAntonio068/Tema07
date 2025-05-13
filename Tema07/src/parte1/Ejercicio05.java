package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio05 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			String sql = "INSERT INTO Calificaciones (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.setInt(3, 1);
			stmt.setString(4, "Examen");
			stmt.setDouble(5, 9.0);
			stmt.setString(6, "2025-04-10");
			stmt.executeUpdate();
			System.out.println("Nota insertada correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
