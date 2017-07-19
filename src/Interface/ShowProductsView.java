/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logic.Globals;
import Logic.Merchant;
import Logic.Product;
import Logic.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-27
 *
 */
public final class ShowProductsView extends javax.swing.JFrame {

    /**
     * Creates new form ShowProducts
     */
    public String name = "";
    public String code = "";
    public String price = "";
    public String amount = "";
    public String status = "";
    Merchant seller;

    public ShowProductsView() {
        initComponents();
        setLocationRelativeTo(null);
        initialView();
        getTable();
    }

    public void setTable() {
        showProductTable.addMouseListener(new MouseAdapter() {
            DefaultTableModel model = new DefaultTableModel();

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = showProductTable.getSelectedRow();
                name = (showProductTable.getValueAt(i, 0).toString());
                code = (showProductTable.getValueAt(i, 1).toString());
                price = (showProductTable.getValueAt(i, 2).toString());
                amount = (showProductTable.getValueAt(i, 3).toString());
                status = (showProductTable.getValueAt(i, 4).toString());
            }
        });
    }

    public void getTable() {
        setTable();
        Product product;
        User user = Globals.loggedUser;
        ArrayList<Product> userProducts = user.productsBySeller(user.getID());
        int listSize = userProducts.size();
        if (listSize != 0) {
            String tableArray[][] = new String[listSize][5];
            for (int i = 0; i < listSize; i++) {
                product = userProducts.get(i);
                tableArray[i][0] = product.getName();
                tableArray[i][1] = product.getCode();
                tableArray[i][2] = "$" + String.valueOf(product.getPrice() + " c/u");
                tableArray[i][3] = String.valueOf(product.getAmountAvailable());
                tableArray[i][4] = product.getProductStatus();
            }
            showProductTable.setModel(new javax.swing.table.DefaultTableModel(
                    tableArray,
                    new String[]{
                        "Name", "Code", "Price", "Amount", "Status"
                    }
            ));
        }
    }

    public void showList() {
        nameTextField.setVisible(false);
        nameLabel.setVisible(false);
        priceLabel.setVisible(false);
        priceTextField.setVisible(false);
        codeLabel.setVisible(false);
        codeTextField.setVisible(false);
        amountSpinner.setVisible(false);
        amountLabel.setVisible(false);
        statusComboBox.setVisible(false);
        statusLabel.setVisible(false);
    }

    public void showModifyProduct() {
        nameTextField.setVisible(true);
        nameLabel.setVisible(true);
        priceLabel.setVisible(true);
        priceTextField.setVisible(true);
        codeLabel.setVisible(true);
        codeTextField.setVisible(true);
        amountSpinner.setVisible(true);
        amountLabel.setVisible(true);
        statusComboBox.setVisible(true);
        statusLabel.setVisible(true);
    }

    public void initialView() {
        switch (Globals.optionsMerchant) {
            case 2:
                showModifyProduct();
                break;
            case 3:
                showList();
                multiButton.setVisible(false);
                break;
            case 4:
                showList();
                multiButton.setText("Delete");
                break;
            default:
                break;
        }
    }

    public void modifyProduct() {
        String newName = nameTextField.getText();
        String newCode = codeTextField.getText();
        int newPrice = priceTextField.getText().isEmpty() ? 0 : Integer.parseInt(priceTextField.getText());
        int newAmount = (int) amountSpinner.getValue();
        String newStatus = (String) statusComboBox.getSelectedItem();
        User user = Globals.loggedUser;

        for (Product product : Globals.productList) {
            if (product.getCode().equals(code)) {
                product.setCode(newCode);
                product.setName(newName);
                product.setPrice(newPrice);
                product.setAmountAvailable(newAmount);
                product.setProductStatus(newStatus);
            }
        }

        getTable();
    }

    public void deleteProduct() {
        for (int i = 0; i < Globals.productList.size() ; i++) {
            if (Globals.productList.get(i).getCode().equals(code)) {
                Globals.productList.remove(i);
            }
        }

        getTable();
    }

    public void optionButton() {
        if (Globals.optionsMerchant == 2) {
            modifyProduct();
        } else if (Globals.optionsMerchant == 4) {
            deleteProduct();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        showProductTable = new javax.swing.JTable();
        priceTextField = new javax.swing.JTextField();
        statusComboBox = new javax.swing.JComboBox<>();
        nameLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        codeTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        multiButton = new javax.swing.JButton();
        amountSpinner = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        returnMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        showProductTable.setForeground(new java.awt.Color(0, 153, 153));
        showProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Price", "Amount", "Status"
            }
        ));
        showProductTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(showProductTable);

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New", "Used" }));

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 153, 153));
        nameLabel.setText("Name:");

        codeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        codeLabel.setForeground(new java.awt.Color(0, 153, 153));
        codeLabel.setText("Code:");

        priceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(0, 153, 153));
        priceLabel.setText("Price:");

        amountLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        amountLabel.setForeground(new java.awt.Color(0, 153, 153));
        amountLabel.setText("Amount:");

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(0, 153, 153));
        statusLabel.setText("Product Status:");

        multiButton.setBackground(new java.awt.Color(0, 153, 153));
        multiButton.setForeground(new java.awt.Color(255, 255, 255));
        multiButton.setText("Modify");
        multiButton.setFocusable(false);
        multiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiButtonActionPerformed(evt);
            }
        });

        returnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/return.png"))); // NOI18N
        returnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(returnMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel)
                    .addComponent(amountLabel)
                    .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(235, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(multiButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void returnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnMenuMouseClicked
        LoginView.MerchantOptionsWindows();
        this.setVisible(false);
    }//GEN-LAST:event_returnMenuMouseClicked
    private void multiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiButtonActionPerformed
        optionButton();
    }//GEN-LAST:event_multiButtonActionPerformed
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
            UIManager.setLookAndFeel("com.birosoft.liquit.LiquitLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowProductsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowProductsView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton multiButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JMenu returnMenu;
    private javax.swing.JTable showProductTable;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
