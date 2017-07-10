/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Logic.Globals;
import Logic.Product;
import Logic.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-07-03
 **/
public class ShoppingCarView extends javax.swing.JFrame {
    /**
     * Creates new form ShoppingCarView
     */
    public String name = "";
    public String code = "";
    public String price = "";
    public String amount = "";
    public String status = "";
    public String sellers = "";
    User user = Globals.user.get(Globals.userPosition);
    public ShoppingCarView() {
        initComponents();
        setLocationRelativeTo(null);
        getTable();
    }
    public void setTable()
    {
        shoppingCarTable.addMouseListener(new MouseAdapter() 
        {
            DefaultTableModel model = new DefaultTableModel();
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = shoppingCarTable.getSelectedRow();
                sellers = (shoppingCarTable.getValueAt(i, 0).toString());
                name = (shoppingCarTable.getValueAt(i, 1).toString());    
                code = (shoppingCarTable.getValueAt(i, 2).toString());    
                price = (shoppingCarTable.getValueAt(i, 3).toString());
                amount = (shoppingCarTable.getValueAt(i, 4).toString());
                status = (shoppingCarTable.getValueAt(i, 5).toString());
            }
        });
    } 
    public int tableShoppingCarSize()
    {
        int size = 0;
        for (int i = 0; i < Globals.user.size(); i++) {
            size = size + Globals.user.get(i).shoppingCar.size();
        }
        return size;
    }
    public void getTable() 
    {
        setTable();
        String tableArrayshoppinCar[][] = new String[tableShoppingCarSize()][6];
            for (int j = 0; j < Globals.user.get(Globals.userPosition).shoppingCar.size(); j++)
            {
                tableArrayshoppinCar[j][0] = Globals.user.get(Globals.userPosition).shoppingCar.get(j).getSeller();
                tableArrayshoppinCar[j][1] = Globals.user.get(Globals.userPosition).shoppingCar.get(j).getName();
                tableArrayshoppinCar[j][2] = Globals.user.get(Globals.userPosition).shoppingCar.get(j).getCode();
                tableArrayshoppinCar[j][3] = "$" + String.valueOf(Globals.user.get(Globals.userPosition).shoppingCar.get(j).getPrice()+" c/u");
                tableArrayshoppinCar[j][4] = String.valueOf(Globals.user.get(Globals.userPosition).shoppingCar.get(j).getAmount());
                tableArrayshoppinCar[j][5] = Globals.user.get(Globals.userPosition).shoppingCar.get(j).getProductStatus();
            }
        shoppingCarTable.setModel(new javax.swing.table.DefaultTableModel(
                tableArrayshoppinCar,
                new String[]{
                    "Seller","Name","Code", "Price", "Amount", "Status"
                }
        ));
    }
    public void deleteToShoppingCar()
     {
        
        for (int i = 0; i < Globals.user.size(); i++) 
        { 
            for (int j = 0; j < Globals.user.get(i).shoppingCar.size(); j++) {
                if (code.equals(Globals.user.get(i).shoppingCar.get(j).getCode())) 
                {
                    user.shoppingCar.remove(Globals.user.get(i).shoppingCar.get(j));
                }
            }
        }
        getTable();
     }
    public void proceedToCheckout()
    {
        for (int i = 0; i < Globals.user.size(); i++) 
        { 
            for (int j = 0; j < Globals.user.get(i).shoppingCar.size(); j++) 
            {
                if (code.equals(Globals.user.get(i).shoppingCar.get(j).getCode())) 
                {
                    String nameSeller = Globals.user.get(Globals.userPosition).shoppingCar.get(j).getSeller();
                    String newAmount = (String)QuantifySpinner.getValue().toString();
                    String newName = Globals.user.get(i).shoppingCar.get(j).getName();
                    String newCode = Globals.user.get(i).shoppingCar.get(j).getCode();
                    int newPrice = Globals.user.get(i).shoppingCar.get(j).getPrice();
                    String newStatus = Globals.user.get(i).shoppingCar.get(j).getProductStatus();
                    if(Integer.parseInt(newAmount) <= Globals.user.get(i).shoppingCar.get(j).getAmount())
                    {
                        Product newProduct = new Product(newCode, newName, newPrice, Integer.parseInt(newAmount), newStatus,nameSeller);
                        Globals.clientList.get(Globals.userPosition).producList.add(newProduct);
                        deleteToShoppingCar();
                        int totalPerProduct = newPrice * Integer.parseInt(newAmount);
                        Globals.clientList.get(Globals.userPosition).getCashFlow().add(totalPerProduct);
                        for (int a = 0; a < Globals.user.size(); a++) 
                        {
                            if(Globals.user.get(a).getType() == 1 || Globals.user.get(a).getType() == 2)
                            {
                                for (int k = 0; k < Globals.user.get(a).producList.size(); k++)
                                {
                                    if (code.equals(Globals.user.get(a).producList.get(k).getCode())) 
                                    {
                                        int newQuatity = Globals.user.get(a).producList.get(k).getAmount() - Integer.parseInt(newAmount);
                                        Globals.user.get(a).producList.get(k).setAmount(newQuatity);
                                    }
                                }
                            }
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"Quantity entered is greater than the quantity of products.");
                    }
                }
            }
        }
    }
    public void returnWindows()
    {
        if (Globals.returnOptions == 1)
        {
            LoginView.ClientOptionsWindows();
        }
        else if (Globals.returnOptions == 2)
        {
            ClientOptionView.showProductsClient();
        }
    }
    public void QualifyWindow()
    {
        QualifyView qualify = new QualifyView();
        qualify.setVisible(true);
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
        DeleteButton = new javax.swing.JButton();
        proceedToChechkoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        QuantifySpinner = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        shoppingCarTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        DeleteButton.setBackground(new java.awt.Color(0, 153, 153));
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/deleteToShoppingCar.png"))); // NOI18N
        DeleteButton.setText("Delete To Shopping Car");
        DeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        proceedToChechkoutButton.setBackground(new java.awt.Color(255, 204, 0));
        proceedToChechkoutButton.setForeground(new java.awt.Color(255, 255, 255));
        proceedToChechkoutButton.setText("Proceed to checkout");
        proceedToChechkoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        proceedToChechkoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        proceedToChechkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedToChechkoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Quantify:");

        shoppingCarTable.setForeground(new java.awt.Color(0, 153, 153));
        shoppingCarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seller", "Name", "Code", "Price", "Amount", "Status"
            }
        ));
        shoppingCarTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shoppingCarTable.setDropMode(javax.swing.DropMode.INSERT);
        shoppingCarTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(shoppingCarTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(DeleteButton)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proceedToChechkoutButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(QuantifySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(DeleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(QuantifySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(proceedToChechkoutButton)))
                .addGap(56, 56, 56))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        returnWindows();
        this.setVisible(false);
    }//GEN-LAST:event_backMouseClicked
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        deleteToShoppingCar();
    }//GEN-LAST:event_DeleteButtonActionPerformed
    private void proceedToChechkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedToChechkoutButtonActionPerformed
        proceedToCheckout();
        QualifyWindow();
    }//GEN-LAST:event_proceedToChechkoutButtonActionPerformed
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
            java.util.logging.Logger.getLogger(ShoppingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShoppingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShoppingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingCarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCarView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JSpinner QuantifySpinner;
    private javax.swing.JMenu back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceedToChechkoutButton;
    private javax.swing.JTable shoppingCarTable;
    // End of variables declaration//GEN-END:variables
}