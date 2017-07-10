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
 **/
public class Product {
    private String code;
    private String name;
    private int price;
    private int amount;
    private String productStatus;
    private String seller;
    public Product(String code, String name, int price, int amount, String productStatus, String seller) 
    {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.productStatus = productStatus;
        this.seller = seller;
    }
    public String getCode() 
    {
        return code;
    }
    public String getName() 
    {
        return name;
    }
    public int getPrice() 
    {
        return price;
    }
    public int getAmount() 
    {
        return amount;
    }
    public String getProductStatus()
    {
        return productStatus;
    } 
    public String getSeller() 
    {
        return seller;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    public void setProductStatus(String productStatus)
    {
        this.productStatus = productStatus;
    }  
    public void setSeller(String seller) 
    {
        this.seller = seller;
    }
}