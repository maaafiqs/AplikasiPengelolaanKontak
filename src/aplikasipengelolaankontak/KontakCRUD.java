/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasipengelolaankontak;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class KontakCRUD {
  public static void addContact(String nama, String nomorTelepon, String kategori) {
        String sql = "INSERT INTO kontak(nama, nomor_telepon, kategori) VALUES(?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nama);
            pstmt.setString(2, nomorTelepon);
            pstmt.setString(3, kategori);
            pstmt.executeUpdate();
            System.out.println("Kontak berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Error menambahkan kontak: " + e.getMessage());
        }
    }
  
  public static void loadContacts(DefaultTableModel model) {
        String sql = "SELECT * FROM kontak";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"), 
                    rs.getString("nama"), 
                    rs.getString("nomor_telepon"), 
                    rs.getString("kategori")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error membaca kontak: " + e.getMessage());
        }
    }
  
  public static void updateContact(int id, String nama, String nomorTelepon, String kategori) {
    String sql = "UPDATE kontak SET nama = ?, nomor_telepon = ?, kategori = ? WHERE id = ?";
    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, nama);
        pstmt.setString(2, nomorTelepon);
        pstmt.setString(3, kategori);
        pstmt.setInt(4, id);
        pstmt.executeUpdate();
        System.out.println("Kontak berhasil diperbarui!");
    } catch (SQLException e) {
        System.out.println("Error mengedit kontak: " + e.getMessage());
    }
}
  
public static void deleteContact(int id) {
    String sql = "DELETE FROM kontak WHERE id = ?";
    try (Connection conn = DatabaseConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        System.out.println("Kontak berhasil dihapus!");
    } catch (SQLException e) {
        System.out.println("Error menghapus kontak: " + e.getMessage());
    }
}  
  
  
}
