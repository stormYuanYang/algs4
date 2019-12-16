import java.util.Iterator;
import java.lang.Iterable;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    private class QueueIterator implements Iterator<Item>{
        private Node node = first;
        public boolean hasNext() {
            return node != null;
        }
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
        public void remove() {
        }
    }
    public Queue() {
    }

    public void enqueue(final Item item) {
        final Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        else {
        }
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
        return new QueueIterator();
    }
}