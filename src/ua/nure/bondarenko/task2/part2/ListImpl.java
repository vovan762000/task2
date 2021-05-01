package ua.nure.bondarenko.task2.part2;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListImpl<E> implements List<E> {

    private int size = 0;

    private Node<E> first;

    private Node<E> last;

    @Override
    public void addFirst(E element) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }


    @Override
    public void addLast(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        unlinkFirst(f);
    }

    @Override
    public void removeLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        unlinkLast(l);
    }

    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        E element = f.item;
        remove(f.item);
        return element;
    }

    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        E element = l.item;
        remove(l.item);
        return element;
    }

    @Override
    public E search(E element) {
        for (Iterator<E> iter = iterator(); iter.hasNext(); ) {
            E item = iter.next();
            if (element.equals(item)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (element.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (ListImpl.Node<E> x = first; x != null; ) {
            ListImpl.Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
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
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private E unlinkFirst(ListImpl.Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private E unlinkLast(ListImpl.Node<E> l) {
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private E unlink(ListImpl.Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private class IteratorImpl implements Iterator<E> {
        private Node<E> firstEl = first;
        private int nextIndex;

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (firstEl != null) {
                E element = firstEl.item;
                firstEl = firstEl.next;
                nextIndex++;
                return element;
            }
            return null;
        }

        public void remove() {
          if (hasNext()){
              ListImpl.this.remove(next());
          }
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        String del = "";
        Node<E> tmpFirst = first;
        if (tmpFirst != null) {
            do {
                text.append(del).append(tmpFirst.item);
                tmpFirst = tmpFirst.next;
                del = ", ";
            } while (tmpFirst != null);
        }
        text.append(']');
        return text.toString();
    }
}
