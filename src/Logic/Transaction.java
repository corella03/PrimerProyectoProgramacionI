/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-21
 *
 */
public interface Transaction {
    //
    public void createPurchaseOrder(ArrayList<ShoppingCar> shoppingCar);
    public void executeTransaction(ArrayList<ShoppingCar> shoppingCar);
    //
}
