import edu.princeton.cs.algs4.*;
import java.util.*;

// 可以用数学方法更加高效地解决Josephus问题
class Queue<Item> {
    private class Node {
        public Node next;
        public Item item;
    }
    private Node last;
    private int size;
    public Queue() {
    }
    public boolean isEmpty() {
        return size==0;
    }
    public void add(Item item) {
        Node newnode = new Node();
        newnode.item = item;
        if (last != null) {
            newnode.next = last.next;
            last.next = newnode;
        }
        else {
            newnode.next = newnode;
        }
        last = newnode;
        print();
        size++;
    }
    public void print() {
        if (last == null) {
            return;
        }
        else {}
        Node current = last.next;
        StdOut.print(current.item);
        current = current.next;
        while (current != last.next) {
            StdOut.print(", ");
            StdOut.print(current.item);
            current = current.next;
        }
        StdOut.println();
    }
    public Item delete(int M) {
        assert size>0;
        assert last!=null;
        int step = (M-1)%size;
        Node prev = last;
        Node killed = last.next;
        for (int i = 0; i < step; i++) {
            prev = killed;
            killed = killed.next;
        }
        Item item = killed.item;
        if (last == last.next) {
            last = null;
        }
        else {
            prev.next = killed.next;
            killed.next = null;
            last = prev;
        }
        size--;
        return item;
    }
}

public class exercise1337 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int N = StdIn.readInt();
            int M = StdIn.readInt();
            StdOut.println(N);
            Queue<Integer> q = new Queue<Integer>();
            for (int i = 0; i < N; i++) {
                q.add(i);
            }
            while (!q.isEmpty()) {
                int killed = q.delete(M);
                StdOut.print(killed);
                StdOut.print(" ");
            }
            StdOut.println();
        }
    }
}