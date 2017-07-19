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
 ** @date 2017-06-21
 *
 */
public class Product {

    private String code;
    private String name;
    private int price;
    private int amountAvailable;
    private String productStatus;
    private String sellerID;

    public Product(String code, String name, int price, int amount, String productStatus, String sellerID) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amountAvailable = amount;
        this.productStatus = productStatus;
        this.sellerID = sellerID;
    }
        
    public String sellerNameByID(String sellerID){
        String sellerName = "";
        for (User user : Globals.userList) {
            if (user.getID().equals(sellerID) && user.getType() != 0) {
                sellerName = user.getName();
                return sellerName;
            }
        }
        return sellerName;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

}
