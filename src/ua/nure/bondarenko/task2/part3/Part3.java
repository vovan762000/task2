package ua.nure.bondarenko.task2.part3;

import java.util.Iterator;

public class Part3 {
    public static void main(String[] args) {
        Queue<String> myQueue = new QueueImpl<>();
        myQueue.enqueue("first");
        myQueue.enqueue("second");
        myQueue.enqueue("third");
        myQueue.enqueue("fourth");

        System.out.println(myQueue);

        for (Iterator<String> iter = myQueue.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println(myQueue.top());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        myQueue.clear();
        System.out.println(myQueue);

    }
}
