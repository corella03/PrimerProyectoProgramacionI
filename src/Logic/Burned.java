/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Karla Vanessa Ballestero Castro
 ** @date 2017-07-05
 **/
public class Burned {
    public static void burnedUsersAndProducts()
    {
        //merchant
        Merchant mr =  new Merchant("Alonso", "0", 0, " ", "", " ",1);
        Globals.merchantList.add(mr);
        Globals.user.add(mr);
        Product p1 = new Product("C12", "Cajas", 2, 200, "New","Alonso");
        Globals.merchantList.get(0).producList.add(p1);
        Product p2 = new Product("Av13", "Asiento", 50, 30, "Used","Alonso");
        Globals.merchantList.get(0).producList.add(p2);
        Product p3 = new Product("B89", "Botas", 30, 1, "New","Alonso");
        Globals.merchantList.get(0).producList.add(p3);
        //juristic
        JuristicMerchant cd= new JuristicMerchant("", "", "", "Karla", "0", 0, "3", "", "3",2);
        Globals.juristicMerchantList.add(cd); 
        Globals.user.add(cd);
        Product p4 = new Product("J12", "Jacket", 40, 2, "New","Karla");
        Globals.juristicMerchantList.get(0).producList.add(p4);
        Product p5 = new Product("T14", "Tacos", 69, 1, "New", "Karla");
        Globals.juristicMerchantList.get(0).producList.add(p5);
         Product p6 = new Product("R76", "Raton", 4, 1, "New", "Karla");
         Globals.juristicMerchantList.get(0).producList.add(p6);
        //Client
        Client cl =  new Client("", "0", 0, "1", "", "1",0);
        Globals.clientList.add(cl);
        Globals.user.add(cl);
        Client cl1 =  new Client("", "0", 0, "4", "", "4",0);
        Globals.clientList.add(cl1);
        Globals.user.add(cl1);
        
    }   
}