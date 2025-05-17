package DAO;
import Koneksi.Connector;
import Models.*;
import DAOImplements.BukuImplement;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author aliad
 */
public class BukuDAO implements BukuImplement{
    Connection connection;
    final String showQuery = "SELECT * FROM buku";

    public BukuDAO() {
        this.connection = Connector.connection();
    }

    
    
    @Override
    public void tambahBuku(BukuModel dataBuku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editBuku(BukuModel dataBuku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusBuku(int idBuku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BukuModel> showAllBuku() {
        List<BukuModel> dataBuku = null;
        try {
            dataBuku = new ArrayList<BukuModel>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(showQuery);
            
            while(result.next()){
                BukuModel buku = new BukuModel();
                buku.setId(result.getInt("id"));
                buku.setJudul(result.getString("judul"));
                buku.setGenre(result.getString("genre"));
                buku.setPenulis(result.getString("penulis"));
                buku.setPenerbit(result.getString("penerbit"));
                buku.setLokasi(result.getString("lokasi"));
                buku.setStock(result.getInt("stock"));
                
                dataBuku.add(buku);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataBuku;
    }
    
}
