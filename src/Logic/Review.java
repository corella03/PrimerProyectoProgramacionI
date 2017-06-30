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
 ** @date 2017-06-29
 **/
public class Review {
    private String comment;
    private int rating;
    public Review(String comment, int rating) 
    {
        this.comment = comment;
        this.rating = rating;
    }
    public String getComment() 
    {
        return comment;
    }
    public int getRating() 
    {
        return rating;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }
    public void setRating(int rating) 
    {
        this.rating = rating;
    }
}