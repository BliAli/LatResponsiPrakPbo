package Koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author aliad
 */
public class Conncector {
    static Connection conn;
    
    public static Connection connection(){
        if(conn == null){
           MysqlDataSource database = new MysqlDataSource();
           database.setDatabaseName("perpustakaan_umum");
           database.setUser("root");
           database.setPassword("");
           
            try {
               conn = database.getConnection();
                System.out.println("Koneksi Database Perpustakaan Umum Berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Koneksi Database Perpustakaan Umum Gagal");
            }
        }
        return conn;
    }
}
