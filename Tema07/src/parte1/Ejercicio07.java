package parte1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "Os1532008#");

			System.out.println("Introduce los datos del estudiante:");

			System.out.print("Nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Apellido: ");
			String apellido = sc.nextLine();
			System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
			String fechaNacimiento = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Teléfono: ");
			String telefono = sc.nextLine();

			String sql = "INSERT INTO Estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, apellido);
			stmt.setString(3, fechaNacimiento);
			stmt.setString(4, email);
			stmt.setString(5, telefono);

			stmt.executeUpdate();
			System.out.println("Estudiante insertado correctamente.");
			sc.close();
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
}
