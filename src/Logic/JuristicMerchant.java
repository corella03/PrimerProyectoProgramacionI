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
 ** @date 2017-06-16
 **/
public class JuristicMerchant extends Merchant{ 
    private String numberOfRegistration;
    private String businessName;
    private String businessReason;
    public JuristicMerchant(String numberOfRegistration, String businessName, String businessReason, 
            String name, int ID, int age, String email, String country, String password) 
    {
        super(name, ID, age, email, country, password);
        this.numberOfRegistration = numberOfRegistration;
        this.businessName = businessName;
        this.businessReason = businessReason;
    }
    public String getNumberOfRegistration() 
    {
        return numberOfRegistration;
    }
    public String getBusinessName() 
    {
        return businessName;
    }
    public String getBusinessReason() 
    {
        return businessReason;
    }
    public void setNumberOfRegistration(String numberOfRegistration) 
    {
        this.numberOfRegistration = numberOfRegistration;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }
    public void setBusinessReason(String businessReason) 
    {
        this.businessReason = businessReason;
    } 
}