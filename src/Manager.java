import javax.swing.*;
import java.awt.Color;
public class Manager extends javax.swing.JFrame {

    /** Creates new form Manager
     * @param getUsername
     * @param branch
     * @param customerCount
     **/
    private String username;
    private String branch;
    public Manager(String getUsername, String branch, String customerCount) {
        username = getUsername;
        this.branch = branch;
        initComponents();
        jPanel1.setBackground(new Color(0,0,0,160));
        pack();
        this.setTitle("Manager");
        branchname.setText("BRANCH - " + branch);
        customers.setText("CUSTOMERS - " + customerCount);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        branchname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        removecutomer = new javax.swing.JButton();
        changepass = new javax.swing.JButton();
        worth = new javax.swing.JButton();
        customers = new javax.swing.JLabel();
        quit = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        worthlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(631, 146));
        setMinimumSize(new java.awt.Dimension(718, 789));
        getContentPane().setLayout(null);

        branchname.setFont(new java.awt.Font("Calibri Light", 1, 30)); // NOI18N
        branchname.setForeground(new java.awt.Color(204, 255, 204));
        branchname.setText("Branch - Manager");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newlogo.png"))); // NOI18N

        removecutomer.setBackground(new java.awt.Color(51, 51, 0));
        removecutomer.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        removecutomer.setText("Remove Customers");
        removecutomer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCustomerActionPerformed(evt);
            }
        });

        changepass.setBackground(new java.awt.Color(51, 51, 0));
        changepass.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        changepass.setText("Change Password");
        changepass.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassActionPerformed(evt);
            }
        });

        worth.setBackground(new java.awt.Color(51, 51, 0));
        worth.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        worth.setText("Branch Worth");
        worth.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worthActionPerformed(evt);
            }
        });

        customers.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        customers.setForeground(new java.awt.Color(0, 204, 51));
        customers.setText("Customers - 0");

        quit.setBackground(new java.awt.Color(51, 0, 51));
        quit.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(51, 0, 51));
        logout.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        worthlabel.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        worthlabel.setForeground(new java.awt.Color(0, 204, 51));
        worthlabel.setText("Worth - 0");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(129, 129, 129)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(removecutomer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 398, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(changepass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 398, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(worth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 398, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(49, 49, 49)
                        .add(quit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(worthlabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(logout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(199, 199, 199)
                        .add(branchname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 280, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(customers, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)
                        .add(27, 27, 27)
                        .add(branchname))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(200, 200, 200)
                        .add(customers)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(worthlabel)
                .add(37, 37, 37)
                .add(worth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(changepass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(removecutomer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 164, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(quit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(logout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(41, 41, 41))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 660, 710);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (25) - Copy.jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 704, 751);

        pack();
    }

    private void removeCustomerActionPerformed(java.awt.event.ActionEvent evt) {
        String customerUsername = JOptionPane.showInputDialog("Enter customer username");
        MySQLManager.removeCustomer(branch, customerUsername);
    }

    private void changePassActionPerformed(java.awt.event.ActionEvent evt) {
        String enterPassword = JOptionPane.showInputDialog("Enter password");
        String enterPasswordAgain = JOptionPane.showInputDialog("Enter password again");
        if(!enterPassword.equals(enterPasswordAgain)){
            JOptionPane.showMessageDialog(null,  "Passwords aren't matched");
            return;
        }
        MySQLManager.changePassword(username,enterPassword,false);
    }

    private void worthActionPerformed(java.awt.event.ActionEvent evt) {
        double tempWorth = MySQLManager.getBranchWorth(branch);
        worthlabel.setText("Worth - " + tempWorth);
        JOptionPane.showMessageDialog(null, "Branch worth - " + tempWorth + "$");
    }

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Have a nice day");
        MySQLManager.closeConnections();
        System.exit(0);
    }

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }

    private javax.swing.JLabel branchname;
    private javax.swing.JButton changepass;
    private javax.swing.JLabel customers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton quit;
    private javax.swing.JButton removecutomer;
    private javax.swing.JButton worth;
    private javax.swing.JLabel worthlabel;
    // End of variables declaration//GEN-END:variables

}
