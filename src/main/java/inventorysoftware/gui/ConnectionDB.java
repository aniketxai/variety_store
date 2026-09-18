/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftware.gui;

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
             inventorysoftware.dao.DatabaseManager.initializeSchema();
             return inventorysoftware.dao.DatabaseManager.getConnection();
         } catch (Exception ex) {
             try {
                 Class.forName("org.h2.Driver");
                 return DriverManager.getConnection("jdbc:h2:./database/includedata", "root", "");
             } catch (Exception e) {
                 System.err.println("DB Connection error: " + e.getMessage());
                 return null;
             }
         }
     }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

