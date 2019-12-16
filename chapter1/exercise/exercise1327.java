import edu.princeton.cs.algs4.*;
class List {
    private class Node {
        int item;
        Node next;
    }
    private Node first;
    public void add(int item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int max() {
        if (isEmpty()) {
            return 0;
        }
        else {
        }
        Node current = first;
        int max = current.item;
        while (current.next != null) {
            current = current.next;
            if (max < current.item) {
                max = current.item;
            }
            else {
            }
        }
        return max;
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
public class exercise1327 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            final int N = StdIn.readInt();
            List list = new List();
            for (int i = 0; i < N; i++) {
                list.add(StdIn.readInt());
            }
            list.printList();
            StdOut.println(String.format("max:%s", list.max()));
        }
    }
}