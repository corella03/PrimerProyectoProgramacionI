/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logic.Globals;
import Logic.History;
import Logic.Product;
import Logic.ShoppingCar;
import Logic.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-07-03
 *
 */
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
    public String quantityAvailable = "";
    User user = Globals.loggedUser;
    
    public ShoppingCarView() {
        initComponents();
        setLocationRelativeTo(null);
        getTable();
    }
    
    public void setTable() {
        shoppingCarTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = shoppingCarTable.getSelectedRow();
                sellers = (shoppingCarTable.getValueAt(i, 0).toString());
                name = (shoppingCarTable.getValueAt(i, 1).toString());
                code = (shoppingCarTable.getValueAt(i, 2).toString());
                price = (shoppingCarTable.getValueAt(i, 3).toString());
                quantityAvailable = (shoppingCarTable.getValueAt(i, 4).toString());
                amount = (shoppingCarTable.getValueAt(i, 5).toString());
                status = (shoppingCarTable.getValueAt(i, 6).toString());
            }
        });
    }
    
    public void getTable() {
        setTable();
        int listSize = user.shoppingCar.size();
        String tableArrayshoppinCar[][] = new String[listSize][7];
        Product carProduct;
        for (int i = 0; i < listSize; i++) {
            carProduct = user.shoppingCar.get(i).getProduct();
            tableArrayshoppinCar[i][0] = carProduct.sellerNameByID(carProduct.getSellerID());
            tableArrayshoppinCar[i][1] = carProduct.getName();
            tableArrayshoppinCar[i][2] = carProduct.getCode();
            tableArrayshoppinCar[i][3] = "$" + String.valueOf(carProduct.getPrice() + " c/u");
            tableArrayshoppinCar[i][4] = String.valueOf(carProduct.getAmountAvailable());
            tableArrayshoppinCar[i][5] = String.valueOf(user.shoppingCar.get(i).getShoppingAmount());
            tableArrayshoppinCar[i][6] = carProduct.getProductStatus();
        }
        shoppingCarTable.setModel(new javax.swing.table.DefaultTableModel(
                tableArrayshoppinCar,
                new String[]{
                    "Seller", "Name", "Code", "Price", "Available", "Amount", "Status"
                }
        ));
    }
    
    public void deleteToShoppingCar() {
        
        for (int i = 0; i < user.shoppingCar.size(); i++) {
            if (user.shoppingCar.get(i).getProduct().getCode().equals(code)) {
                user.shoppingCar.remove(i);
            }
        }
        getTable();
    }
    
    public void proceedToCheckout() {
        User user = Globals.loggedUser;
        for (ShoppingCar carProduct : user.shoppingCar) {
            if (!canShopProduct(carProduct)) {
                JOptionPane.showMessageDialog(null, "Can't shop more than available quantity.");
                return;
            }
        }
        History history = new History(user.getID(), Globals.getPurchaseCode());
        history.createPurchaseOrder(user.shoppingCar);
        history.executeTransaction(user.shoppingCar);
        JOptionPane.showMessageDialog(null, "Successful Purchase.");
        Globals.setPurchaseCode();
    }
    
    public boolean canShopProduct(ShoppingCar carProduct) {
        int shoppingAmount = carProduct.getShoppingAmount();
        Product product;
        product = carProduct.getProduct();
        boolean canShop = true;
        if (shoppingAmount > product.getAmountAvailable()) {
            canShop = false;
        }
        return canShop;
    }
    
    public void defineAmount() {
        Product carProduct;
        int newAmount = (Integer) QuantifySpinner.getValue();
        for (int i = 0; i < user.shoppingCar.size(); i++) {
            carProduct = user.shoppingCar.get(i).getProduct();
            if (user.shoppingCar.get(i).getProduct().getCode().equals(code)) {
                if (newAmount <= carProduct.getAmountAvailable()) {
                    user.shoppingCar.get(i).setShoppingAmount(newAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "Quantity entered is greater than the quantity of products.");
                }
            }
        }
        getTable();
    }
    
    public void returnWindows() {
        if (Globals.returnOptions == 1) {
            LoginView.ClientOptionsWindows();
        } else if (Globals.returnOptions == 2) {
            ClientOptionView.showProductsClient();
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
        DeleteButton = new javax.swing.JButton();
        proceedToChechkoutButton = new javax.swing.JButton();
        QuantifySpinner = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        shoppingCarTable = new javax.swing.JTable();
        quantifyButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        back = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        DeleteButton.setBackground(new java.awt.Color(0, 153, 153));
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/deleteToShoppingCar.png"))); // NOI18N
        DeleteButton.setText("Delete To Shopping Car");
        DeleteButton.setFocusable(false);
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
        proceedToChechkoutButton.setFocusable(false);
        proceedToChechkoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        proceedToChechkoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        proceedToChechkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedToChechkoutButtonActionPerformed(evt);
            }
        });

        shoppingCarTable.setForeground(new java.awt.Color(0, 153, 153));
        shoppingCarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seller", "Name", "Code", "Price", "Available", "Amount", "Status"
            }
        ));
        shoppingCarTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shoppingCarTable.setDropMode(javax.swing.DropMode.INSERT);
        shoppingCarTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(shoppingCarTable);
        if (shoppingCarTable.getColumnModel().getColumnCount() > 0) {
            shoppingCarTable.getColumnModel().getColumn(4).setResizable(false);
        }

        quantifyButton.setBackground(new java.awt.Color(0, 153, 153));
        quantifyButton.setForeground(new java.awt.Color(255, 255, 255));
        quantifyButton.setText("Quantify:");
        quantifyButton.setFocusable(false);
        quantifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantifyButtonActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(proceedToChechkoutButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(quantifyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(QuantifySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QuantifySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(proceedToChechkoutButton)))
                .addGap(56, 56, 56))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/return.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jMenuBar1.add(back);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("");

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
        LoginView.ClientOptionsWindows();
        this.setVisible(false);
    }//GEN-LAST:event_proceedToChechkoutButtonActionPerformed
    private void quantifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantifyButtonActionPerformed
        defineAmount();
    }//GEN-LAST:event_quantifyButtonActionPerformed
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceedToChechkoutButton;
    private javax.swing.JButton quantifyButton;
    private javax.swing.JTable shoppingCarTable;
    // End of variables declaration//GEN-END:variables
}
