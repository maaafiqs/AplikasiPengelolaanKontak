/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasipengelolaankontak;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class KontakDatabase {
public static void createTable() {
        // SQL untuk membuat tabel
        String sql = "CREATE TABLE IF NOT EXISTS kontak (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nama TEXT NOT NULL," +
                     "nomor_telepon TEXT NOT NULL," +
                     "kategori TEXT NOT NULL);";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            // Membuat tabel
            stmt.execute(sql);
            System.out.println("Tabel 'kontak' berhasil dibuat atau sudah ada.");
        } catch (SQLException e) {
            System.out.println("Error membuat tabel: " + e.getMessage());
        }
    }
}
