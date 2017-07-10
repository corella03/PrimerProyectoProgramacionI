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
 ** @date 2017-09-07
 **/
public class Transaction {
    private String nameSeller;
    private String clientName;
    private int productAmount;
    private String productName;
    private int unitPrice;
    private int totalPrice;

    public Transaction(int productAmount, String productName, int unitPrice, int totalPrice) {
        this.productAmount = productAmount;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }
    public String getNameSeller()
    {
        return nameSeller;
    }
    public String getClientName()
    {
        return clientName;
    }
    public int getProductAmount() 
    {
        return productAmount;
    }
    public String getProductName()
    {
        return productName;
    }
    public int getUnitPrice() 
    {
        return unitPrice;
    }
    public int getTotalPrice() 
    {
        return totalPrice;
    }
    public void setNameSeller(String nameSeller)
    {
        this.nameSeller = nameSeller;
    }
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    public void setProductAmount(int productAmount)
    {
        this.productAmount = productAmount;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    public void setUnitPrice(int unitPrice)
    {
        this.unitPrice = unitPrice;
    }
    public void setTotalPrice(int totalPrice) 
    {
        this.totalPrice = totalPrice;
    }   
}