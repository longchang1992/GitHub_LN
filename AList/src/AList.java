/*
index  0  1  2  3  4  5  6  7...;
items [5  6  2  1  3  7  0  0...];
size = 6;
invariant:
addLast:last integer to add is always items[size];
getLast: the item wa want to get is items[size-1];
size: size is always the number of items in the AList;
*/

public class AList {
    private int[] items;
    private int size;

    public AList() {
        items = new int[100];
        size = 0;
    }

    public void resize (int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0 , a, 0, size);
        items = a;
    }

    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    public int getLast() {

        return items[size-1];
    }

    public int get(int i) {
        return items[i];
    }

    public int getSize() {
        return size;
    }

    public int removeLast() {
        int returnItem = getLast();
        items[size-1] = 0; /*setting deleted item to zero does not hurt, but not necessary*/
        size = size - 1;
        return returnItem;
    }
}
