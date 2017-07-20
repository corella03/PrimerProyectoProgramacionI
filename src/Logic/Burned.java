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
    //LOADING DETAILED DATA
    public static void burnedUsersAndProducts()
    {
        //Merchant
        Merchant mr =  new Merchant("Alonso", "0", 0, " ", "", " ", 1);
        Globals.userList.add(mr);
        Product p1 = new Product("C12", "Cajas", 2, 200, "New", "0");
        Globals.productList.add(p1);
        Product p2 = new Product("Av13", "Asiento", 50, 30, "Used", "0");
        Globals.productList.add(p2);
        Product p3 = new Product("B89", "Botas", 30, 6, "New", "0");
        Globals.productList.add(p3);
        //Juristic
        JuristicMerchant cd = new JuristicMerchant("", "", "", "Karla", "1", 0, "3", "", "3", 2);
        Globals.userList.add(cd);
        Product p4 = new Product("J12", "Jacket", 40, 2, "New", "1");
        Globals.productList.add(p4);
        Product p5 = new Product("T14", "Tacos", 69, 8, "New", "1");
        Globals.productList.add(p5);
        Product p6 = new Product("R76", "Raton", 4, 10, "New", "1");
        Globals.productList.add(p6);
        //Client
        Client cl =  new Client("", "0", 0, "1", "", "1",0);
        Globals.userList.add(cl);
        Client cl1 =  new Client("", "0", 0, "4", "", "4",0);
        Globals.userList.add(cl1);
    }   
}