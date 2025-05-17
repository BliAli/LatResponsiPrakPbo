package Controllers;
import Views.HomeView;
import Koneksi.Connector;
import Models.*;
import DAOImplements.BukuImplement;
import DAO.BukuDAO;
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
        buku.setStock(Integer.parseInt(homeFrame.getTxtStock().getText()));
        
        implementBuku.tambahBuku(buku);
    }
    
    public void editDataTabel(){
        BukuModel buku = new BukuModel();
        
        buku.setId(Integer.parseInt(homeFrame.getTxtID().getText()));
        buku.setJudul(homeFrame.getTxtJudul().getText());
        buku.setGenre(homeFrame.getTxtGenre().getText());
        buku.setPenulis(homeFrame.getTxtPenulis().getText());
        buku.setPenerbit(homeFrame.getTxtPenerbit().getText());
        buku.setLokasi(homeFrame.getTxtLokasi().getText());
        buku.setStock(Integer.parseInt(homeFrame.getTxtStock().getText()));
        
        implementBuku.editBuku(buku);
    }
    
    public void deleteDataTabel(){
        int idBuku = Integer.parseInt(homeFrame.getTxtID().getText());
        
        implementBuku.hapusBuku(idBuku);
    }
    
}
