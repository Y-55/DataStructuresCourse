// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp


////////////////////////////////////////////////////////////////
class TNode
   {
   public int iData;              // data item (key)
   public TNode leftChild;         // this node's left child
   public TNode rightChild;        // this node's right child

   public void displayNode()      // display ourself
      {
      System.out.print('{');
      System.out.print(iData);
      System.out.print("} ");
      }
   }  // end class Node
////////////////////////////////////////////////////////////////
