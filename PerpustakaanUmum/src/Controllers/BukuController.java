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
    
}
