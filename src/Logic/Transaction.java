/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author corella
 */
public interface Transaction {
    public void createPurchaseOrder(ArrayList<ShoppingCar> shoppingCar);
    public void executeTransaction(ArrayList<ShoppingCar> shoppingCar);
}
