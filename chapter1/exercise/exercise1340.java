import edu.princeton.cs.algs4.*;
import java.util.*;

class List<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node guard = new Node();
    public List() {
    }
    private void add(Item item) {
        Node node = new Node();
        node.item = item;

        node.next = guard.next;
        guard.next = node;
    }
    public void moveToFront(Item item) {
        Node prev = guard;
        Node current = guard.next;
        while (current != null) {
            if (current.item.equals(item)) {
                break;
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        if (current != null) {
            prev.next = current.next;            
            current.next = guard.next;
            guard.next = current;
        }
        else {
            add(item);
        }
    }
    public void print() {
        Node node = guard.next;
        while (node != null) {
            StdOut.print(node.item);
            //StdOut.print(", ");
            node = node.next;
        }
        StdOut.println();
    }
} 

public class exercise1340 {
    public static void main(String[] args) {
        int n = 0;
        while (!StdIn.isEmpty()) {
            StdOut.println(String.format("# case:%d", ++n));
            String str = StdIn.readString();
            List<Character> list = new List<>();
            for (int i = 0; i < str.length(); i++) {
                list.moveToFront(str.charAt(i));
                list.print();
            }
        }
    }
}