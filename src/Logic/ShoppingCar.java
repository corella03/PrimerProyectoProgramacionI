/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author corella
 */
public class ShoppingCar {
    
    Product product;
    int shoppingAmount;

    public ShoppingCar(Product product, int shoppingAmount) {
        this.product = product;
        this.shoppingAmount = shoppingAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getShoppingAmount() {
        return shoppingAmount;
    }

    public void setShoppingAmount(int shoppingAmount) {
        this.shoppingAmount = shoppingAmount;
    }
    
}
