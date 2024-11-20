/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasipengelolaankontak;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DatabaseConnection { //koneksi ke database
public static Connection connect() {
    Connection conn = null;
    try {
        conn = DriverManager.getConnection("jdbc:sqlite:kontak.db");
        System.out.println("Koneksi ke SQLite berhasil!");
    } catch (SQLException e) {
        System.out.println("Koneksi gagal: " + e.getMessage());
    }
    return conn;
}

     
}
