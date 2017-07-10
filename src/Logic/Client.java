/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.util.ArrayList;
import java.util.List;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-15
 **/
public class Client extends User{
    public Client(String name, String ID, int age, String email, String country, String password, int type) {
        super(name, ID, age, email, country, password, type);
    }   
    @Override
    public List<Transaction> getTransactions() 
    {
        List<Transaction> transactionList = new ArrayList<>();
        for (int i = 0; i < producList.size(); i++) 
        {
            Product product = producList.get(i);
            Transaction newTransaction = new Transaction(product.getAmount(), product.getName(), product.getPrice(), 
                    product.getAmount()*product.getPrice());
            transactionList.add(newTransaction);
        }
        return transactionList;
    }
    @Override
    public List<Integer> getCashFlow() 
    {
        List<Integer> flowCash = new ArrayList<>();
        for (int i = 0; i < flowCash.size(); i++) {
            
        }
        return flowCash;
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
}