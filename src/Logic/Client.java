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
public class Client extends User{
    public Client(String name, int ID, int age, String email, String country, String password) 
    {
        super(name, ID, age, email, country, password);
    }
    @Override
    public List<Product> getTransactions() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public int calculateRating() 
    {
        int rating = 0;
        for(int i = 0; i< this.reviewList.size(); i++){
            rating += this.reviewList.get(i).getRating();
        }
        return rating / this.reviewList.size();
    }
    @Override
    public List<Integer> getCashFlow() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}