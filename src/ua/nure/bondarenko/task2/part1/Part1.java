package ua.nure.bondarenko.task2.part1;

import java.util.Iterator;

public class Part1 {
    private static Array<Integer> integerArray = new ArrayImpl<>();

    public static void demo() {
        integerArray.add(1);
        integerArray.add(2);
        integerArray.add(3);
        integerArray.add(4);
        System.out.println(integerArray);
        System.out.println("Size = " + integerArray.size());
        integerArray.remove(3);
        System.out.println("After remove index 3");
        System.out.println(integerArray);
        for (Iterator<Integer> iter = integerArray.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        System.out.println("Get element with index 2");
        System.out.println(integerArray.get(2));
        System.out.println("Get index of element 1 ");
        System.out.println(integerArray.indexOf(1));
        integerArray.clear();
        System.out.println(integerArray);
    }

    public static void main(String[] args) {
        demo();
    }
}
