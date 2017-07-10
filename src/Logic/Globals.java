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
public class Globals {
    public static List<User> user = new ArrayList<>();
    public static List<Client> clientList = new ArrayList<>();
    public static List<Merchant> merchantList = new ArrayList<>();
    public static List<JuristicMerchant> juristicMerchantList = new ArrayList<>();
    public static int typeUser;
    public static int userPosition;
    public static int optionsMerchant;
    public static int returnOptions;
    public static int getTypeUser()
    {
        return typeUser;
    }
    public static int getUserPosition() 
    {
        return userPosition;
    }
    public static int getOptionsMerchant() 
    {
        
        return optionsMerchant;
    }
    public static int getReturnOptions()
    {
        return returnOptions;
    }
    public static void setTypeUser(int typeUser) 
    {
        Globals.typeUser = typeUser;
    }
    public static void setUserPosition(int userPosition) 
    {
        Globals.userPosition = userPosition;
    }
    public static void setOptionsMerchant(int optionsMerchant) 
    {
        Globals.optionsMerchant = optionsMerchant;
    }
    public static void setReturnOptions(int returnOptions) 
    {
        Globals.returnOptions = returnOptions;
    }
}