/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftware.LogIn;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import inventorysoftware.LogIn.NewSignin;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


import net.proteanit.sql.DbUtils;
/**
 *
 * @author Aniket
 */
public class Home  extends javax.swing.JFrame {
     public int finalTotal=0;

    /**
     * Creates new form product
     */
     
     PreparedStatement pst=null;
     Color mouseEnterColor = new Color(0, 0, 0);
    Color mouseExitColor = new Color(51, 51, 51);
 
    
    
    public static String cus_id = "0";
    
    public Home() {
        initComponents();
        updateCombo();
        updatCombo();
        updaCombo();
         tb_load();
   
   SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        Date date=new Date();
        jLabel66.setText(dateFormat.format(date));
        
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        jLabel68.setText(dtf.format(now));
  
        
        
  
   
    }

  public void tb_load(){
  
  
      try {
          
          DefaultTableModel dt = (DefaultTableModel) rSTableMetro5.getModel();
          dt.setRowCount(0);
          
          ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
          ResultSet rs = st.executeQuery(" SELECT * FROM seller");
          
          while (rs.next()) {              
              
              Vector v = new Vector();
              
              v.add(rs.getString(1));
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(6));
               v.add(rs.getString(7));
                v.add(rs.getString(8));
              
              dt.addRow(v);
                          
              
              
              
          }
          
      } catch (SQLException e) {
          System.out.println(e);
      }
      
      
  }
  private void sellerclear(){
      jTextField14.setText(null);
      jTextField15.setText(null);
      jTextField18.setText(null);
      jTextField16.setText(null);
      jTextField38.setText(null);
      jTextField17.setText(null);
      jTextField24.setText(null);
      jTextField3.setText(null);
      
      
  }
  private void productclear(){
      jTextField8.setText(null);
      jTextField23.setText(null);
      jTextField9.setText(null);
      jTextField37.setText(null);
      jTextField10.setText(null);
      jTextField12.setText(null);
       jTextField1.setText(null);
     
  
     
       jDateChooser1.setDate(null);
  }
  private void customerclear(){
      jTextField20.setText(null);
      jTextField21.setText(null);
      jTextField36.setText(null);
      jTextField22.setText(null);
      jComboBox4.setSelectedItem(null);
       jTextField2.setText(null);
  
     
       
  }
  private void billingclear(){
       jComboBox1.setSelectedItem(null);
      jTextField40.setText(null);
      jTextField41.setText(null);
      jTextField42.setText(null);
      jTextField43.setText(null);
       jComboBox6.setSelectedItem(null);
        jComboBox3.setSelectedItem(null);
      jTextField5.setText(null);
      jLabel31.setText(null);
      jTextField4.setText(null);
      jTextField39.setText(null);
      jTextField31.setText(null);
      jTextField32.setText(null);
      jTextField33.setText(null);
      jTextField25.setText(null);
      jTextField30.setText(null);
      jTextField29.setText(null);
      jTextField34.setText(null);
     
      jComboBox5.setSelectedItem(null);
       jComboBox1.setSelectedItem(null);
      
  
     
       
  }
  private void dueclear(){
      
      jLabel98.setText("0000");
       jLabel107.setText("0000");
      jTextField7.setText(null);
      jTextField26.setText(null);
      jTextField28.setText(null);
       
      jTextField44.setText(null);
   
      jTextField45.setText(null);
      jTextField27.setText(null);
      jTextField35.setText(null);
     
      
  
     
       
  }
  private void updateCombo(){

try{
ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        ResultSet rs = st.executeQuery(" SELECT * FROM product");




while(rs.next()){
jComboBox3.addItem(rs.getString("p_id"));

}
}
catch (Exception e) {
}
}
   private void updatCombo(){

try{
ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        ResultSet rs = st.executeQuery(" SELECT * FROM seller");




while(rs.next()){
jComboBox2.addItem(rs.getString("name"));

}
}
catch (Exception e) {
}
}
   private void updaCombo(){

try{
ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        ResultSet rs = st.executeQuery(" SELECT * FROM customer");




while(rs.next()){
jComboBox1.addItem(rs.getString("c_id"));

}
}
catch (Exception e) {
}
}
public void search(String str){
         DefaultTableModel model = (DefaultTableModel)rSTableMetro2.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
         rSTableMetro2.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         
    
    
}
public void searchcustomer(String str){
         DefaultTableModel model = (DefaultTableModel)rSTableMetro3.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
         rSTableMetro3.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         
    
    
}
public void searchseller(String str){
         DefaultTableModel model = (DefaultTableModel)rSTableMetro5.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
         rSTableMetro5.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         
   
    
}

