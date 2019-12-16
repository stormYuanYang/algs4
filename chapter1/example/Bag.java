import java.lang.Iterable;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    private class BagIterator implements Iterator<Item> {
        private Node node = first;
        public boolean hasNext() {
            return node != null;
        }
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
    }
    public Bag() {
    }
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }
    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }
}
