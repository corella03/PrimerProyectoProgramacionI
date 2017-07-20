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
public class Globals {

    public static List<User> userList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();
    public static List<History> historyList = new ArrayList<>();
    public static User loggedUser;
    public static int purchaseCode = 0;
    public static int optionsMerchant;
    public static int returnOptions;

    public static int getPurchaseCode() {
        return purchaseCode;
    }
    //
    public static void setPurchaseCode() {
        Globals.purchaseCode++;
    }
    //
    public static int getOptionsMerchant() {
        return optionsMerchant;
    }
    //
    public static int getReturnOptions() {
        return returnOptions;
    }
    //
    public static void setOptionsMerchant(int optionsMerchant) {
        Globals.optionsMerchant = optionsMerchant;
    }
    //
    public static void setReturnOptions(int returnOptions) {
        Globals.returnOptions = returnOptions;
    }
    //
}