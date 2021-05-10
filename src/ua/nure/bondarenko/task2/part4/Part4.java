package ua.nure.bondarenko.task2.part4;

import java.util.Iterator;

public class Part4 {
    private static Stack<String> myStack = new StackImpl<>();

    public static void demo() {
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        System.out.println(myStack);
        System.out.println("Iterable myStack");
        for (Iterator<String> iter = myStack.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println("Returns the top element");
        System.out.println(myStack.top());
        System.out.println("Removes and returns the top element");
        System.out.println(myStack.pop());
        for (Iterator<String> iter = myStack.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println("Clear myStack");
        myStack.clear();
        System.out.println(myStack);
    }

    public static void main(String[] args) {
        demo();
    }
}
