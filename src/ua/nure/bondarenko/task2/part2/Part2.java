package ua.nure.bondarenko.task2.part2;

import java.util.Iterator;

public class Part2 {
    private static ListImpl<String> stringList = new ListImpl<>();

    public static void main(String[] args) {
        stringList.addLast("a");
        stringList.addLast("b");
        stringList.addLast("c");
        stringList.addLast("d");
        stringList.addLast("e");
        stringList.addLast("f");
        stringList.addLast("g");
        stringList.addLast("h");

        System.out.println(stringList);
        for (Iterator<String> iter = stringList.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        stringList.removeFirst();
        System.out.println(stringList);
        stringList.removeLast();
        System.out.println(stringList);
        System.out.println(stringList.getFirst());
        System.out.println(stringList);
        System.out.println(stringList.getLast());
        System.out.println(stringList);
        System.out.println("Search element 'e'   " + stringList.search("e"));
        System.out.println("Search element 'eeee'   " + stringList.search("eeee"));
        System.out.println("Remove element 'e'  " + stringList.remove("e"));
        System.out.println("Remove element 'eeeee'  " + stringList.remove("eeeee"));
        System.out.println(stringList);
        stringList.clear();
        System.out.println(stringList);
    }
}
