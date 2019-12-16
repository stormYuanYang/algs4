import edu.princeton.cs.algs4.*;
class List<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        printList();
    }
    public Node find(String key) {
        Node node = first;
        while (node != null) {
            if (node.item.equals(key)) {
                return node;
            }
            else {
            }
            node = node.next;
        }
        return null;
    }
    public Item removeAfter(Node current) {
        if (current == null) {
            return null;
        }
        if (current.next == null) {
            return null;
        }
        Item item = current.next.item;
        current.next = current.next.next; 
        printList();
        return item;
    }
    public void printList() {
        Node node = first;
        while (node != null) {
            StdOut.print(node.item);
            node = node.next;
            if (node != null) {
                StdOut.print("->");
            }
        }
        StdOut.println("\n----------");
    }
}
public class exercise1324 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            final int N = StdIn.readInt();
            final int K = StdIn.readInt();
            List<String> list = new List<>();
            for (int i = 0; i < N; i++) {
                list.add(StdIn.readString());
            }
            for (int i = 0; i < K; i++) {
                String key = StdIn.readString();
                list.removeAfter(list.find(key));
            }
        }
    }
}