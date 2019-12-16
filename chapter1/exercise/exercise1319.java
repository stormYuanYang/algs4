import edu.princeton.cs.algs4.*;

class List<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    public List() {
    }
    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        printList();
    }
    public boolean isEmpty() {
        return first == null;
    }
    public Item delete() {
        Node node = first;
        if (node.next == null) {
            Item item = node.item;
            first = null;
            printList();
            return item;
        }
        else {
            while (node.next.next != null) {
                node = node.next;
            }
            Item item = node.next.item;
            node.next = null;
            printList();
            return item;
        }
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

public class exercise1319 {
    public static void main(String[] args) {
        List<String> list = new List<>();        
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                assert(!list.isEmpty());
                list.delete();
            }
            else {
                list.add(str);
            }
        }
    }
}