package ua.nure.bondarenko.task2;

import ua.nure.bondarenko.task2.part1.Part1;
import ua.nure.bondarenko.task2.part2.Part2;
import ua.nure.bondarenko.task2.part3.Part3;
import ua.nure.bondarenko.task2.part4.Part4;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Demo   myArray");
        Part1.demo();
        System.out.println();
        System.out.println("Demo   myList");
        Part2.demo();
        System.out.println();
        System.out.println("Demo   myQueue");
        Part3.demo();
        System.out.println();
        System.out.println("Demo   myStack");
        Part4.demo();
    }

}
