package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio04 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			String[] cursos = { "Historia 1º", "Biología 1º", "Educación Física 1º", "Música 1º", "Tecnología 1º" };
			for (String curso : cursos) {
				String sql = "INSERT INTO Cursos (nombre, descripcion, año_escolar) VALUES (?, ?, 2025)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, curso);
				stmt.setString(2, "Curso de " + curso);
				stmt.executeUpdate();
			}
			System.out.println("Cursos insertados correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
