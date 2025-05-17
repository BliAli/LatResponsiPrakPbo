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
    final String insertQuery = "INSERT INTO buku (judul, genre, penulis, penerbit, lokasi, stock) VALUES (?, ?, ?, ?, ?, ?)";
    final String editQuery = "UPDATE buku SET judul = ?, genre = ?, penulis = ?, penerbit = ?, lokasi = ?, stock = ? WHERE id = ? ";
    
    public BukuDAO() {
        this.connection = Connector.connection();
    }
    
    @Override
    public void tambahBuku(BukuModel dataBuku) {
        PreparedStatement prepStatement = null;
        
        try {
            prepStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, dataBuku.getJudul());
            prepStatement.setString(2, dataBuku.getGenre());
            prepStatement.setString(3, dataBuku.getPenulis());
            prepStatement.setString(4, dataBuku.getPenerbit());
            prepStatement.setString(5, dataBuku.getLokasi());
            prepStatement.setInt(6, dataBuku.getStock());
            prepStatement.executeUpdate();
            
            ResultSet result = prepStatement.getGeneratedKeys();
            while(result.next()){
                dataBuku.setId(result.getInt(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void editBuku(BukuModel dataBuku) {
        PreparedStatement prepStatement = null;
        
        try {
            prepStatement = connection.prepareStatement(editQuery);
            prepStatement.setString(1, dataBuku.getJudul());
            prepStatement.setString(2, dataBuku.getGenre());
            prepStatement.setString(3, dataBuku.getPenulis());
            prepStatement.setString(4, dataBuku.getPenerbit());
            prepStatement.setString(5, dataBuku.getLokasi());
            prepStatement.setInt(6, dataBuku.getStock());
            prepStatement.setInt(7, dataBuku.getId());
            prepStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
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
