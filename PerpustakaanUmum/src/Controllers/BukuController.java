package Controllers;
import Views.HomeView;
import Koneksi.Connector;
import Models.*;
import DAOImplements.BukuImplement;
import DAO.BukuDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author aliad
 */
public class BukuController {
    HomeView homeFrame;
    BukuImplement implementBuku;
    List<BukuModel> dataBuku;

    public BukuController(HomeView homeFrame) {
        this.homeFrame = homeFrame;
        implementBuku = new BukuDAO();
        dataBuku = implementBuku.showAllBuku();
    }
    
    public void loadDataTabel(){
        dataBuku = implementBuku.showAllBuku();
        TabelBukuModel tabelDataBuku = new TabelBukuModel(dataBuku);
        homeFrame.getTabelDataBuku().setModel(tabelDataBuku);
    }
    
    public void insertDataTabel(){
        BukuModel buku = new BukuModel();
        
        buku.setJudul(homeFrame.getTxtJudul().getText());
        buku.setGenre(homeFrame.getTxtGenre().getText());
        buku.setPenulis(homeFrame.getTxtPenulis().getText());
        buku.setPenerbit(homeFrame.getTxtPenerbit().getText());
        buku.setLokasi(homeFrame.getTxtLokasi().getText());
        String stockText = homeFrame.getTxtStock().getText();
        
        if(buku.getJudul().equals("") || buku.getGenre().equals("") || buku.getPenulis().equals("") || buku.getPenerbit().equals("") || buku.getLokasi().equals("") || stockText.equals("")){
            JOptionPane.showMessageDialog(homeFrame, "Mohon Isi Secara Lengkap Data Buku Yang Ingin Ditambahkan");
            return;
        }
        
        int stock = 1;
        try {
            stock = Integer.parseInt(stockText);
            if(stock < 1){
                JOptionPane.showMessageDialog(homeFrame, "Jumlah stock minimal lebih dari 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(homeFrame, "Jumlah Stock harus berupa angka");
            return;
        }
        buku.setStock(stock);
        implementBuku.tambahBuku(buku);
        JOptionPane.showMessageDialog(homeFrame, "Data buku berhasil ditambahkan");
    }
    
    public void editDataTabel(){
        BukuModel buku = new BukuModel();
        
        String idEdit = homeFrame.getTxtID().getText();
        if(idEdit.isEmpty()){
            JOptionPane.showMessageDialog(homeFrame, "Pilih Data Buku Yang Ingin Diedit");
            return;
        }
        buku.setId(Integer.parseInt(idEdit));
        buku.setJudul(homeFrame.getTxtJudul().getText());
        buku.setGenre(homeFrame.getTxtGenre().getText());
        buku.setPenulis(homeFrame.getTxtPenulis().getText());
        buku.setPenerbit(homeFrame.getTxtPenerbit().getText());
        buku.setLokasi(homeFrame.getTxtLokasi().getText());
        String stockText = homeFrame.getTxtStock().getText();
        
        if(buku.getJudul().equals("") || buku.getGenre().equals("") || buku.getPenulis().equals("") || buku.getPenerbit().equals("") || buku.getLokasi().equals("") || stockText.equals("")){
            JOptionPane.showMessageDialog(homeFrame, "Mohon Isi Secara Lengkap Data Buku Yang Ingin Diedit");
            return;
        }
        
        int stock = 1;
        try {
            stock = Integer.parseInt(stockText);
            if(stock < 1){
                JOptionPane.showMessageDialog(homeFrame, "Jumlah stock minimal lebih dari 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(homeFrame, "Jumlah Stock harus berupa angka");
            return;
        }
        buku.setStock(stock);
        implementBuku.editBuku(buku);
        JOptionPane.showMessageDialog(homeFrame, "Data Buku Dengan ID " + buku.getId() + " Berhasil Diedit");
    }
    
    public void deleteDataTabel(){
        String idDelete = homeFrame.getTxtID().getText();
        if(idDelete.isEmpty()){
            JOptionPane.showMessageDialog(homeFrame, "Pilih Buku Yang Ingin Dihapus");
            return;
        }
        int idBuku = Integer.parseInt(idDelete);
        
        int confirmDelete = JOptionPane.showConfirmDialog(homeFrame, "Apakah Anda Yakin Ingin Menghapus Buku Dengan Judul " + homeFrame.getTxtJudul().getText() + " ?");
        if(confirmDelete == JOptionPane.YES_OPTION){
            implementBuku.hapusBuku(idBuku);
        }
    }
    
    public void searchDataTabel(String keyword, String kategori){
        if(keyword.equals("")){
            JOptionPane.showMessageDialog(homeFrame, "Masukkan Keyword Yang Ingin Dicari");
            return;
        }
        List<BukuModel> dataBukuCari = new ArrayList<BukuModel>();
        dataBukuCari = implementBuku.cariBuku(keyword, kategori);
        TabelBukuModel tabelDataBukuCari = new TabelBukuModel(dataBukuCari);
        homeFrame.getTabelDataBuku().setModel(tabelDataBukuCari);
    }
}
