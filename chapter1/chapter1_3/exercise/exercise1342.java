import edu.princeton.cs.algs4.*;
import java.util.*;

class Stack<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    private int m_size;
    public Stack() {}
    public Stack(Stack<Item> s) {
        Node current1 = s.first;        
        if (current1==null) {
            return;
        } else {}

        Node node = new Node();
        node.item = current1.item;
        this.first = node;

        Node current2 = node;
        while (current1.next != null) {
            current1 = current1.next;

            Node newnode = new Node();
            newnode.item = current1.item;
            current2.next = newnode;
            current2 = newnode;
        }
        this.m_size = s.m_size;
    }
    public void push(Item item) {
        Node newnode = new Node();
        newnode.item = item;
        newnode.next = first;
        first = newnode;
        m_size++;
    }
    public Item pop() {
        assert !isEmpty();
        Item ret = first.item;
        Node tmp = first;
        first = first.next;
        tmp.next = null;
        m_size--;
        return ret;
    }
    public boolean isEmpty() {
        return first==null;
    }
    public int size() {
        return m_size;
    }
    public void print() {
        if (first == null) {
            StdOut.println("there is nothing");
            return;
        } else {}
        
        Node current = first;
        while (current != null) {
            StdOut.print(current.item);
            current = current.next;
            if (current != null) {
                StdOut.print(", ");
            } else {}
        }
        StdOut.println();
    }
}

public class exercise1342 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                stack.pop();
            }
            else {
                stack.push(str);
            }
        }
        Stack<String> t = new Stack<>(stack);
        stack.pop();
        stack.pop();
        stack.push(Integer.toString(9));
        t.push(Integer.toString(10));
        t.push(Integer.toString(11));
        StdOut.println("s:");
        stack.print();
        StdOut.println("t:");
        t.print();
    }
}