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
 *
 */
public abstract class User{

    private String name;
    private String ID;
    private int age;
    private String email;
    private String country;
    private String password;
    private int type;
    public ArrayList<ShoppingCar> shoppingCar;

    public User(String name, String ID, int age, String email, String country, String password, int type) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.email = email;
        this.country = country;
        this.password = password;
        this.type = type;
        shoppingCar = new ArrayList();
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
    
    public ArrayList<Product> productsBySeller(String sellerID){
        ArrayList<Product> sellerProducts = new ArrayList();
        for (Product product : Globals.productList) {
            if (product.getSellerID().equals(sellerID)) {
                sellerProducts.add(product);
            }
        }
        return sellerProducts;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }
}
