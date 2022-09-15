public class SLList {
    private class IntNode {
        public int item;
        public IntNode rest;
        public IntNode (int i, IntNode n) {
            item = i;
            rest = n;
        }
    }
    public IntNode first;
    public SLList (int x) {

        first = new IntNode (x, null);
    }

    public void addFirst (int x) {

        first = new IntNode (x, first);
    }

    public int getFirst () {

        return first.item;
    }

    private static int recursiveSize(IntNode p) {
        if (p.rest == null) {
            return 1;
        }
        return 1 + recursiveSize(p.rest);
    }

    public int recursiveSize() {
        return recursiveSize(first);
    }

    private static int iterativeSize(IntNode p) {
        int i = 1;
        while (p.rest != null) {
            i += 1;
            p = p.rest;
        }
        return i;
    }

    public int iterativeSize() {
        return iterativeSize(first);
    }

    public void addLast(int x) {
        IntNode temp = first;
        while (temp.rest != null) {
            temp = temp.rest;
        }
        temp.rest = new IntNode(x, null);
    }

    public int getLast() {
        IntNode temp = first;
        while (temp.rest != null) {
            temp = temp.rest;
        }
        return temp.item;
    }

    public static void main (String[] args) {
        SLList L = new SLList (15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(1);
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
        System.out.println(L.recursiveSize());
        System.out.println(L.iterativeSize());
    }
}
