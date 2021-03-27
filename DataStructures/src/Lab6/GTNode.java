/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 * @param <T>
 */
public class GTNode<T extends Comparable>implements Comparable{

    protected T iData;
    protected GTNode leftChild;
    protected GTNode rightChild;

    public GTNode(T data) {
        this.iData = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getiData() {
        return iData;
    }

    public void setiData(T iData) {
        this.iData = iData;
    }

    public GTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(GTNode leftChild) {
        this.leftChild = leftChild;
    }

    public GTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(GTNode rightChild) {
        this.rightChild = rightChild;
    }

    public void displayNode() 
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
