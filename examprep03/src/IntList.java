public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public void addLast (int i) {
        IntList p = this;
        while (p.rest != null) {
            p = p.rest;
        }
        p.rest = new IntList(i, null);
    }

    public String toString() {
        if (rest == null) {
            // Converts an Integer to a String!
            return String.valueOf(first);
        } else {
            return first + " -> " + rest.toString();
        }
    }

    public static void evenOdd(IntList lst) {
        if (lst == null || lst.rest == null) {
            return;
        }
        IntList p = lst.rest;
        IntList q = lst.rest;
        while(lst.rest != null && lst.rest.rest != null) {
            lst.rest = lst.rest.rest;
            lst = lst.rest;
            p.rest = p.rest.rest;
            p = p.rest;
        }
        lst.rest = q;
    }

    public static void main (String[] args) {
        IntList lst = new IntList(0, null);
        lst.addLast(1);
        System.out.println(lst.toString());
        evenOdd(lst);
        System.out.println(lst.toString());
    }
}
