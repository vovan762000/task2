package ua.nure.bondarenko.task2.part3;

import java.util.Iterator;

public class Part3 {
    private static Queue<String> myQueue = new QueueImpl<>();

    public static void demo() {
        myQueue.enqueue("first");
        myQueue.enqueue("second");
        myQueue.enqueue("third");
        myQueue.enqueue("fourth");

        System.out.println(myQueue);

        for (Iterator<String> iter = myQueue.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println("Returns the head");
        System.out.println(myQueue.top());
        System.out.println("Removes the head");
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        System.out.println("Clear myQueue");
        myQueue.clear();
        System.out.println(myQueue);
    }

    public static void main(String[] args) {
        demo();
    }
}
