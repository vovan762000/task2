package ua.nure.bondarenko.task2.part2;

import java.util.Iterator;

public class Part2 {
    private static ListImpl<String> myList = new ListImpl<>();

    public static void demo() {
        myList.addLast("a");
        myList.addLast("b");
        myList.addLast("c");
        myList.addLast("d");
        myList.addLast("e");
        myList.addLast("f");
        myList.addLast("g");
        myList.addLast("h");

        System.out.println(myList);
        for (Iterator<String> iter = myList.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println("Remove first element");
        myList.removeFirst();
        System.out.println(myList);
        System.out.println("Remove last element");
        myList.removeLast();
        System.out.println(myList);
        System.out.println("Get first element");
        System.out.println(myList.getFirst());
        System.out.println(myList);
        System.out.println("Get last element");
        System.out.println(myList.getLast());
        System.out.println(myList);
        System.out.println("Search element 'e'   " + myList.search("e"));
        System.out.println("Search element 'eeee'   " + myList.search("eeee"));
        System.out.println("Remove element 'e'  " + myList.remove("e"));
        System.out.println("Remove element 'eeeee'  " + myList.remove("eeeee"));
        System.out.println(myList);
        System.out.println("Clear myList");
        myList.clear();
        System.out.println(myList);
    }

    public static void main(String[] args) {
        demo();
    }
}
