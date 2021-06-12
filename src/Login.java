import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author pgpcg
 */
public class Login extends javax.swing.JFrame {

    private Button exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Button login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;


    public Login() {
        MySQLManager.initial();
//        MySQLManager.removeAll();
        initComponents();
        jPanel2.setBackground(new Color(0, 0, 0, 160));
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Login lg = new Login();
        lg.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        login = new Button();
        exit = new Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(642, 274));
        setMinimumSize(new java.awt.Dimension(771, 506));
        setResizable(false);
        getContentPane().setLayout(null);


        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 450));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newlogo.png")));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username :");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password :");
        jLabel4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MySQLManager.removeAll();
                JOptionPane.showMessageDialog(null, "Successfully cleared databases!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        username.setFont(new java.awt.Font("Calibri", 1, 20));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setToolTipText("enter username");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Create Account");
//        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jLabel5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                signUpLableClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        password.setFont(new java.awt.Font("Century Gothic", 1, 20));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setToolTipText("enter password");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/username.png")));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png")));

        login.setBackground(new java.awt.Color(0, 51, 51));
        login.setText("Login");
        login.setFont(new java.awt.Font("Dialog", 0, 24));
        login.setRounded(true);
        login.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(0, 51, 51));
        exit.setText("Exit");
        exit.setFont(new java.awt.Font("Dialog", 0, 24));
        exit.setRounded(true);
        exit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });


        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 561, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                                                .add(36, 36, 36)
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(jLabel6)
                                                        .add(jLabel7))
                                                .add(18, 18, 18)
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(39, 39, 39)
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(username, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                                                .add(218, 218, 218)
                                                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                                                .add(93, 93, 93)
                                                .add(exit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(92, 92, 92)
                                                .add(login, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(21, 21, 21)
                                .add(jLabel2)
                                .add(18, 18, 18)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(jLabel3)
                                                .add(username, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jLabel6))
                                .add(18, 18, 18)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jLabel4))
                                        .add(jLabel7))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(login, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(exit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(20, 20, 20))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(90, 30, 570, 390);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(0, 469, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(763, 0, 0, 469);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (25).jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 759, 469);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpLableClicked() {
        username.setText("");
        password.setText("");
        SignUp signUp = new SignUp();
        this.setVisible(false);
        signUp.setVisible(true);
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String getUsername = username.getText();
        String getPassword = password.getText();

        if( "".equals(getPassword) || "".equals(getUsername)){
            JOptionPane.showMessageDialog(null, "Both username and passwords Should Not be Empty!");
            username.setText("");
            password.setText("");
            return;
        }
        String[] results = MySQLManager.loginCheck(getUsername,getPassword,true,false);
        if(results == null){
            JOptionPane.showMessageDialog(null, "Cannot find account!");
            username.setText("");
            password.setText("");
            return;
        }
        if("INCORRECT".equals(results[0])){
            JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
            username.setText("");
            password.setText("");
            return;
        }
        if(results[0].equals("USER")){
            String branchName = results[1];
            String tempBalance = results[2];
            Customer customer = new Customer(getUsername,branchName,tempBalance);
            this.setVisible(false);
            customer.setVisible(true);
        }
        if(results[0].equals("MANAGER")){
            Manager manager = new Manager(getUsername, results[1], results[2]);
            this.setVisible(false);
            manager.setVisible(true);
        }


    }//GEN-LAST:event_loginActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Have a nice day");
        MySQLManager.closeConnections();
        System.exit(0);
    }

}