public void searchbilling(String str){
         DefaultTableModel model = (DefaultTableModel)rSTableMetro7.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
         rSTableMetro7.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         
   
    
}
public void searchdue(String str){
         DefaultTableModel model = (DefaultTableModel)rSTableMetro8.getModel();
         TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
         rSTableMetro8.setRowSorter(trs);
         trs.setRowFilter(RowFilter.regexFilter(str));
         
   
    
}
  
   public void tot(){
     
 Double paid = Double.valueOf(jTextField29.getText());
       Double tot = Double.valueOf(jTextField30.getText());
       Double due ;
       
       due =  paid -tot ;
       
       jTextField34.setText(String.valueOf(due));
 
 }
  
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateComponentFormatter1 = new org.jdatepicker.impl.DateComponentFormatter();
        dateComponentFormatter2 = new org.jdatepicker.impl.DateComponentFormatter();
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        billing = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new rojerusan.RSTableMetro();
        jButton10 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField39 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        product = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel71 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel75 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojerusan.RSTableMetro();
        jLabel76 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel78 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel79 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        customer = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel70 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro3 = new rojerusan.RSTableMetro();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        seller = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        rSTableMetro5 = new rojerusan.RSTableMetro();
        jLabel72 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jButton17 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        stock = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        rSTableMetro9 = new rojerusan.RSTableMetro();
        jTextField11 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        totalsell = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        rSTableMetro7 = new rojerusan.RSTableMetro();
        jLabel93 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        due = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        rSTableMetro8 = new rojerusan.RSTableMetro();
        jLabel96 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jTextField26 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jButton26 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        setting = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable4 = new rojerusan.RSTableMetro();
        jButton30 = new javax.swing.JButton();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("l");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 20, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/search_26px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("l");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 20, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/group_message_26px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("l");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 20, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/bell_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel9.setText(" Hello, Admin");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -20, 150, 100));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/Untitled design (4).png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/pngegg (1).png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/pngegg.png"))); // NOI18N
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 30, 30));

        jLabel22.setBackground(new java.awt.Color(255, 0, 0));
        jLabel22.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("Variety ");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -20, 80, 100));

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Store");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 14, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 60));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Features");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 40));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/home_24px.png"))); // NOI18N
        jLabel11.setText(" Home");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 50));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/account_24px.png"))); // NOI18N
        jLabel12.setText(" Stocks");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 220, 50));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel13.setText(" Billing");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 220, 50));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel14.setText(" Products");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, 50));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel15.setText(" Customers");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 220, 50));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_Exit_26px_1.png"))); // NOI18N
        jLabel16.setText("Logout");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 220, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel17.setText(" Sellers");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 220, 50));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/settings-17-32.png"))); // NOI18N
        jLabel18.setText(" Settings");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -2, 120, 60));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 220, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel23.setText(" Total Sells");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        jPanel12.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 220, 50));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel24.setText(" Dues");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, -1));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 220, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 220, 740));

        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel116MouseClicked(evt);
            }
        });
        home.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 200, 200));

        jLabel117.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel117MouseClicked(evt);
            }
        });
        home.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 210, 200));

        jLabel118.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel118MouseClicked(evt);
            }
        });
        home.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 200, 200));

        jLabel119.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel119MouseClicked(evt);
            }
        });
        home.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 200, 200));

        jLabel120.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });
        home.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 210, 200));

        jLabel121.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel121MouseClicked(evt);
            }
        });
        home.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 200, 200));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/Billing.png"))); // NOI18N
        home.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel122.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 200, 200));

        jTabbedPane1.addTab("home", home);

        billing.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                billingComponentShown(evt);
            }
        });
        billing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(51, 51, 51));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 0, 51));
        jLabel52.setText("0000");
        billing.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 220, 30));

        jLabel56.setBackground(new java.awt.Color(51, 51, 51));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("Customer Id");
        billing.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 30));

        jLabel57.setBackground(new java.awt.Color(51, 51, 51));
        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setText("Bill No:-");
        billing.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 30));
        billing.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 10));
        billing.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 960, 20));

        jLabel38.setBackground(new java.awt.Color(51, 51, 51));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Product Id");
        billing.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, 30));

        jLabel58.setBackground(new java.awt.Color(51, 51, 51));
        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Product Name");
        billing.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 100, 30));

        jLabel59.setBackground(new java.awt.Color(51, 51, 51));
        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Product Details");
        billing.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 140, 30));

        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        billing.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 510, 30));

        jLabel60.setBackground(new java.awt.Color(51, 51, 51));
        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Price");
        billing.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 50, 30));
        billing.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 110, 30));

        jLabel61.setBackground(new java.awt.Color(51, 51, 51));
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Quantity");
        billing.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 70, 30));
        billing.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 100, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        billing.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 50, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        billing.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 50, 30));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "p_id", "Name", "Price ", "Quantity", "Total"
            }
        ));
        jTable2.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        jTable2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        jTable2.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        jTable2.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        jTable2.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        jTable2.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane5.setViewportView(jTable2);

        billing.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 650, 240));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/add.png"))); // NOI18N
        jButton10.setText("ADD");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        billing.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, -1, 40));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel29.setText(" Calculation Details:-");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        billing.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 270, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel30.setText("Total Amount");
        billing.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, 30));

        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        billing.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 340, 170, 30));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/save.png"))); // NOI18N
        jButton11.setText("Save");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        billing.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 680, -1, 40));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel62.setText("Paid Amount");
        billing.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 110, 30));

        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField29KeyReleased(evt);
            }
        });
        billing.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 160, 30));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/Reset.png"))); // NOI18N
        jButton12.setText("Reset");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        billing.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 680, -1, 40));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel63.setText("Discount");
        billing.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 110, 30));

        jTextField34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billing.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, 160, 40));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("Date:-");
        billing.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel66.setText("00-00-000");
        billing.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setText("Time:-");
        billing.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, -1, 20));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel68.setText("00:00");
        billing.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, 20));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".", "5", "10", "15", "20", "25", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", " " }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jComboBox5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox5KeyReleased(evt);
            }
        });
        billing.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 410, 130, 30));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel69.setText("Return /Due");
        billing.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 120, 60));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        billing.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 250, -1, 320));

        jLabel85.setBackground(new java.awt.Color(51, 51, 51));
        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setText("Product Type");
        billing.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 120, 30));

        jLabel86.setBackground(new java.awt.Color(51, 51, 51));
        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel86.setText(" Name");
        billing.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 30));

        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40ActionPerformed(evt);
            }
        });
        billing.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 350, 30));

        jLabel87.setBackground(new java.awt.Color(51, 51, 51));
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel87.setText("Address");
        billing.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 100, 30));

        jTextField41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField41ActionPerformed(evt);
            }
        });
        billing.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 330, 30));

        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42ActionPerformed(evt);
            }
        });
        billing.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 200, 30));

        jLabel88.setBackground(new java.awt.Color(51, 51, 51));
        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel88.setText("Contact No:-");
        billing.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 100, 30));

        jTextField43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField43ActionPerformed(evt);
            }
        });
        billing.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, 30));

        jLabel89.setBackground(new java.awt.Color(51, 51, 51));
        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel89.setText("Email Id");
        billing.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 30));

        jLabel90.setBackground(new java.awt.Color(51, 51, 51));
        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel90.setText("Gender");
        billing.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 100, 30));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/save.png"))); // NOI18N
        jLabel53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        billing.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 20, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "male", "female", "other" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6jComboBox1ActionPerformed(evt);
            }
        });
        billing.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 90, 30));

        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });
        billing.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 240, 30));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel92.setText("D-Amount");
        billing.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 90, 50));

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel115.setText("Available Quantity :-");
        billing.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jTextField30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        billing.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 170, 30));

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/Reset.png"))); // NOI18N
        jLabel94.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
        });
        billing.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 20, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("00");
        billing.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 140, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        billing.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 150, 30));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        billing.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 740));
        billing.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 40, 20));

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel91.setText("0000");
        billing.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, 30));
        billing.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 240, 30));

        jTabbedPane1.addTab("billing", billing);

        product.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                productComponentShown(evt);
            }
        });
        product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setBackground(new java.awt.Color(51, 51, 51));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel32.setText("Product Id");
        product.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        jLabel33.setBackground(new java.awt.Color(51, 51, 51));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Product Name");
        product.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 30));
        product.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 320, 30));

        jLabel34.setBackground(new java.awt.Color(51, 51, 51));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Buying Price");
        product.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 100, 30));

        jLabel35.setBackground(new java.awt.Color(51, 51, 51));
        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Selling Price");
        product.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 100, 30));
        product.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 100, 30));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        product.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, 100, 30));

        jLabel36.setBackground(new java.awt.Color(51, 51, 51));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Date");
        product.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 130, 30));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2jComboBox1ActionPerformed(evt);
            }
        });
        product.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 100, 30));

        jLabel37.setBackground(new java.awt.Color(51, 51, 51));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Quantity");
        product.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 100, 30));
        product.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 100, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        product.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 960, -1));

        jLabel71.setBackground(new java.awt.Color(51, 51, 51));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setText("Product Type");
        product.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 140, 30));
        product.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 320, 30));

        jLabel50.setBackground(new java.awt.Color(51, 51, 51));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Product Details");
        product.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 30));
        product.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 320, 30));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        product.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 10));

        jLabel75.setBackground(new java.awt.Color(51, 51, 51));
        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setText("Sellers Id");
        product.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/save.png"))); // NOI18N
        jButton18.setText("Save");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        product.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 120, 40));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/update.png"))); // NOI18N
        jButton20.setText("Update");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        product.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 120, 40));

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/delete.png"))); // NOI18N
        jButton21.setText("Delete");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        product.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 110, 40));

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "P- Id", "Name", "Type", "Details", "B- Price", "S- Price", "Quantity", "Date", "S- Id"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetro2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro2.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro2.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        rSTableMetro2.setFuenteHead(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        rSTableMetro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro2MouseClicked(evt);
            }
        });
        rSTableMetro2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                rSTableMetro2ComponentShown(evt);
            }
        });
        jScrollPane6.setViewportView(rSTableMetro2);

        product.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 960, 380));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setText(" Id :- ");
        product.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, 30));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        product.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 960, 10));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 0, 0));
        jLabel78.setText("0000");
        jLabel78.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel78KeyReleased(evt);
            }
        });
        product.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 300, 30));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setText("01");
        jLabel77.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel77ComponentShown(evt);
            }
        });
        product.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 170, 30));
        product.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, 170, 30));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/search x30.png"))); // NOI18N
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });
        product.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        product.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 330, 30));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/Reset.png"))); // NOI18N
        jButton19.setText("Refresh");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        product.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 40));

        jLabel81.setBackground(new java.awt.Color(51, 51, 51));
        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel81.setText("Search");
        product.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 60, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        product.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("tab9", product);

        customer.setBackground(new java.awt.Color(255, 255, 255));
        customer.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                customerComponentShown(evt);
            }
        });
        customer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setBackground(new java.awt.Color(51, 51, 51));
        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Customer Id :-");
        customer.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 30));

        jLabel46.setBackground(new java.awt.Color(51, 51, 51));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText(" Name");
        customer.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));
        customer.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 350, 30));

        jLabel47.setBackground(new java.awt.Color(51, 51, 51));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Search");
        customer.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 60, 30));

        jLabel48.setBackground(new java.awt.Color(51, 51, 51));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Contact No:-");
        customer.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 100, 30));
        customer.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 330, 30));
        customer.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 200, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "male", "female", "other" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4jComboBox1ActionPerformed(evt);
            }
        });
        customer.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 160, 30));

        jLabel49.setBackground(new java.awt.Color(51, 51, 51));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Gender");
        customer.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 100, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        customer.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 960, 10));

        jLabel70.setBackground(new java.awt.Color(51, 51, 51));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setText("Email Id");
        customer.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));
        customer.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, 30));

        rSTableMetro3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Customer Id", "Name", "Address", "Email", "Contact", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro3.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetro3.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro3.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro3.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro3.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        rSTableMetro3.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSTableMetro3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rSTableMetro3);

        customer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 950, 440));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        customer.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 950, 10));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        customer.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 950, 10));

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/Reset.png"))); // NOI18N
        jButton22.setText("Refresh");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        customer.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 40));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/save.png"))); // NOI18N
        jButton23.setText("Save");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        customer.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 120, 40));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/update.png"))); // NOI18N
        jButton24.setText("Update");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        customer.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 120, 40));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/delete.png"))); // NOI18N
        jButton25.setText("Delete");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        customer.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 120, 40));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 0, 0));
        jLabel80.setText("0000");
        customer.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 400, 30));

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/search x30.png"))); // NOI18N
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
        });
        customer.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        customer.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 340, 30));

        jLabel74.setBackground(new java.awt.Color(51, 51, 51));
        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setText("Address");
        customer.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 100, 30));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        customer.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 740));

        jTabbedPane1.addTab("customer", customer);

        seller.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                sellerComponentShown(evt);
            }
        });
        seller.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(51, 51, 51));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("Seller Id :-");
        seller.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 30));

        jLabel40.setBackground(new java.awt.Color(51, 51, 51));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel40.setText("Seller Name");
        seller.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 30));
        seller.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 250, 30));

        jLabel41.setBackground(new java.awt.Color(51, 51, 51));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel41.setText("Seller Company");
        seller.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, 30));

        jLabel42.setBackground(new java.awt.Color(51, 51, 51));
        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel42.setText("Selling Address");
        seller.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 130, 30));
        seller.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 400, 30));
        seller.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 400, 30));

        jLabel43.setBackground(new java.awt.Color(51, 51, 51));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel43.setText("Contact 1");
        seller.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 100, 30));
        seller.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 150, 30));

        jLabel44.setBackground(new java.awt.Color(51, 51, 51));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel44.setText("Product Type");
        seller.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 30));
        seller.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 250, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        seller.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 960, 10));

        jLabel51.setBackground(new java.awt.Color(51, 51, 51));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel51.setText("Contact 2");
        seller.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 100, 30));

        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        seller.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 160, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/save.png"))); // NOI18N
        jButton13.setText("Save");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        seller.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, 40));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/delete.png"))); // NOI18N
        jButton15.setText("Delete");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        seller.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 120, 40));

        rSTableMetro5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Seller Id", "Name", "Company", "Address", "Type", "Contact 1", " Contact 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro5.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        rSTableMetro5.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetro5.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro5.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro5.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro5.setFuenteHead(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rSTableMetro5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro5MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(rSTableMetro5);
        if (rSTableMetro5.getColumnModel().getColumnCount() > 0) {
            rSTableMetro5.getColumnModel().getColumn(0).setHeaderValue("Seller Id");
            rSTableMetro5.getColumnModel().getColumn(1).setHeaderValue("Name");
            rSTableMetro5.getColumnModel().getColumn(2).setHeaderValue("Company");
            rSTableMetro5.getColumnModel().getColumn(3).setHeaderValue("Address");
            rSTableMetro5.getColumnModel().getColumn(4).setHeaderValue("Type");
            rSTableMetro5.getColumnModel().getColumn(5).setHeaderValue("Contact 1");
            rSTableMetro5.getColumnModel().getColumn(6).setHeaderValue(" Contact 2");
        }

        seller.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 960, 360));

        jLabel72.setBackground(new java.awt.Color(51, 51, 51));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel72.setText("Email Id");
        seller.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 30));
        seller.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 250, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        seller.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 960, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        seller.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 960, 10));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/update.png"))); // NOI18N
        jButton17.setText("Update");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        seller.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 120, 40));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 0, 0));
        jLabel73.setText("0000");
        seller.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 410, 30));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/Reset.png"))); // NOI18N
        jButton16.setText("Refresh");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        seller.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 40));

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/search x30.png"))); // NOI18N
        jLabel83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel83MouseClicked(evt);
            }
        });
        seller.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        seller.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 330, 30));

        jLabel84.setBackground(new java.awt.Color(51, 51, 51));
        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel84.setText("Search");
        seller.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 60, 30));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        seller.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 740));

        jTabbedPane1.addTab("seller", seller);

        stock.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                stockComponentShown(evt);
            }
        });
        stock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Seller Id", "Name", "Company", "Address", "Type", "Contact 1", " Contact 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro9.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetro9.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro9.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro9.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro9.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        rSTableMetro9.setFuenteHead(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rSTableMetro9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro9MouseClicked(evt);
            }
        });
        rSTableMetro9.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                rSTableMetro9ComponentShown(evt);
            }
        });
        jScrollPane11.setViewportView(rSTableMetro9);
        if (rSTableMetro9.getColumnModel().getColumnCount() > 0) {
            rSTableMetro9.getColumnModel().getColumn(0).setHeaderValue("Seller Id");
            rSTableMetro9.getColumnModel().getColumn(1).setHeaderValue("Name");
            rSTableMetro9.getColumnModel().getColumn(2).setHeaderValue("Company");
            rSTableMetro9.getColumnModel().getColumn(3).setHeaderValue("Address");
            rSTableMetro9.getColumnModel().getColumn(4).setHeaderValue("Type");
            rSTableMetro9.getColumnModel().getColumn(5).setHeaderValue("Contact 1");
            rSTableMetro9.getColumnModel().getColumn(6).setHeaderValue(" Contact 2");
        }

        stock.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 960, 650));

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });
        stock.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 530, 40));

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel112.setText("Search Quantity:-");
        jLabel112.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel112KeyReleased(evt);
            }
        });
        stock.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 40));

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/search x30.png"))); // NOI18N
        jLabel113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel113MouseClicked(evt);
            }
        });
        stock.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 90, 60));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        stock.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("stock", stock);

        totalsell.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                totalsellComponentShown(evt);
            }
        });
        totalsell.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Seller Id", "Name", "Company", "Address", "Type", "Contact 1", " Contact 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro7.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetro7.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro7.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro7.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro7.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        rSTableMetro7.setFuenteHead(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jScrollPane9.setViewportView(rSTableMetro7);
        if (rSTableMetro7.getColumnModel().getColumnCount() > 0) {
            rSTableMetro7.getColumnModel().getColumn(0).setHeaderValue("Seller Id");
            rSTableMetro7.getColumnModel().getColumn(1).setHeaderValue("Name");
            rSTableMetro7.getColumnModel().getColumn(2).setHeaderValue("Company");
            rSTableMetro7.getColumnModel().getColumn(3).setHeaderValue("Address");
            rSTableMetro7.getColumnModel().getColumn(4).setHeaderValue("Type");
            rSTableMetro7.getColumnModel().getColumn(5).setHeaderValue("Contact 1");
            rSTableMetro7.getColumnModel().getColumn(6).setHeaderValue(" Contact 2");
        }

        totalsell.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 960, 610));

        jLabel93.setBackground(new java.awt.Color(51, 51, 51));
        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel93.setText("Search");
        totalsell.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 30));

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        totalsell.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 640, 30));
        totalsell.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 30, 10));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        totalsell.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("totalsell", totalsell);

        due.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                dueComponentMoved(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dueComponentShown(evt);
            }
        });
        due.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Seller Id", "Name", "Company", "Address", "Type", "Contact 1", " Contact 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro8.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        rSTableMetro8.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro8.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        rSTableMetro8.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        rSTableMetro8.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        rSTableMetro8.setFuenteHead(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rSTableMetro8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro8MouseClicked(evt);
            }
        });
        rSTableMetro8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                rSTableMetro8ComponentShown(evt);
            }
        });
        jScrollPane10.setViewportView(rSTableMetro8);
        if (rSTableMetro8.getColumnModel().getColumnCount() > 0) {
            rSTableMetro8.getColumnModel().getColumn(0).setHeaderValue("Seller Id");
            rSTableMetro8.getColumnModel().getColumn(1).setHeaderValue("Name");
            rSTableMetro8.getColumnModel().getColumn(2).setHeaderValue("Company");
            rSTableMetro8.getColumnModel().getColumn(3).setHeaderValue("Address");
            rSTableMetro8.getColumnModel().getColumn(4).setHeaderValue("Type");
            rSTableMetro8.getColumnModel().getColumn(5).setHeaderValue("Contact 1");
            rSTableMetro8.getColumnModel().getColumn(6).setHeaderValue(" Contact 2");
        }

        due.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 960, 440));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel96.setText("Return /Due :-");
        due.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 130, 30));

        jTextField35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });
        due.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 150, 30));

        jLabel97.setBackground(new java.awt.Color(51, 51, 51));
        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel97.setText("Bill Id :-");
        due.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 30));

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 0, 0));
        jLabel98.setText("0000");
        due.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 160, 30));

        jLabel99.setBackground(new java.awt.Color(51, 51, 51));
        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel99.setText("Search");
        due.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 60, 30));

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        due.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 340, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        due.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 960, 10));
        due.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 350, 30));
        due.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, 30));

        jLabel100.setBackground(new java.awt.Color(51, 51, 51));
        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel100.setText("Email Id");
        due.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        due.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 950, 10));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/adminIcons/Reset.png"))); // NOI18N
        jButton26.setText("Refresh");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        due.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 150, 40));

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/update.png"))); // NOI18N
        jButton28.setText("Update");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        due.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 130, 40));

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/delete.png"))); // NOI18N
        jButton29.setText("Delete");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        due.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 130, 40));

        jLabel101.setBackground(new java.awt.Color(51, 51, 51));
        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel101.setText("Contact No:-");
        due.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 100, 30));
        due.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 170, 30));

        jLabel102.setBackground(new java.awt.Color(51, 51, 51));
        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel102.setText("Gender");
        due.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 100, 30));

        jLabel103.setBackground(new java.awt.Color(51, 51, 51));
        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel103.setText("Address");
        due.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 100, 30));
        due.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 330, 30));

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        due.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 950, 10));

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/search x30.png"))); // NOI18N
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
        });
        due.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jLabel105.setBackground(new java.awt.Color(51, 51, 51));
        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel105.setText(" Name");
        due.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 30));

        jLabel106.setBackground(new java.awt.Color(51, 51, 51));
        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel106.setText("Customer Id :-");
        due.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 110, 30));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 0, 0));
        jLabel107.setText("0000");
        due.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 160, 30));
        due.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 200, 30));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        due.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("due", due);

        setting.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                settingComponentShown(evt);
            }
        });
        setting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        jTable4.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        jTable4.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        jTable4.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        jTable4.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable4);

        setting.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 950, 430));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/pro/img/delete.png"))); // NOI18N
        jButton30.setText("Delete");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        setting.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 950, 40));

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/security-599626660bcbf.png"))); // NOI18N
        setting.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 820, 190));
        setting.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 50, 20));

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/ba (7).png"))); // NOI18N
        setting.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("setting", setting);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 980, 780));

        setSize(new java.awt.Dimension(1200, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
jTabbedPane1.setSelectedIndex(0);          // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
jTabbedPane1.setSelectedIndex(1);  
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
                 int a=JOptionPane.showConfirmDialog(null,"Do you really want to Exit","Select",JOptionPane.YES_NO_OPTION);
        if (a==0)
        {
            System.exit(0);
        
    }                      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
                 this.setState(ICONIFIED);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
 
           
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
 
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
   // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
jTabbedPane1.setSelectedIndex(2);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
jTabbedPane1.setSelectedIndex(3);       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
jTabbedPane1.setSelectedIndex(4);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
jTabbedPane1.setSelectedIndex(5);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
jTabbedPane1.setSelectedIndex(6);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
jTabbedPane1.setSelectedIndex(7);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
jTabbedPane1.setSelectedIndex(8);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
 dispose();
        new NewSignin().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jComboBox2jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2jComboBox1ActionPerformed
      String  name =jComboBox2.getSelectedItem().toString();
        try {
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT s_id,name FROM seller  WHERE name ='"+name+"'  ");
            if (rs.next()) {
                 
               
                jLabel77.setText(rs.getString("s_id"));
               
             
             
                
                
            }
          
        
        
             
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
            
               
                
       

    }//GEN-LAST:event_jComboBox2jComboBox1ActionPerformed

    private void jComboBox4jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4jComboBox1ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
 String name=jTextField31.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from product where p_detail like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox3.setSelectedItem(rs.getString(1));
                jTextField4.setText(rs.getString(2));
                jTextField39.setText(rs.getString(3));
                jTextField31.setText(rs.getString(4));
                jTextField32.setText(rs.getString(6));
                
            }
            else
            {
                jTextField32.setText("");
                jTextField39.setText("");
                jTextField4.setText("");
               
                 jComboBox3.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int price=Integer.parseInt(jTextField32.getText());
        int quantity=Integer.parseInt(jTextField33.getText());
        int total=price*quantity;
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        model.addRow(new Object[]{jComboBox3.getSelectedItem().toString(),jTextField4.getText(),jTextField32.getText(),price,quantity,total});
        finalTotal=finalTotal+total;
        String finalTotal1=String.valueOf(finalTotal);
        jTextField25.setText(finalTotal1);  
          jTextField25.setEditable(false);
       

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            
        
          String id=jLabel52.getText();
        String date =jLabel66.getText();
        String time=jLabel68.getText();
        String c_id=jComboBox1.getSelectedItem().toString();
       
        
         
                
                String p_id = jLabel54.getText();
                String name = jLabel54.getText();
                String price= jLabel54.getText();
              
                String quantity = jLabel54.getText();
                String total =jLabel54.getText();
        
     
        String total_amount=jTextField25.getText();
        String discount=jComboBox5.getSelectedItem().toString();
        String d_amount=jTextField30.getText();
        String paid=jTextField29.getText();
        String returrn=jTextField34.getText();
       
        
       
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
          st.executeUpdate("insert into billing values('"+id+"','"+date+"','"+time+"','"+c_id+"','"+p_id+"','"+name+"','"+price+"','"+quantity+"','"+total+"','"+total_amount+"','"+discount+"','"+d_amount+"','"+paid+"','"+returrn+"')");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "Data Saved");
           
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
  
        try {
         
       
        String id=jLabel54.getText();
        String date =jLabel54.getText();
        String time=jLabel54.getText();
        String c_id=jLabel54.getText();
       String total_amount=jLabel54.getText();
        String discount=jLabel54.getText();
        String d_amount=jLabel54.getText();
        String paid=jLabel54.getText();
        String returrn=jLabel54.getText();
      
           DefaultTableModel dt = (DefaultTableModel) jTable2.getModel();
           
          int rc = dt.getRowCount();
          
            for (int i = 0; i < rc; i++) {
                
                String p_id = dt.getValueAt(i, 0).toString(); // get inid
                String name = dt.getValueAt(i, 1).toString(); // get product name
                String price= dt.getValueAt(i, 2).toString(); // get barcode
              
                String quantity = dt.getValueAt(i, 3).toString(); // get product unit price
                String total = dt.getValueAt(i, 4).toString(); // get
        
        
        
       ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
          st.executeUpdate("insert into billing values('"+id+"','"+date+"','"+time+"','"+c_id+"','"+p_id+"','"+name+"','"+price+"','"+quantity+"','"+total+"','"+total_amount+"','"+discount+"','"+d_amount+"','"+paid+"','"+returrn+"')");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "product added in Bill");
           
            
             }
            
                
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      String TotalStock=jLabel31.getText();
        int z=Integer.parseInt(TotalStock);
        String get=jTextField33.getText();
        int i=Integer.parseInt(get);
        int A=Integer.parseInt(get);
        A=z-i;
        String B=String .valueOf(A);
        jTextField4.setText(B);
        jTextField4.setEditable(false);
        String d=jComboBox3.getSelectedItem().toString();
        String qu=jTextField4.getText();
          
          
            
            
        
        
         try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        
           st.executeUpdate("UPDATE product SET quantity='"+qu+"'WHERE p_id ='"+d+"' ");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "Added in stock");
            } catch (SQLException e) {
            System.out.println(e);
        }
  
         
        
         
         
         
         
         
         String name=jTextField40.getText();
        String contactNo=jTextField42.getText();
        String aadharNo=jTextField43.getText();
        String address=jTextField41.getText();
        String path="S:\\";
        com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
        try 
        {
            PdfWriter.getInstance(doc, new FileOutputStream(path+jLabel66.getText()+""+name+" "+".pdf"));
            doc.open();
            Paragraph paragraph1=new Paragraph("                                               Variety Store\n                               Contact Number:(+91)9681819488\n\n");
            doc.add(paragraph1);
            Paragraph paragraph2=new Paragraph("Date & Time:- "+jLabel66.getText()+" "+jLabel68.getText()+"\nName:- "+name+"\nContact No:- "+contactNo+"\nEmail Id:- "+aadharNo+"\nAddress:- "+address+"\n\n");
            doc.add(paragraph2);
            PdfPTable tb1=new PdfPTable(5);
            tb1.addCell("p_id");
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Sub Total");
         
            
            
            for(int v=0;v<jTable2.getRowCount();v++)
            
            {
                String n=jTable2.getValueAt(v, 0).toString();
                  String k =jTable2.getValueAt(v, 0).toString();
                String r=jTable2.getValueAt(v, 2).toString();
                String q=jTable2.getValueAt(v, 3).toString();
                String s=jTable2.getValueAt(v, 4).toString();
                tb1.addCell(n);
                 tb1.addCell(k);
                  tb1.addCell(r);
                   tb1.addCell(q);
                    tb1.addCell(s);
                    
            }
                doc.add(tb1);
                Paragraph paragraph3=new Paragraph("\nTotal Amount = "+jTextField25.getText()+"\nDiscount = "+jComboBox5.getSelectedItem().toString()+"\nDiscount Amount = "+jTextField30.getText()+"\nPaid Amount= "+jTextField29.getText()+"\nDue/Return Amount= "+jTextField34.getText()+"\n\nThanks you for Visting !Please Come Again.\nVariety Store");
                
                doc.add(paragraph3);
                JOptionPane.showMessageDialog(null,"Bill Generated");
               
                  
                
        }
            
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
          
        
        
            
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        
        
        
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
 jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(1);  
         billingclear();          // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
                         
                         
        String Seller_id=jLabel73.getText();
        String Seller_name=jTextField14.getText();
        String Seller_company=jTextField15.getText();
        String Seller_address=jTextField16.getText();
        String Product_type=jTextField18.getText();
        String Seller_email=jTextField38.getText();
        String Contact_1=jTextField17.getText();
        String Contact_2=jTextField24.getText();
      
        try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
          // `pid`, `Product_Name`, `Bar_code`, `Price`, `Qty`, `Sid` 
            st.executeUpdate("insert into seller values('"+Seller_id+"','"+Seller_name+"','"+Seller_company+"','"+Seller_address+"','"+Product_type+"','"+Seller_email+"','"+Contact_1+"','"+Contact_2+"')");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(4);
            JOptionPane.showMessageDialog(null, "Data Saved");
            sellerclear();
             } catch (SQLException e) {
            System.out.println(e);
        }
  
        
        
         tb_load();
        
          
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
 String id = jLabel73.getText();
       
        try {
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            st.executeUpdate("DELETE FROM seller WHERE s_id = '"+id+"' ");
            JOptionPane.showMessageDialog(null, "Data Deleted");
            jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(4);
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        sellerclear();
        
         tb_load();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
 jPanel7.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
 jPanel6.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
 jPanel8.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
 jPanel10.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
 jPanel5.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
 jPanel12.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
 jPanel13.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
 jPanel11.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
 jPanel9.setBackground(mouseEnterColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
jPanel6.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
jPanel7.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
jPanel8.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
jPanel10.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
jPanel5.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
jPanel12.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
jPanel13.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
jPanel11.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
jPanel9.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
jPanel4.setBackground(mouseExitColor);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
  
      jPanel4.setBackground(mouseEnterColor);              // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void customerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_customerComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from customer");
            rSTableMetro3.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        } 
        try
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select max(c_id) from customer");
            if(rs.first())
            {
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                jLabel80.setText(str);
            }
            else 
                jLabel80.setText("1");
              }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
      
                    
    }//GEN-LAST:event_customerComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void sellerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_sellerComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from seller");
            rSTableMetro5.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        } // TODO add your handling code here:
        try
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select max(s_id) from seller");
            if(rs.first())
            {
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                jLabel73.setText(str);
            }
            else 
                jLabel73.setText("1");
              }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
      
    }//GEN-LAST:event_sellerComponentShown

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        
        
         String Seller_id=jLabel73.getText();
        String Seller_name=jTextField14.getText();
        String Seller_company=jTextField15.getText();
        String Seller_address=jTextField16.getText();
        String Product_type=jTextField18.getText();
        String Seller_email=jTextField38.getText();
        String Contact_1=jTextField17.getText();
        String Contact_2=jTextField24.getText();
      
       try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        
 st.executeUpdate("UPDATE seller SET name='"+Seller_name+"',company='"+Seller_company+"',address='"+Seller_address+"',product_type='"+Product_type+"',email='"+Seller_email+"',contact1='"+Contact_1+"',contact2='"+Contact_2+"' WHERE id ='"+Seller_id+"' ");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(4);
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
           sellerclear();
             } catch (SQLException e) {
            System.out.println(e);
        
        }
  
        
        
         tb_load();
        
               
    }//GEN-LAST:event_jButton17ActionPerformed

    private void rSTableMetro5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro5MouseClicked
       DefaultTableModel model = (DefaultTableModel)rSTableMetro5.getModel();
       int selectedRowIndex = rSTableMetro5.getSelectedRow();
       jLabel73.setText(model.getValueAt(selectedRowIndex, 0).toString());
      
       jTextField14.setText(model.getValueAt(selectedRowIndex, 1).toString());
       jTextField15.setText(model.getValueAt(selectedRowIndex, 2).toString());
       jTextField16.setText(model.getValueAt(selectedRowIndex, 3).toString());
       jTextField18.setText(model.getValueAt(selectedRowIndex, 4).toString());
       jTextField38.setText(model.getValueAt(selectedRowIndex, 5).toString());
       jTextField17.setText(model.getValueAt(selectedRowIndex, 6).toString());
       jTextField24.setText(model.getValueAt(selectedRowIndex, 7).toString());
    }//GEN-LAST:event_rSTableMetro5MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
         jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(4);  
         sellerclear();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(jDateChooser1.getDate());
  
        
        
        String p_id=jLabel78.getText();
        String p_name=jTextField8.getText();
        String p_type=jTextField37.getText();
        String p_detail=jTextField23.getText();
        String buying=jTextField9.getText();
        String selling=jTextField10.getText();
        String quantity=jTextField12.getText();
        String id=jLabel77.getText();
         try {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
          st.executeUpdate("insert into PRODUCT values('"+p_id+"','"+p_name+"','"+p_type+"','"+p_detail+"','"+buying+"','"+selling+"','"+quantity+"','"+date+"','"+id+"')");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(2);
            JOptionPane.showMessageDialog(null, "Data Saved");
            productclear();
            
             } catch (SQLException e) {
            System.out.println(e);
        }            
    
       
  
               
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String date = sdf.format(jDateChooser1.getDate());
  
        
        
        String p_id=jLabel78.getText();
        String p_name=jTextField8.getText();
        String p_type=jTextField37.getText();
        String p_detail=jTextField23.getText();
        String buying=jTextField9.getText();
        String selling=jTextField10.getText();
        String quantity=jTextField12.getText();
        String id=jLabel77.getText();     
         try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        
 st.executeUpdate("UPDATE product SET p_name='"+p_name+"' ,p_type='"+p_type+"',p_detail='"+p_detail+"',buying='"+buying+"',selling='"+selling+"',quantity='"+quantity+"',date='"+date+"',id='"+id+"' WHERE p_id ='"+p_id+"' ");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(2);
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
           productclear();
             } catch (SQLException e) {
            System.out.println(e);
        }
  
        
        
       
        
               
                   
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        String id = jLabel78.getText();
       
        try {
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            st.executeUpdate("DELETE FROM product WHERE p_id = '"+id+"' ");
            JOptionPane.showMessageDialog(null, "Data Deleted");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(2);
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        productclear();
        
        
    }//GEN-LAST:event_jButton21ActionPerformed

    private void rSTableMetro2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_rSTableMetro2ComponentShown
  
    }//GEN-LAST:event_rSTableMetro2ComponentShown

    private void productComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_productComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from PRODUCT");
            rSTableMetro2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }      
  try
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select max(p_id) from product");
            if(rs.first())
            {
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                jLabel78.setText(str);
            }
            else 
                jLabel78.setText("1");
              }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_productComponentShown

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel79MouseClicked

    private void rSTableMetro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro2MouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel)rSTableMetro2.getModel();
            int selectedRowIndex = rSTableMetro2.getSelectedRow();   
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRowIndex, 7).toString());  
            jDateChooser1.setDate(date);
            jLabel78.setText(model.getValueAt(selectedRowIndex, 0).toString());
             
             jTextField8.setText(model.getValueAt(selectedRowIndex, 1).toString());
             jTextField37.setText(model.getValueAt(selectedRowIndex, 2).toString());
             jTextField23.setText(model.getValueAt(selectedRowIndex, 3).toString());
             jTextField9.setText(model.getValueAt(selectedRowIndex, 4).toString());
             jTextField10.setText(model.getValueAt(selectedRowIndex, 5).toString());
             jTextField12.setText(model.getValueAt(selectedRowIndex, 6).toString());
            
             
             
             jLabel77.setText(model.getValueAt(selectedRowIndex, 8).toString()); 
                    } catch (ParseException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        String  id =jLabel77.getText();
        try {
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT s_id,name FROM seller  WHERE s_id ='"+id+"'  ");
            if (rs.next()) {
                 
              
               
               
             jComboBox2.setSelectedItem(rs.getString("name"));
             
                
                
            }
          
        
        
             
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
            
               
        
    }//GEN-LAST:event_rSTableMetro2MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
          jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(3);  
         customerclear();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
       String c_id=jLabel80.getText();
        String c_name=jTextField20.getText();
      
        String c_address=jTextField21.getText();
       
        String c_email=jTextField36.getText();
        String c_contact=jTextField22.getText();
        String gender=jComboBox4.getSelectedItem().toString();
      
        try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
         
            st.executeUpdate("insert into customer values('"+c_id+"','"+c_name+"','"+c_address+"','"+c_email+"','"+c_contact+"','"+gender+"')");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(3);
            JOptionPane.showMessageDialog(null, "Data Saved");
            customerclear();
             } catch (SQLException e) {
            System.out.println(e);
        }
  
        
        
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
       String c_id=jLabel80.getText();
        String c_name=jTextField20.getText();
      
        String c_address=jTextField21.getText();
       
        String c_email=jTextField36.getText();
        String c_contact=jTextField22.getText();
        String gender=jComboBox4.getSelectedItem().toString();
        try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        
 st.executeUpdate("UPDATE customer SET c_name='"+c_name+"' ,c_address='"+c_address+"',c_email='"+c_email+"',contact='"+c_contact+"',gender='"+gender+"' WHERE c_id ='"+c_id+"' ");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(3);
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
           customerclear();
             } catch (SQLException e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String id = jLabel80.getText();
       
        try {
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            st.executeUpdate("DELETE FROM customer WHERE c_id = '"+id+"' ");
            JOptionPane.showMessageDialog(null, "Data Deleted");
            jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(3);
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        customerclear();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jLabel77ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel77ComponentShown

           
    }//GEN-LAST:event_jLabel77ComponentShown

    private void jLabel78KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel78KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel78KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String searchString = jTextField1.getText();
        search(searchString);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
       
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
      
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void rSTableMetro3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro3MouseClicked
         DefaultTableModel model = (DefaultTableModel)rSTableMetro3.getModel();
       int selectedRowIndex = rSTableMetro3.getSelectedRow();
       jLabel80.setText(model.getValueAt(selectedRowIndex, 0).toString());
      
       jTextField20.setText(model.getValueAt(selectedRowIndex, 1).toString());
       jTextField21.setText(model.getValueAt(selectedRowIndex, 2).toString());
       jTextField36.setText(model.getValueAt(selectedRowIndex, 3).toString());
       jTextField22.setText(model.getValueAt(selectedRowIndex, 4).toString());
       jComboBox4.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
      
    }//GEN-LAST:event_rSTableMetro3MouseClicked

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel82MouseClicked

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
      
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
         String searchString = jTextField2.getText();
        searchcustomer(searchString);
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jLabel83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel83MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel83MouseClicked

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
      
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
      String searchString = jTextField3.getText();
        searchseller(searchString);
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
          jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(2);  
         productclear();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
    String  p_id =jComboBox3.getSelectedItem().toString();
        try {
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT p_id,p_name,p_detail,selling,quantity,p_type FROM product  WHERE p_id ='"+p_id+"'  ");
            if (rs.next()) {
                  jTextField4.setText(rs.getString("p_name"));
                   jTextField31.setText(rs.getString("p_detail"));
                    
                    jTextField32.setText(rs.getString("selling"));
                     jLabel31.setText(rs.getString("quantity"));
                      jTextField39.setText(rs.getString("p_type"));
               
             
             
                
                
            }
          
        
        
             
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
            
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField39ActionPerformed
 String name=jTextField39.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from product where p_type like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox3.setSelectedItem(rs.getString(1));
                jTextField4.setText(rs.getString(2));
                jTextField39.setText(rs.getString(3));
                jTextField31.setText(rs.getString(4));
                jTextField32.setText(rs.getString(6));
                
            }
            else
            {
                jTextField32.setText("");
                jTextField4.setText("");
                jTextField31.setText("");
               
                 jComboBox3.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField39ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    String  name =jComboBox1.getSelectedItem().toString();
        try {
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT c_id,c_name,c_address,gender,contact,c_email FROM customer  WHERE c_id ='"+name+"'  ");
            if (rs.next()) {
                 
               
                jTextField40.setText(rs.getString("c_name"));
                  jTextField41.setText(rs.getString("c_address"));
                    jTextField43.setText(rs.getString("c_email"));
                     jTextField42.setText(rs.getString("contact"));
                     
                     
                   jComboBox6.setSelectedItem(rs.getString("gender"));
        
             
                
                
            }
          
        
        
             
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
            
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox6jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6jComboBox1ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void billingComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_billingComponentShown
        try
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select max(c_id) from customer");
            if(rs.first())
            {
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                jLabel91.setText(str);
            }
            else 
                jLabel91.setText("1");
              }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
         try
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select max(id) from billing");
            if(rs.first())
            {
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                jLabel52.setText(str);
            }
            else 
                jLabel52.setText("1");
              }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_billingComponentShown

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        String c_id=jLabel91.getText();
        String c_name=jTextField40.getText();

        String c_address=jTextField41.getText();

        String c_email=jTextField43.getText();
        String c_contact=jTextField42.getText();
        String gender=jComboBox6.getSelectedItem().toString();

        try {

            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();

            st.executeUpdate("insert into customer values('"+c_id+"','"+c_name+"','"+c_address+"','"+c_email+"','"+c_contact+"','"+gender+"')");
            jTabbedPane1.setSelectedIndex(5);
            jTabbedPane1.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "Customer Saved");
            customerclear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Invalid");
        }

    }//GEN-LAST:event_jLabel53MouseClicked

    private void totalsellComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_totalsellComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from billing");
            rSTableMetro7.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
 try
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select max(id) from billing");
            if(rs.first())
            {
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                jLabel52.setText(str);
            }
            else 
                jLabel52.setText("1");
              }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_totalsellComponentShown

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
          String searchString = jTextField6.getText();
        searchbilling(searchString);
    }//GEN-LAST:event_jTextField6KeyReleased

    private void settingComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_settingComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from users");
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }              // TODO add your handling code here:
    }//GEN-LAST:event_settingComponentShown

    private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40ActionPerformed
        String name=jTextField40.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from customer where c_name like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox1.setSelectedItem(rs.getString(1));
                jTextField40.setText(rs.getString(2));
                jTextField41.setText(rs.getString(3));
                jTextField43.setText(rs.getString(4));
                jTextField42.setText(rs.getString(5));
                 jComboBox6.setSelectedItem(rs.getString(6));
            }
            else
            {
                jTextField41.setText("");
                jTextField43.setText("");
                jTextField42.setText("");
                jComboBox6.setSelectedItem("");
                 jComboBox1.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField40ActionPerformed

    private void jTextField29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyReleased
 tot();  
 
    }//GEN-LAST:event_jTextField29KeyReleased

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField41ActionPerformed
       String name=jTextField41.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from customer where c_address like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox1.setSelectedItem(rs.getString(1));
                jTextField40.setText(rs.getString(2));
                jTextField41.setText(rs.getString(3));
                jTextField43.setText(rs.getString(4));
                jTextField42.setText(rs.getString(5));
                 jComboBox6.setSelectedItem(rs.getString(6));
            }
            else
            {
                jTextField40.setText("");
                jTextField43.setText("");
                jTextField42.setText("");
                jComboBox6.setSelectedItem("");
                 jComboBox1.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField41ActionPerformed

    private void jTextField43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField43ActionPerformed
        String name=jTextField43.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from customer where c_email like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox1.setSelectedItem(rs.getString(1));
                jTextField40.setText(rs.getString(2));
                jTextField41.setText(rs.getString(3));
                jTextField43.setText(rs.getString(4));
                jTextField42.setText(rs.getString(5));
                 jComboBox6.setSelectedItem(rs.getString(6));
            }
            else
            {
                jTextField41.setText("");
                jTextField40.setText("");
                jTextField42.setText("");
                jComboBox6.setSelectedItem("");
                 jComboBox1.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jTextField43ActionPerformed

    private void jTextField42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42ActionPerformed
         String name=jTextField42.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from customer where contact like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox1.setSelectedItem(rs.getString(1));
                jTextField40.setText(rs.getString(2));
                jTextField41.setText(rs.getString(3));
                jTextField43.setText(rs.getString(4));
                jTextField42.setText(rs.getString(5));
                 jComboBox6.setSelectedItem(rs.getString(6));
            }
            else
            {
                jTextField41.setText("");
                jTextField43.setText("");
                jTextField40.setText("");
                jComboBox6.setSelectedItem("");
                 jComboBox1.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField42ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
     String name=jTextField4.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from product where p_name like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox3.setSelectedItem(rs.getString(1));
                jTextField4.setText(rs.getString(2));
                jTextField39.setText(rs.getString(3));
                jTextField31.setText(rs.getString(4));
                jTextField32.setText(rs.getString(6));
                
            }
            else
            {
                jTextField32.setText("");
                jTextField39.setText("");
                jTextField31.setText("");
               
                 jComboBox3.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
 String name=jTextField4.getText();
        try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from product where p_name like '"+name+"%'");
            if(rs.next())
            {
                 jComboBox3.setSelectedItem(rs.getString(1));
                jTextField4.setText(rs.getString(2));
                jTextField39.setText(rs.getString(3));
                jTextField31.setText(rs.getString(4));
                jTextField32.setText(rs.getString(6));
                
            }
            else
            {
                jTextField32.setText("");
                jTextField39.setText("");
                jTextField31.setText("");
               
                 jComboBox3.setSelectedItem("");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyReleased
      // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5KeyReleased

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
int price = Integer.parseInt(jTextField25.getText());
     
     int discount = Integer.parseInt((String)jComboBox5.getSelectedItem());
     
  int finalPrice = price - (price * discount/100)  ;
  
  jTextField30.setText(String.valueOf(finalPrice));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
     String searchString = jTextField7.getText();
        searchdue(searchString);        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
 jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(7);  
         dueclear();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
 String id =jLabel98.getText();
 String balance =jTextField35.getText();
      
       try {
            
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
        
 st.executeUpdate("UPDATE billing SET balance='"+balance+"' WHERE id ='"+id+"' ");
             jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(7);
            JOptionPane.showMessageDialog(null, "Updated Sucessfully");
            dueclear();
          
             } catch (SQLException e) {
            System.out.println(e);
        
        }
          // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
String id = jLabel98.getText();
       
        try {
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            st.executeUpdate("DELETE FROM billing WHERE id = '"+id+"' ");
            JOptionPane.showMessageDialog(null, "Data Deleted");
            jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(7);
            dueclear();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
            
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel104MouseClicked

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void dueComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dueComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_dueComponentMoved

    private void dueComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dueComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from billing");
            rSTableMetro8.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
 
    }//GEN-LAST:event_dueComponentShown

    private void rSTableMetro8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro8MouseClicked
  DefaultTableModel model = (DefaultTableModel)rSTableMetro8.getModel();
       int selectedRowIndex = rSTableMetro8.getSelectedRow();
       jLabel98.setText(model.getValueAt(selectedRowIndex, 0).toString());
      
    
      
       jLabel107.setText(model.getValueAt(selectedRowIndex, 3).toString());
     
       jTextField35.setText(model.getValueAt(selectedRowIndex, 13).toString());  
     String  name =jLabel107.getText();
        try {
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT c_id,c_name,c_address,c_email,contact,gender FROM customer  WHERE c_id ='"+name+"'  ");
            if (rs.next()) {
                 
               
                jTextField26.setText(rs.getString("c_name"));
                 jTextField28.setText(rs.getString("c_address"));
                  jTextField44.setText(rs.getString("c_email"));
                   jTextField45.setText(rs.getString("contact"));
                    jTextField27.setText(rs.getString("gender"));
               
             
             
                
                
            }
          
        
        
             
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
            
               
                
    }//GEN-LAST:event_rSTableMetro8MouseClicked

    private void rSTableMetro8ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_rSTableMetro8ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_rSTableMetro8ComponentShown

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
String id = jLabel111.getText();
       
        try {
           ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            st.executeUpdate("DELETE FROM users WHERE id = '"+id+"' ");
            JOptionPane.showMessageDialog(null, "Data Deleted");
            jTabbedPane1.setSelectedIndex(5);
         jTabbedPane1.setSelectedIndex(8);
           
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
       int selectedRowIndex = jTable4.getSelectedRow();
       jLabel111.setText(model.getValueAt(selectedRowIndex, 0).toString());
      
            // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void rSTableMetro9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSTableMetro9MouseClicked

    private void rSTableMetro9ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_rSTableMetro9ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_rSTableMetro9ComponentShown

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
String name = jTextField11.getText();
        try {
            
            DefaultTableModel dt = (DefaultTableModel) rSTableMetro9.getModel();
            dt.setRowCount(0);
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product WHERE quantity LIKE '%"+name+"%' ");
            
            while (rs.next()) {                
                Vector v = new Vector();
                
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                  v.add(rs.getString(7));
                    v.add(rs.getString(8));
                      v.add(rs.getString(9));
                
                dt.addRow(v);
                
                
            }
            
            
            
            
            
        } catch (Exception e) {
           
            
        }
         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jLabel112KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel112KeyReleased
 
        
                // TODO add your handling code here:
    }//GEN-LAST:event_jLabel112KeyReleased

    private void stockComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_stockComponentShown
try 
        {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            Statement st=cn1.createStatement();
            ResultSet rs=st.executeQuery("select *from PRODUCT");
            rSTableMetro9.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }             // TODO add your handling code here:
    }//GEN-LAST:event_stockComponentShown

    private void jLabel113MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel113MouseClicked

    private void jLabel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseClicked
jTabbedPane1.setSelectedIndex(1);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel117MouseClicked

    private void jLabel118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel118MouseClicked
jTabbedPane1.setSelectedIndex(3);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel118MouseClicked

    private void jLabel119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel119MouseClicked
jTabbedPane1.setSelectedIndex(2);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel119MouseClicked

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
jTabbedPane1.setSelectedIndex(7);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jLabel116MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel116MouseClicked
jTabbedPane1.setSelectedIndex(8);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel116MouseClicked

    private void jLabel121MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel121MouseClicked
       jTabbedPane1.setSelectedIndex(6);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel121MouseClicked
                         
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel billing;
    private javax.swing.JPanel customer;
    private org.jdatepicker.impl.DateComponentFormatter dateComponentFormatter1;
    private org.jdatepicker.impl.DateComponentFormatter dateComponentFormatter2;
    private javax.swing.JPanel due;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private rojerusan.RSTableMetro jTable2;
    private rojerusan.RSTableMetro jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel product;
    private rojerusan.RSTableMetro rSTableMetro2;
    private rojerusan.RSTableMetro rSTableMetro3;
    private rojerusan.RSTableMetro rSTableMetro5;
    private rojerusan.RSTableMetro rSTableMetro7;
    private rojerusan.RSTableMetro rSTableMetro8;
    private rojerusan.RSTableMetro rSTableMetro9;
    private javax.swing.JPanel seller;
    private javax.swing.JPanel setting;
    private javax.swing.JPanel stock;
    private javax.swing.JPanel totalsell;
    // End of variables declaration//GEN-END:variables

}
