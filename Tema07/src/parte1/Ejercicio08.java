package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");
			System.out.print("Introduce el ID del estudiante a eliminar: ");
			int idEstudiante = sc.nextInt();

			String sql = "DELETE FROM Estudiantes WHERE id_estudiante = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, idEstudiante);

			int filasAfectadas = stmt.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("Estudiante eliminado correctamente.");
			} else {
				System.out.println("No se encontró el estudiante con ese ID.");
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
