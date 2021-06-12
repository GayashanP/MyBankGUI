import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class Customer extends javax.swing.JFrame {

    /** Creates new form Customer
     * @param getUsername
     * @param branch
     * @param tempBal
     * */
    private String tempUsername;
    private String tempBranch;
    public Customer(String getUsername, String branch,String tempBal) {
        initComponents();
        jPanel1.setBackground(new Color(0,0,0,160));
        pack();
        this.setTitle("User");
        this.tempUsername = getUsername;
        this.tempBranch = branch;
        branchname.setText("BRANCH - " + branch.toUpperCase());
        balance.setText("BALANCE - " + tempBal + "$");
        tempbalance = Double.parseDouble(tempBal);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        branchname = new javax.swing.JLabel();
        withdraw = new javax.swing.JButton();
        deposit = new javax.swing.JButton();
        transfer = new javax.swing.JButton();
        changepass = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        refresh = new Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(544, 66));
        setMinimumSize(new java.awt.Dimension(820, 860));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newlogo.png")));

        balance.setFont(new java.awt.Font("Calibri Light", 1, 18));
        balance.setForeground(new java.awt.Color(255, 51, 51));
        balance.setText("Balance - 0$");

        branchname.setFont(new java.awt.Font("Calibri Light", 1, 30));
        branchname.setForeground(new java.awt.Color(204, 255, 204));
        branchname.setText("CutomerName - Branch");

        withdraw.setBackground(new java.awt.Color(0, 0, 51));
        withdraw.setFont(new java.awt.Font("Dialog", 1, 30));
        withdraw.setText("Withdraw");
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawOrDepositActionPerformed(e,true);
            }
        });

        deposit.setBackground(new java.awt.Color(0, 0, 51));
        deposit.setFont(new java.awt.Font("Dialog", 1, 30));
        deposit.setText("Deposit");
        deposit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawOrDepositActionPerformed(e,false);
            }
        });

        transfer.setBackground(new java.awt.Color(0, 0, 20));
        transfer.setFont(new java.awt.Font("Dialog", 1, 30));
        transfer.setText("Account Transfer");
        transfer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferActionPerformed(e);
            }
        });

        changepass.setBackground(new java.awt.Color(0, 0, 51));
        changepass.setFont(new java.awt.Font("Dialog", 1, 30));
        changepass.setText("Change Password");
        changepass.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePasswordActionPerformed(e);
            }
        });

        quit.setBackground(new java.awt.Color(0, 51, 51));
        quit.setFont(new java.awt.Font("Dialog", 1, 30));
        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(0, 51, 51));
        logout.setFont(new java.awt.Font("Dialog", 1, 30));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(51, 255, 51));
        refresh.setText("Refresh");
        refresh.setGradientBackgroundColor(new java.awt.Color(255, 0, 0));
        refresh.setRounded(true);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(71, 71, 71)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(changepass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 592, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(transfer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 592, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(deposit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 592, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(withdraw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 592, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(12, 12, 12)
                            .add(refresh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(balance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(quit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(logout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(50, 50, 50))
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(237, Short.MAX_VALUE)
                    .add(branchname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 355, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(168, 168, 168)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jLabel2)
                .add(60, 60, 60)
                .add(balance)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(refresh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(withdraw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(deposit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(transfer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(changepass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 98, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(quit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(logout, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(25, 25, 25))
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel1Layout.createSequentialGroup()
                    .add(165, 165, 165)
                    .add(branchname)
                    .addContainerGap(557, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 760, 760);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (25).jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 805, 821);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(ActionEvent evt) {
        balance.setText("BALANCE - " + String.valueOf(MySQLManager.updateCustomerBalance(tempUsername,tempBranch)) + "$" );
    }

    private void withdrawOrDepositActionPerformed(ActionEvent e, boolean isWithdraw) {
        String amountIn = JOptionPane.showInputDialog("Enter amount");
        double amount = 0;
        try{
            amount = Double.parseDouble(amountIn);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Enter number");
            return;
        }
        if(amount<=0){
            JOptionPane.showMessageDialog(null, "Enter positive amount");
            return;
        }
        if(isWithdraw) {
            MySQLManager.withdraw(tempUsername,tempBranch,amount,"Withdraw");
        }else{
            MySQLManager.deposit(tempUsername,tempBranch,amount,"Deposit");
        }
    }



    private void transferActionPerformed(ActionEvent e) {
        String receiver = JOptionPane.showInputDialog("Enter receiver username");
        String amount = JOptionPane.showInputDialog("Enter amount");
        if(Double.parseDouble(amount) <= 0){
            JOptionPane.showMessageDialog(null, "Invalid amount!");
            return;
        }
        String confirmation = JOptionPane.showInputDialog("type 'CONFIRM' to proceed");
        if(!"CONFIRM".equals(confirmation)){
            JOptionPane.showMessageDialog(null, "Confirmation error!");
            return;
        }
        MySQLManager.transfer(tempUsername,tempBranch,receiver,Double.parseDouble(amount));
    }

    private void changePasswordActionPerformed(ActionEvent e) {
        String enterPassword = JOptionPane.showInputDialog("Enter password");
        String enterPasswordAgain = JOptionPane.showInputDialog("Enter password again");
        if(!enterPassword.equals(enterPasswordAgain)){
            JOptionPane.showMessageDialog(null,  "Passwords aren't matched");
            return;
        }
        MySQLManager.changePassword(tempUsername,enterPassword,true);
    }

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        JOptionPane.showMessageDialog(null,"Have a nice day");
        MySQLManager.closeConnections();
        System.exit(0);
    }


    private double tempbalance = 0;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel branchname;
    private javax.swing.JButton changepass;
    private javax.swing.JButton deposit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton quit;
    private Button refresh;
    private javax.swing.JButton transfer;
    private javax.swing.JButton withdraw;


}
