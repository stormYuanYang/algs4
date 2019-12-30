import java.lang.Iterable;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    private class ReverseListIterator implements Iterator<Item> {
        private Node node = first;
        public boolean hasNext() {
            return node != null;
        }
        public Item next() {
            Node tmp = node;
            node = node.next;
            return tmp.item;
        }
        public void remove() {
        }
    }
    public Stack() {
    }
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ReverseListIterator();
    }
}
