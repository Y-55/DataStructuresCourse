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
public class Database {

    protected Account[] data;
    protected int nElems;

    public Database() {
        this.data = new Account[10];
        this.nElems = 0;
    }

    public boolean add(String name, double balance) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) {
                this.data[i] = new Account(name, balance);
                return true;
            }
        }
        return false;
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.length; i++) {
            if (name.equals(this.data[i].name)) {
                this.data[i] = null;
                return true;
            }
        }
        return false;
    }

    public Account search(String name) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != null) {
                if (name.equals(this.data[i].name)) {                  
                    return this.data[i];
                }
            }
        }
        return null;
    }

    public void dump() {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != null) {
                System.out.println(this.data[i].toString());
            }
        }
    }

    public double total() {
        double sum = 0;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != null) {
                sum += this.data[i].balance;
            }
        }
        return sum;
    }
}
