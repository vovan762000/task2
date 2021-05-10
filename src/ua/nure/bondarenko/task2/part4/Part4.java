package ua.nure.bondarenko.task2.part4;

import java.util.Iterator;

public class Part4 {
    public static void main(String[] args) {
        Stack<String> myStack = new StackImpl<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        System.out.println(myStack);
        for (Iterator<String> iter = myStack.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        for (Iterator<String> iter = myStack.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        myStack.clear();
        System.out.println(myStack);
    }
}
