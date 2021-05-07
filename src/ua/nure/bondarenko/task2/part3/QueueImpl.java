package ua.nure.bondarenko.task2.part3;

import java.util.Iterator;
import java.util.Objects;

public class QueueImpl<E> implements Queue<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    @Override
    public void enqueue(E element) {
        Node ob = new Node();
        ob.setObject(element);
        if (head == null) {
            head = ob;
        } else {
            tail.setNext(ob);
        }
        tail = ob;
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            return null;
        }
        E element = head.getObject();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return element;
    }

    @Override
    public E top() {
        return Objects.isNull(size) ? null : head.getObject();
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x.element = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }

    private static class Node<E> {
        private E element;

        private Node next;

        public E getObject() {
            return element;
        }

        public void setObject(E element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private class IteratorImpl implements Iterator<E> {
        private Node<E> firstEl = head;
        private int nextIndex;

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (firstEl != null) {
                E element = firstEl.element;
                firstEl = firstEl.next;
                nextIndex++;
                return element;
            }
            return null;
        }

        public void remove() {
            if (hasNext()) {
                dequeue();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        String del = "";
        Node<E> tmpFirst = head;
        if (tmpFirst != null) {
            do {
                text.append(del).append(tmpFirst.element);
                tmpFirst = tmpFirst.next;
                del = ", ";
            } while (tmpFirst != null);
        }
        text.append(']');
        return text.toString();
    }
}
