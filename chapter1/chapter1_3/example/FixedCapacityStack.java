import java.util.Iterator;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {
            return i>0;
        }
        public Item next() {
            return a[--i];
        }
        public void remove() {
        }
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i<N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }
    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        else {
        }
        a[N++] = item;
    }
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N>0 && N==a.length/4) {
            resize(a.length/2);
        }
        else {
        }
        return item;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }
}