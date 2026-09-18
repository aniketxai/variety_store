/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftware.LogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Aniket
 */
public class ConnectionDB {
    public String namedatabase = "includedata";
    
    private String url = "jdbc:h2:./database/"+namedatabase+";IFEXISTS=TRUE";
     private String user = "root";
     private String password = "";
     
     public Connection filekoneksi (){
         try {
             Class.forName("org.h2.Driver");
             Connection connectdata = DriverManager.getConnection(url,user,password);
             System.out.println("SUKSES");
             return connectdata;
              } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null , "ERROR"+ex.getMessage());
             return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , "ERROR"+ex.getMessage());
             return null;
        }
     }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

