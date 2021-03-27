/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
////////////////////////////////////////////////////////////////
class TNode implements Comparable {

    private int iData;              // data item (key)
    private TNode leftChild;         // this node's left child
    private TNode rightChild;        // this node's right child

    public TNode(int iData) {
        this.iData = iData;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public TNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TNode leftChild) {
        this.leftChild = leftChild;
    }

    public TNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TNode rightChild) {
        this.rightChild = rightChild;
    }

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TNode)) {
            return false;
        }
        TNode x = (TNode) obj;
        return (iData == x.getiData());
    }
}  // end class Node
////////////////////////////////////////////////////////////////
