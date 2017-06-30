/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;
import Interface.LoginView;
import Logic.Globals;
import Logic.JuristicMerchant;
import Logic.Merchant;
import Logic.Client;
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
        Merchant mr =  new Merchant("Alonso", 0, 0, " ", "", " ");
        Globals.merchantList.add(mr);
        JuristicMerchant cd= new JuristicMerchant("", "", "", "corre", 0, 0, "3", "", "3");
        Globals.juristicMerchantList.add(cd); 
        Client cl =  new Client("", 0, 0, "1", "", "1");
        Globals.clientList.add(cl);
    }   
}