package library;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class koneksi {
    Connection koneksi = null;
    public static Connection koneksiDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_library","root","");
            return koneksi;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
//    public static void main(String args[]){
//        koneksi con = new koneksi();
//        con.koneksiDb();
//    }
}
