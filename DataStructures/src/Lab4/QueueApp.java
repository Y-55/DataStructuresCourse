/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
public class QueueApp {

    public static void main(String[] arg) {
        QueueArray queue = new QueueArray();
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        queue.enqueue(19);
        queue.enqueue(20);
        
        while(!queue.isEmpty()){
            System.out.print(queue.dequeue()+" ");
        }

    }
}
