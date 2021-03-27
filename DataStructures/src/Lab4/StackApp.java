/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

class StackApp {

    public static void main(String[] args) {
        StackArray theStack = new StackArray();  // make new stack
        System.out.println(theStack.peek());
        theStack.push(20);               // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        System.out.println(theStack.peek());
        //theStack.clean();
       
        

        while (!theStack.isEmpty()) // until it's empty,
        {                             // delete item from stack
            long value = theStack.pop();
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
       
    }  // end main()
}  // end class StackApp
////////////////////////////////////////////////////////////////

