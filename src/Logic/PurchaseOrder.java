/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-21
 *
 */
public class PurchaseOrder {

    private String name;
    private int quantity;
    private int unitPrice;
    private int totalPrice;
    private String sellerID;
    private boolean hasReview = false;
    private int starsQuantity = 0;
    private String comment = "";

    //CONTRUCTOR
    public PurchaseOrder(String name, int quantity, int unitPrice, int totalPrice, String sellerID) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.sellerID = sellerID;
    }
    //
    public String getName() {
        return name;
    }
    //
    public void setName(String name) {
        this.name = name;
    }
    //
    public int getQuantity() {
        return quantity;
    }
    //
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //
    public int getUnitPrice() {
        return unitPrice;
    }
    //
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    //
    public int getTotalPrice() {
        return totalPrice;
    }
    //
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    //
    public String getSellerID() {
        return sellerID;
    }
    //
    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }
    //
    public boolean isHasReview() {
        return hasReview;
    }
    //
    public void setHasReview(boolean hasReview) {
        this.hasReview = hasReview;
    }
    //
    public int getStarsQuantity() {
        return starsQuantity;
    }
    //
    public void setStarsQuantity(int starsQuantity) {
        this.starsQuantity = starsQuantity;
    }
    //
    public String getComment() {
        return comment;
    }
    //
    public void setComment(String comment) {
        this.comment = comment;
    }
    //

}