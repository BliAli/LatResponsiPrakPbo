package Models;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aliad
 */
public class TabelBukuModel extends AbstractTableModel{
    List<BukuModel> dataBuku;
    
    public TabelBukuModel(List<BukuModel> dataBuku){
        this.dataBuku = dataBuku;
    }
    
    @Override
    public int getRowCount() {
        return dataBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Buku";
            case 1:
                return "Judul Buku";
            case 2:
                return "Genre";
            case 3:
                return "Penulis";
            case 4:
                return "Penerbit";
            case 5:
                return "Lokasi";
            case 6:
                return "Stock";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dataBuku.get(rowIndex).getId();
            case 1:
                return dataBuku.get(rowIndex).getJudul();
            case 2:
                return dataBuku.get(rowIndex).getGenre();
            case 3:
                return dataBuku.get(rowIndex).getPenulis();
            case 4:
                return dataBuku.get(rowIndex).getPenerbit();
            case 5:
                return dataBuku.get(rowIndex).getLokasi();
            case 6:
                return dataBuku.get(rowIndex).getStock();
            default:
                return null;
        }
    }
    
}
