/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysoftware.LogIn;


import inventorysoftware.LogIn.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Yaseen Ameer
 */
public class NewSignin extends javax.swing.JFrame {
    

    /**
     * Creates new form NewSignin
     */
   
        
    public NewSignin() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel6.setVisible(false);
      
        
    }
public void insertSingupDetails(){
    String fname = jTextField19.getText();
     String lname = jTextField20.getText();
      String email = jTextField17.getText();
       String password = jTextField18.getText();
        String contact = jTextField21.getText();
        try {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
            String sql = "insert into USERS(fname,lname,password,email,contact) values(?,?,?,?,?)";
            PreparedStatement pst = cn1.prepareStatement(sql);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, password);
            pst.setString(4, email);
            pst.setString(5, contact);
            
           int updateRowCount = pst.executeUpdate();
            if (updateRowCount > 0 ) {
                JOptionPane.showMessageDialog(this, "Successfully Sign Up");
                NewSignin page = new NewSignin();
                page.setVisible(true);
                dispose();
                
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Information");
            }
            
        
    } catch (Exception e) {
        e.printStackTrace();
        
    }
       
    
    
   
}
 //validation
    
    public boolean validateSignup(){
        String fname = jTextField19.getText();
     String lname = jTextField20.getText();
      String email = jTextField17.getText();
       String password = jTextField18.getText();
        String contact = jTextField21.getText();
        
        if (fname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter first username");
            return false;
        }
        if (lname.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter last username");
            return false;
        }
        
        if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter password");
            return false;
        }
        
        if (email.equals("") || !email.matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "please enter valid email");
            return false;
        }
        
         if (contact.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter contact number");
            return false;
        }
        
        return true;
    }
    
    //check duplicate users
    public boolean checkDuplicateUser(){
        String fname = jTextField19.getText();
        boolean isExist = false;
        
        try {
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
           
            PreparedStatement pst = cn1.prepareStatement("select * from users where fname = ?");
            pst.setString(1, fname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isExist = true;
            }else{
                isExist = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
     //validation
    public boolean validateLogin() {
        String email = jTextField_Email.getText();
        String password = jPasswordField_Password.getText();

        if (email.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter username");
            return false;
        }
        if (password.equals("")) {
            JOptionPane.showMessageDialog(this, "please enter password");
            return false;
        }

        return true;
    }

    //verify creds
    public void login() {
        String email = jTextField_Email.getText();
        String password = jPasswordField_Password.getText();

        try {
            
            ConnectionDB cn = new ConnectionDB();
            Connection cn1 = cn.filekoneksi();
           
            PreparedStatement pst = cn1.prepareStatement("select * from users where email = ? and password = ?");
            
            
            

            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "login successful");
            Home home = new Home();
                home.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "incorrect username or password");            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_Email = new javax.swing.JTextField();
        jPasswordField_Password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel_inven = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel_inven1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_Email.setBackground(new java.awt.Color(31, 36, 42));
        jTextField_Email.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jTextField_Email.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jTextField_Email.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField_EmailMouseMoved(evt);
            }
        });
        jPanel1.add(jTextField_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 205, 260, 40));

        jPasswordField_Password.setBackground(new java.awt.Color(31, 36, 42));
        jPasswordField_Password.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jPasswordField_Password.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_Password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jPanel1.add(jPasswordField_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 305, 260, 40));

        jButton1.setBackground(new java.awt.Color(169, 224, 49));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(169, 224, 49));
        jButton1.setText("Create New User");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRequestFocusEnabled(false);
        jButton1.setVerifyInputWhenFocusTarget(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_Shield_100px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px.png"))); // NOI18N
        jButton2.setToolTipText("Twitter");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px_2.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 28));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_32px_2.png"))); // NOI18N
        jButton3.setToolTipText("Facebook");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_32px_7.png"))); // NOI18N
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 11, -1, 28));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_32px.png"))); // NOI18N
        jButton4.setToolTipText("Instagram");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_32px_3.png"))); // NOI18N
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 11, -1, 28));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px.png"))); // NOI18N
        jButton5.setToolTipText("Email");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px_2.png"))); // NOI18N
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 11, -1, 28));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_YouTube_32px.png"))); // NOI18N
        jButton6.setToolTipText("YouTube");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_YouTube_32px_1.png"))); // NOI18N
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 11, -1, 28));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(169, 224, 49));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Lock_35px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 45));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(169, 224, 49));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Male_User_35px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 45));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(169, 224, 49));
        jLabel19.setText("Email");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 70, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 172, 150, 0));

        jPanel3.setBackground(new java.awt.Color(10, 10, 10));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_32px.png"))); // NOI18N
        jButton10.setToolTipText("Close");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setRequestFocusEnabled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_30px_3.png"))); // NOI18N
        jButton10.setVerifyInputWhenFocusTarget(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 40));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_32px_1.png"))); // NOI18N
        jButton11.setToolTipText("Minimize");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusPainted(false);
        jButton11.setRequestFocusEnabled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_30px_3.png"))); // NOI18N
        jButton11.setVerifyInputWhenFocusTarget(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 40, 40));

        jLabel_inven.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel_inven.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/Untitled design (6).png"))); // NOI18N
        jLabel_inven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_invenMouseClicked(evt);
            }
        });
        jPanel3.add(jLabel_inven, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 350, 470));

        jPanel6.setBackground(new java.awt.Color(10, 10, 10));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField19.setBackground(new java.awt.Color(31, 36, 42));
        jTextField19.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jTextField19.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField19MouseMoved(evt);
            }
        });
        jTextField19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField19FocusLost(evt);
            }
        });
        jPanel6.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 160, 40));

        jTextField20.setBackground(new java.awt.Color(31, 36, 42));
        jTextField20.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jTextField20.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField20MouseMoved(evt);
            }
        });
        jPanel6.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 160, 40));

        jTextField17.setBackground(new java.awt.Color(31, 36, 42));
        jTextField17.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jTextField17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField17MouseMoved(evt);
            }
        });
        jPanel6.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 330, 40));

        jTextField18.setBackground(new java.awt.Color(31, 36, 42));
        jTextField18.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jTextField18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField18MouseMoved(evt);
            }
        });
        jPanel6.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 330, 40));

        jTextField21.setBackground(new java.awt.Color(31, 36, 42));
        jTextField21.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(255, 255, 255));
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 224, 49)));
        jTextField21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextField21MouseMoved(evt);
            }
        });
        jPanel6.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 330, 40));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(169, 224, 49));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editableimage/Untitled design (4).png"))); // NOI18N
        jLabel13.setText(" VARIETY STORE");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 340, -1));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(169, 224, 49));
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, -1));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(169, 224, 49));
        jLabel14.setText("First Name");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 90, 20));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(169, 224, 49));
        jLabel15.setText("Last Name");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 90, 20));

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(169, 224, 49));
        jLabel18.setText("Password");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 314, -1));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(169, 224, 49));
        jLabel17.setText("Contact");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 314, -1));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(169, 224, 49));
        jLabel16.setText("Email");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 314, -1));

        jButton14.setBackground(new java.awt.Color(169, 224, 49));
        jButton14.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(169, 224, 49));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_To_25px.png"))); // NOI18N
        jButton14.setText("Back");
        jButton14.setBorder(null);
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setRequestFocusEnabled(false);
        jButton14.setVerifyInputWhenFocusTarget(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 110, -1));

        jButton8.setBackground(new java.awt.Color(152, 201, 45));
        jButton8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(21, 25, 28));
        jButton8.setText("Sign up");
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 330, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 410, 560));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 450, 620));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(169, 224, 49));
        jLabel20.setText("Password");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 70, -1));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(169, 224, 49));
        jLabel21.setText("Forget Password?");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 140, -1));

        jButton7.setBackground(new java.awt.Color(152, 201, 45));
        jButton7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(21, 25, 28));
        jButton7.setText("Sign In");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 260, 40));

        jLabel_inven1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven1.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven1.setText("Connect with us on");
        jPanel1.add(jLabel_inven1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_EmailMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_EmailMouseMoved

    }//GEN-LAST:event_jTextField_EmailMouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
                
               jLabel_inven.setVisible(false);
                jPanel6.setVisible(true);
        //       jLabel7.setVisible(false);
        //       jLabel8.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField19MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19MouseMoved

    private void jTextField20MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField20MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20MouseMoved

    private void jTextField17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField17MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17MouseMoved

    private void jTextField18MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField18MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18MouseMoved

    private void jTextField21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField21MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21MouseMoved

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jPanel6.setVisible(false);
       
        jLabel_inven.setVisible(true);
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

 if (validateLogin()) {
           login();
        }
//             String user = jTextField_Email.getText();
//                String pass = jPasswordField_Password.getText();
//        
//
//        if(user.equals("admin") && pass.equals("123")){

            
//        }
//
//        else{
//
//            JOptionPane.showMessageDialog(null,"Email or Password Invalid");
//        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       if (validateSignup() == true) {
            if (checkDuplicateUser() == false) {
                 insertSingupDetails();
            }else{
               JOptionPane.showMessageDialog(this, "username already exist"); 
            }
                    
           
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jLabel_invenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_invenMouseClicked
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_invenMouseClicked

    private void jTextField19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField19FocusLost
       if (checkDuplicateUser() == true) {
            JOptionPane.showMessageDialog(this, "username already exist");
        }

    }//GEN-LAST:event_jTextField19FocusLost

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
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSignin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_inven;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField_Password;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField_Email;
    // End of variables declaration//GEN-END:variables
}
