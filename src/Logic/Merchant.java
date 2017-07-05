/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.util.List;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-15
 **/
public class Merchant extends User{
    public Merchant(String name, String ID, int age, String email, String country, String password, int type) {
        super(name, ID, age, email, country, password, type);
    }  
    @Override
    public List<Product> getTransactions() 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @Override
    public int calculateRating() 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @Override
    public List<Integer> getCashFlow() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}