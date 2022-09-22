package deque;

import jh61b.junit.In;

public class LinkedListDeque<T> {
    public class IntNode {
        public T item;
        public IntNode prev;
        public IntNode next;
        public IntNode (IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public IntNode sentinel;
    public int size = 0;

    public  LinkedListDeque() {
        T xxx = null;
        sentinel = new IntNode(null, xxx, null);
        size = 0;
    }

    public LinkedListDeque (T item) {
        T xxx = null;
        sentinel = new IntNode(null, xxx, null);
        sentinel.next = new IntNode(sentinel, item, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst (T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new IntNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }
        else {
            T first_item = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first_item;
        }
    }

    public T removeLast() {
        if (sentinel.next == null) {
            return null;
        }
        else {
            T last_item = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return last_item;
        }
    }

    // returns true if deque is empty, and false otherwise/
    public boolean isEmpty() {
        if (sentinel.next == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (sentinel.next == null) {
            System.out.println("Deque is empty!");
        }
        else {
            IntNode deque = sentinel.next;
            for (int i = 0; i < size; i += 1) {
                System.out.print(deque.item + " ");
                deque = deque.next;
            }
            System.out.print("\n");
        }
    }

    public T get(int index) {
        if (sentinel.next == null) {
            return null;
        }
        else {
            IntNode deque = sentinel;
            for (int i = 0; i <= index; i += 1) {
                deque = deque.next;
            }
            return deque.item;
        }
    }

    // private recursive helper method for getRecursive(int index). DLList itself is not recursive./
    private T getRecursive_god(IntNode p, int i) {
        if (i == 0) {
            return p.item;
        }
        else {
            return getRecursive_god(p.next, i - 1);
        }
    }

    public T getRecursive(int index) {
        if (sentinel.next == null) {
            return null;
        }
        else {
            return getRecursive_god(sentinel.next, index);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque) {
            if (comparison(this, (LinkedListDeque) o)) {
                return true;
            }
        }
        return false;
    }

    // helper method for equals(Object o) /
    public boolean comparison(LinkedListDeque a, LinkedListDeque b) {
        IntNode a_temp = a.sentinel;
        IntNode b_temp = b.sentinel;
        while (a_temp.next != null || a_temp.item != null) {
            if (a_temp.item != b_temp.item) {
                return false;
            }
            a_temp = a_temp.next;
            b_temp = b_temp.next;
        }
        return true;
    }


}
