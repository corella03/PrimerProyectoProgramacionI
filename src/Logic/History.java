/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-15
 *
 */
public class History implements Transaction {

    private String userID;
    private int purchaseID;
    private static ArrayList<PurchaseOrder> items = new ArrayList();
    
    public History(String userID, int purchaseID) {
        this.userID = userID;
        this.purchaseID = purchaseID;
    }
    //
    @Override
    public void createPurchaseOrder(ArrayList<ShoppingCar> shoppingCar) {
        Product product;
        String name, sellerID;
        int quantity, unitPrice, totalPrice;
        for (ShoppingCar carProduct : shoppingCar) {
            product = carProduct.getProduct();
            name = product.getName(); 
            quantity = carProduct.getShoppingAmount();
            unitPrice = product.getPrice();
            totalPrice = quantity * unitPrice;
            sellerID = product.getSellerID();
            PurchaseOrder po = new PurchaseOrder(name, quantity, unitPrice, totalPrice, sellerID);
            this.items.add(po);
        }
        Globals.historyList.add(this);
    }
    //
    @Override
    public void executeTransaction(ArrayList<ShoppingCar> shoppingCar) {        
        Product product;
        int quantity, newAmountAvailable;
        for (ShoppingCar carProduct : shoppingCar) 
        {
            product = carProduct.getProduct();
            quantity = carProduct.getShoppingAmount();
            newAmountAvailable = product.getAmountAvailable() - quantity;
            product.setAmountAvailable(newAmountAvailable);
        }
        shoppingCar.clear();
    }
    //
    public String getUserID() {
        return userID;
    }
    //
    public void setUserID(String userID) {
        this.userID = userID;
    }
    //
    public int getPurchaseID() {
        return purchaseID;
    }
    //
    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }
    //
    public ArrayList<PurchaseOrder> getItems() {
        return items;
    }
    //
    public void setItems(ArrayList<PurchaseOrder> items) {
        this.items = items;
    }
    //
}