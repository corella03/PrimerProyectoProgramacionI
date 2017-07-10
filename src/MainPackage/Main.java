/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;
import Interface.LoginView;
import Logic.Burned;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-06-15
 **/
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView login = new LoginView();
        login.setVisible(true);
        
       Burned.burnedUsersAndProducts();
    }   
}