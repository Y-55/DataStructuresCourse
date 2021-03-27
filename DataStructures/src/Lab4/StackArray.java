/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

import Lab2.HighArray;

// StackArray.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
public class StackArray {

    // size of stack array
    private HighArray stackArray;
    // top of stack
//--------------------------------------------------------------

    public StackArray() // constructor
    {
        // set array size
        stackArray = new HighArray();  // create array
        // no items yet
    }
//--------------------------------------------------------------

    public void push(long j) // put item on top of stack
    {
        stackArray.insert(j);
        // increment top, insert item
    }
//--------------------------------------------------------------

    public long pop() // take item from top of stack
    {
        return this.stackArray.removeAt(stackArray.size() - 1);
    }
    //--------------------------------------------------------------

    public long peek() // peek at top of stack
    {
        return this.stackArray.get(stackArray.size() - 1);
    }
//--------------------------------------------------------------

    public boolean isEmpty() // true if stack is empty
    {
        return (stackArray.size() == 0);
    }
//--------------------------------------------------------------

    //public boolean isFull() // true if stack is full
    //{
    //   return (top == maxSize - 1);
    //}
    public void clean() {
        this.stackArray.clear();
    }


//--------------------------------------------------------------
    public void printRev(){
        QueueArray queu = new QueueArray();
        while(!isEmpty()){
            
        }
    }
}  // end class StackX
