/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Logic.Client;
import Logic.Globals;
import Logic.JuristicMerchant;
import Logic.Merchant;
import Logic.User;
import javax.swing.JOptionPane;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-15
 **/
public class RegistryUserView extends javax.swing.JFrame {
    /**
     * Creates new form RegistryUserView
     */
    public RegistryUserView() {
        initComponents();
        setLocationRelativeTo(null);
        initialView();
    }
    public static void returnLoginView()
    {
        LoginView login = new LoginView();
        login.setVisible(true);    
    }
    public boolean checkSixSpace(String name, String email, String password, String ID,
                              String age, String country)
    {
        return !name.isEmpty() &&  !email.isEmpty() && !password.isEmpty() && ! ID.isEmpty() &&
                !age.isEmpty() && !country.isEmpty();
    }
    public static boolean checkThreeSpace(String number, String name, String reason)
    {
        return !number.isEmpty() &&  !name.isEmpty() && !reason.isEmpty();
    }
    public void cleanTextField()
    {
        nameTextField.setText("");
        IDTextField.setText("");
        emailTextField.setText("");
        passwordTextField.setText("");
        countryTextField.setText("");
        ageTextField.setText("");
        numberRegistrationTextField.setText("");
        businessNameTextField.setText("");
        businessReasonTextField.setText("");
    }
    public boolean checkUserExistence(String ID, String email)
    {
        boolean userExist = false;
        for (User object : Globals.user) 
        {
            if(object.getID() == ID || object.getEmail().equals(email))
            {
                JOptionPane.showMessageDialog(null, "This user is already registered.");
                userExist = true;
                break;
            }                  
        }
        return userExist;
    }
    public static boolean checkNumber(String ID)
    {
        boolean numbers = true;
        for (int i = 0; i < ID.length(); i++) 
        { 
            if (!Character.isDigit(ID.charAt(i))) 
            { 
                numbers = false;
            }
        }
        return numbers;
    }
    public void initialView()
    {
        businessNameLabel.setVisible(false);
        businessReasonLabel.setVisible(false);
        numberRegistrationLabel.setVisible(false);
        businessNameTextField.setVisible(false);
        businessReasonTextField.setVisible(false);
        numberRegistrationTextField.setVisible(false);
        typeLabel.setVisible(true);
        typeMerchantComboBox.setVisible(true);     
    }
    public void viewJuristicMerchant()
    {
        businessNameLabel.setVisible(true);
        businessReasonLabel.setVisible(true);
        numberRegistrationLabel.setVisible(true);
        businessNameTextField.setVisible(true);
        businessReasonTextField.setVisible(true);
        numberRegistrationTextField.setVisible(true);
    }
    public void completRegistry()
    {
        JOptionPane.showMessageDialog(null, "Successful Registration.");
        returnLoginView();
        this.setVisible(false);
    }
    public void createNewUser()
    {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String ID = IDTextField.getText();
        String age = ageTextField.getText();
        String country = countryTextField.getText();
        String numberRegistration = numberRegistrationTextField.getText();
        String businessName = businessNameTextField.getText();
        String businessReason = businessReasonTextField.getText();
        Globals.typeUser = typeMerchantComboBox.getSelectedIndex();
        if(checkSixSpace(name, email, password, ID, age, country))
        {
            if(checkNumber(age) == true)
            {
                if(checkUserExistence(ID, email) != true )
                {
                    switch (Globals.typeUser) 
                    {
                        case 0:
                            Client newClient = new Client(name, ID, Integer.parseInt(age), email, country, password, Globals.typeUser);
                            Globals.clientList.add(newClient);
                            Globals.user.add(newClient);
                            break;
                        case 1:
                            Merchant newMerchant = new Merchant(name, ID, Integer.parseInt(age), email, country, 
                                    password, Globals.typeUser);
                            Globals.merchantList.add(newMerchant);
                            Globals.user.add(newMerchant);
                            break;
                        case 2:
                            if (checkThreeSpace(numberRegistration, businessName, businessReason))
                            {
                                JuristicMerchant newJuristicMerchant = new JuristicMerchant(numberRegistration, 
                                        businessName, businessReason, name, ID,Integer.parseInt(age), email, 
                                        country, password, Globals.typeUser);
                                Globals.juristicMerchantList.add(newJuristicMerchant);
                                Globals.user.add(newJuristicMerchant);
                            }   break;
                        default:
                            break; 
                    }
                completRegistry();
                System.out.println("\nCantidad Comerciantes: " + Globals.merchantList.size());
                System.out.println("Cantidad clientes: " +Globals.clientList.size()); 
                System.out.println("Cantidad empresas: " +Globals.juristicMerchantList.size());
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "You entered some invalid data, try again");
                IDTextField.setText("");
                ageTextField.setText("");
            }
        }else
        {
            JOptionPane.showMessageDialog(this, "You must fill all the spaces.");
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

        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        numberRegistrationLabel = new javax.swing.JLabel();
        businessReasonLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        businessNameLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        typeMerchantComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        numberRegistrationTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        businessNameTextField = new javax.swing.JTextField();
        registryUserButton = new javax.swing.JButton();
        businessReasonTextField = new javax.swing.JTextField();
        IDTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        back = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Create Account");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("E-mail");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Password:");

        numberRegistrationLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        numberRegistrationLabel.setForeground(new java.awt.Color(0, 153, 153));
        numberRegistrationLabel.setText("Number of Registration:");

        businessReasonLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        businessReasonLabel.setForeground(new java.awt.Color(0, 153, 153));
        businessReasonLabel.setText("Business Reason:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Country:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Age:");

        businessNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        businessNameLabel.setForeground(new java.awt.Color(0, 153, 153));
        businessNameLabel.setText("Business Name: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("ID:");
        jLabel6.setToolTipText("");

        typeMerchantComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Client", "Seller", "Juridic" }));
        typeMerchantComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeMerchantComboBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Name:");

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(0, 153, 153));
        typeLabel.setText("Type:");

        ageTextField.setInheritsPopupMenu(true);

        registryUserButton.setBackground(new java.awt.Color(255, 255, 255));
        registryUserButton.setForeground(new java.awt.Color(255, 255, 255));
        registryUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AddUser.png"))); // NOI18N
        registryUserButton.setBorder(null);
        registryUserButton.setOpaque(false);
        registryUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registryUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IDTextField)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(countryTextField)
                                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(typeMerchantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numberRegistrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numberRegistrationLabel)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(businessNameLabel)
                                            .addComponent(businessNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(businessReasonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(businessReasonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 5, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(registryUserButton)
                        .addGap(71, 71, 71))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(registryUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberRegistrationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeMerchantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberRegistrationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(businessNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(businessReasonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(businessNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(businessReasonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setOpaque(false);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/return.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jMenuBar1.add(back);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        returnLoginView();
        this.setVisible(false);
    }//GEN-LAST:event_backMouseClicked

    private void registryUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registryUserButtonActionPerformed
        createNewUser();
        System.out.println(Globals.user.size());
    }//GEN-LAST:event_registryUserButtonActionPerformed

    private void typeMerchantComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeMerchantComboBoxActionPerformed
        int  index = typeMerchantComboBox.getSelectedIndex();
        if(index == 0 || index == 1)
        {
            initialView();

        }else if(index == 2)
        {
            viewJuristicMerchant();
        }
    }//GEN-LAST:event_typeMerchantComboBoxActionPerformed
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
            java.util.logging.Logger.getLogger(RegistryUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistryUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistryUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistryUserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistryUserView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTextField;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JMenu back;
    private javax.swing.JLabel businessNameLabel;
    private javax.swing.JTextField businessNameTextField;
    private javax.swing.JLabel businessReasonLabel;
    private javax.swing.JTextField businessReasonTextField;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel numberRegistrationLabel;
    private javax.swing.JTextField numberRegistrationTextField;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton registryUserButton;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox<String> typeMerchantComboBox;
    // End of variables declaration//GEN-END:variables
}