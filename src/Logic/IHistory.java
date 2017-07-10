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
 ** @date 2017-06-29
 **/
public interface IHistory {
    public List<Transaction> getTransactions();// todas las compras o  ventas que han hecho 
    //En cliente el producto, cantidad, precio total ,precio unitario no es lista pero devuleve una 
    public int calculateRating();   
    public List<Integer> getCashFlow();// devuelve una lista con e todo la plata que uno gasta o gana
}