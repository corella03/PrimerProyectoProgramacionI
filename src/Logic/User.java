/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.util.List;
import java.util.ArrayList;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-15
 **/
public abstract class User implements IHistory{
    private String name;
    private int ID;
    private int age;
    private int numberOfRates;
    private String email;
    private String country;
    private String password;
    public  List<Review> reviewList;
    public  List<Product> producList;
    public User(String name, int ID, int age, String email, String country, String password) 
    {
        this.numberOfRates = 0;
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.email = email;
        this.country = country;
        this.password = password;
        producList = new ArrayList<>();
        reviewList = new ArrayList<>();
    }
    public boolean login(String email,String password) 
    {
        return this.email.equals(email) && this.password.equals(password);
    }
    
    public void qualifyRating(User user,int rating, String comment) {
        Review review = new Review(comment, rating);
        user.reviewList.add(review);
    }
    
    public String getName() 
    {
        return name;
    }
    public int getID() 
    {
        return ID;
    }
    public int getAge() 
    {
        return age;
    }
    public int getNumberOfRates() 
    {
        return numberOfRates;
    }
    public String getEmail() 
    {
        return email;
    }
    public String getCountry() 
    {
        return country;
    }
    public String getPassword() 
    {
        return password;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setID(int ID) 
    {
        this.ID = ID;
    }
    public void setAge(int age) 
    {
        this.age = age;
    }
    public void setNumberOfRates(int numberOfRates) 
    {
        this.numberOfRates = numberOfRates;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    } 
}