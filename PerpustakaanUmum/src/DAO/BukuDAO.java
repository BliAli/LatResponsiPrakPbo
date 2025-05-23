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
public class BukuDAO implements BukuImplement {

    Connection connection;
    final String showQuery = "SELECT * FROM buku";
    final String insertQuery = "INSERT INTO buku (judul, genre, penulis, penerbit, lokasi, stock) VALUES (?, ?, ?, ?, ?, ?)";
    final String editQuery = "UPDATE buku SET judul = ?, genre = ?, penulis = ?, penerbit = ?, lokasi = ?, stock = ? WHERE id = ? ";
    final String deleteQuery = "DELETE FROM buku WHERE id = ?";

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
            while (result.next()) {
                dataBuku.setId(result.getInt(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
        } finally {
            try {
                prepStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void hapusBuku(int idDeleteBuku) {
        PreparedStatement prepStatement = null;

        try {
            prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, idDeleteBuku);
            prepStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<BukuModel> showAllBuku() {
        List<BukuModel> dataBuku = null;

        try {
            dataBuku = new ArrayList<BukuModel>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(showQuery);

            while (result.next()) {
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

    @Override
    public List<BukuModel> cariBuku(String keyword, String kategori) {
        final String searchQuery = "SELECT * FROM buku WHERE " + kategori +" LIKE ?";
        PreparedStatement prepStatement = null;
        List<BukuModel> dataBukuCari = null;
        try {
            dataBukuCari = new ArrayList<BukuModel>();
            String kataCari = "%" + keyword + "%";
            prepStatement = connection.prepareStatement(searchQuery);

            prepStatement.setString(1, kataCari);

            ResultSet result = prepStatement.executeQuery();
            while (result.next()) {
                BukuModel bukuCari = new BukuModel();

                bukuCari.setId(result.getInt("id"));
                bukuCari.setJudul(result.getString("judul"));
                bukuCari.setGenre(result.getString("genre"));
                bukuCari.setPenulis(result.getString("penulis"));
                bukuCari.setPenerbit(result.getString("penerbit"));
                bukuCari.setLokasi(result.getString("lokasi"));
                bukuCari.setStock(result.getInt("stock"));

                dataBukuCari.add(bukuCari);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataBukuCari;
    }
}
