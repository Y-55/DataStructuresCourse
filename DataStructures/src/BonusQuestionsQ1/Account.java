/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BonusQuestionsQ1;

/**
 *
 * @author Yusuf Abdulwahab
 */
public class Account {

    protected String name;
    protected double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        String information = "";
        information +=  this.name+": "+this.balance;
       
        return information;
    }
}
