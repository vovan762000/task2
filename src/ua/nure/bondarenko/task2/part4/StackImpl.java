package ua.nure.bondarenko.task2.part4;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.Objects;

public class StackImpl<E> implements Stack<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    @Override
    public void push(E element) {
        Node ob = new Node();
        ob.setObject(element);
        if (tail == null) {
            tail = ob;
        } else {
            head.setPrev(ob);
        }
        head = ob;
        size++;
    }

    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        E element = head.getObject();
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return element;
        }
        Node<E> tmpHead = tail;
        while (head != tmpHead.prev) {
            tmpHead = tmpHead.prev;
        }
        tmpHead.prev = null;
        head = tmpHead;
        size--;
        return element;
    }

    @Override
    public E top() {
        return Objects.isNull(size) ? null : head.getObject();
    }

    @Override
    public void clear() {
        for (Node<E> x = tail; x != null; ) {
            Node<E> next = x.prev;
            x.element = null;
            x.prev = null;
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
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {
        private Node<E> lasttEl = tail;
        private Node<E> firstEl = head;
        private int nextIndex;

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            lasttEl = tail;
            if (lasttEl != null) {
                E element = firstEl.element;
                while (firstEl != lasttEl.prev) {
                    if(lasttEl.prev!=null){
                        lasttEl = lasttEl.prev;
                    }else {
                        nextIndex++;
                        return firstEl.element;
                    }
                }
                firstEl=lasttEl;
                nextIndex++;
                return element;
            }
            return null;
        }

        public void remove() {
            try {
                throw new OperationNotSupportedException();
            } catch (OperationNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Node<E> {
        private E element;

        private Node<E> prev;

        public E getObject() {
            return element;
        }

        public void setObject(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        String del = "";
        Node<E> tmpLast = tail;
        if (tmpLast != null) {
            do {
                text.append(del).append(tmpLast.element);
                tmpLast = tmpLast.prev;
                del = ", ";
            } while (tmpLast != null);
        }
        text.append(']');
        return text.toString();
    }
}
