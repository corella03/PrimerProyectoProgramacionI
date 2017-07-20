/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Logic.Globals;
import Logic.Product;
import Logic.ShoppingCar;
import Logic.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-07-02
 *
 */
public class ShowProductForClientsView extends javax.swing.JFrame {

    /**
     * Creates new form Shi
     */
    public String name = "";
    public String code = "";
    public String price = "";
    public String amount = "";
    public String status = "";
    public String sellers = "";

    public ShowProductForClientsView() {
        initComponents();
        setLocationRelativeTo(null);
        getTable();
        //
        showProductsForClientsTable.setRowSelectionInterval(0, 0);//AUTO SELECT ROW IN JTABLE
    }

    public void setTable() {
        showProductsForClientsTable.addMouseListener(new MouseAdapter() {
            DefaultTableModel model = new DefaultTableModel();

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = showProductsForClientsTable.getSelectedRow();
                sellers = (showProductsForClientsTable.getValueAt(i, 0).toString());
                name = (showProductsForClientsTable.getValueAt(i, 1).toString());
                code = (showProductsForClientsTable.getValueAt(i, 2).toString());
                price = (showProductsForClientsTable.getValueAt(i, 3).toString());
                amount = (showProductsForClientsTable.getValueAt(i, 4).toString());
                status = (showProductsForClientsTable.getValueAt(i, 5).toString());
            }
        });
    }

    public static void shoppingCarWindows() {
        ShoppingCarView shoppingView = new ShoppingCarView();
        shoppingView.setVisible(true);

    }

    public void getTable() {
        setTable();
        Product product;
        int listSize = Globals.productList.size();
        String tableArray[][] = new String[listSize][6];
        for (int i = 0; i < listSize; i++) {
            product = Globals.productList.get(i);
            tableArray[i][0] = product.sellerNameByID(product.getSellerID());
            tableArray[i][1] = product.getName();
            tableArray[i][2] = product.getCode();
            tableArray[i][3] = "$" + String.valueOf(product.getPrice() + " c/u");
            tableArray[i][4] = String.valueOf(product.getAmountAvailable());
            tableArray[i][5] = product.getProductStatus();
            
        }
        showProductsForClientsTable.setModel(new javax.swing.table.DefaultTableModel(
                tableArray,
                new String[]{
                    "Seller", "Name", "Code", "Price", "Amount", "Status"
                }
        ));
    }

    public void sendToShoppingCar(int quantity) {
        User user = Globals.loggedUser;
        for (Product product : Globals.productList) {
            if (product.getCode().equals(code)) {
                ShoppingCar sc = new ShoppingCar(product, quantity);
                user.shoppingCar.add(sc);
                Size.setText(String.valueOf(user.shoppingCar.size()));
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        showProductsForClientsTable = new javax.swing.JTable();
        shoppingCarButton = new javax.swing.JButton();
        listCarButton = new javax.swing.JButton();
        Size = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        showProductsForClientsTable.setForeground(new java.awt.Color(0, 153, 153));
        showProductsForClientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seller", "Name", "Code", "Price", "Amount", "Status"
            }
        ));
        showProductsForClientsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        showProductsForClientsTable.setDropMode(javax.swing.DropMode.INSERT);
        showProductsForClientsTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(showProductsForClientsTable);
        if (showProductsForClientsTable.getColumnModel().getColumnCount() > 0) {
            showProductsForClientsTable.getColumnModel().getColumn(0).setHeaderValue("Seller");
            showProductsForClientsTable.getColumnModel().getColumn(1).setHeaderValue("Name");
            showProductsForClientsTable.getColumnModel().getColumn(2).setHeaderValue("Code");
            showProductsForClientsTable.getColumnModel().getColumn(3).setHeaderValue("Price");
            showProductsForClientsTable.getColumnModel().getColumn(4).setHeaderValue("Amount");
            showProductsForClientsTable.getColumnModel().getColumn(5).setHeaderValue("Status");
        }

        shoppingCarButton.setBackground(new java.awt.Color(0, 153, 153));
        shoppingCarButton.setForeground(new java.awt.Color(255, 255, 255));
        shoppingCarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addToShoppingCar.png"))); // NOI18N
        shoppingCarButton.setText("Add To Shopping Car");
        shoppingCarButton.setFocusable(false);
        shoppingCarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shoppingCarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shoppingCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingCarButtonActionPerformed(evt);
            }
        });

        listCarButton.setBackground(new java.awt.Color(0, 153, 153));
        listCarButton.setForeground(new java.awt.Color(255, 255, 255));
        listCarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/showToShoppingCarList.png"))); // NOI18N
        listCarButton.setText("Show Shopping Car");
        listCarButton.setFocusable(false);
        listCarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listCarButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        listCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCarButtonActionPerformed(evt);
            }
        });

        Size.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sizeShoppingCar.png"))); // NOI18N
        Size.setToolTipText("");
        Size.setFocusable(false);
        Size.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Size.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(listCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(shoppingCarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Size)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(listCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shoppingCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/return.png"))); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
    }// </editor-fold>//GEN-END:initComponents
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        LoginView.ClientOptionsWindows();
        this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void listCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCarButtonActionPerformed
        shoppingCarWindows();
        this.setVisible(false);
    }//GEN-LAST:event_listCarButtonActionPerformed

    private void shoppingCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingCarButtonActionPerformed
        //FALTA VALIDAR QUE NO SE HAYAN SELECCIONADO NINGUN VALOR EN LA TABLA.. ESO PORQUE NO
        //SE DEVE PASAR POR LOS SIGUIENTE SI NO SE HAN SELECCIONADO NINGUNA FILA
        String quantity = JOptionPane.showInputDialog("Quantity?");
        if (!quantity.isEmpty() || !quantity.equals("0")){
            sendToShoppingCar(Integer.parseInt(quantity));
        }
    }//GEN-LAST:event_shoppingCarButtonActionPerformed
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
            java.util.logging.Logger.getLogger(ShowProductForClientsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowProductForClientsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowProductForClientsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowProductForClientsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowProductForClientsView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Size;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listCarButton;
    private javax.swing.JButton shoppingCarButton;
    private javax.swing.JTable showProductsForClientsTable;
    // End of variables declaration//GEN-END:variables
}