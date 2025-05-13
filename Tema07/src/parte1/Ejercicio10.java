package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			System.out.print("Introduce el nombre del curso: ");
			String nombreCurso = sc.nextLine();

			String sql = "SELECT e.nombre, e.fecha_nacimiento FROM Estudiantes e "
					+ "JOIN Matriculas m ON e.id_estudiante = m.id_estudiante "
					+ "JOIN Cursos c ON m.id_curso = c.id_curso " + "WHERE c.nombre = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nombreCurso);

			ResultSet rs = stmt.executeQuery();

			System.out.println("\nEstudiantes en " + nombreCurso + ":");
			while (rs.next()) {
				System.out.println(rs.getString("nombre") + " - " + rs.getString("fecha_nacimiento"));
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
