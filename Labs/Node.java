class Node
   {
   public int iData;              // data item (key)
   public Node next;              // next link in list
// -------------------------------------------------------------
   public Node(int id) // constructor
      {
      iData = id;
      }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////
