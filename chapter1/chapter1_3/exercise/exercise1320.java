import edu.princeton.cs.algs4.*;

class List<Item> {
    private class Node {
        Item item;
        Node next;
    }    
    private Node first;
    private int size;
    public List() {
    }
    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size++;
        printList();
    }
    public void delete(int k) {
        assert(k > 0);
        if (k <= size) {
            // List的实现没有采用哨兵节点 所以需要对头节点的处理做一下判断
            if (k==1) {
                first = first.next;
            }
            else {
                Node node = first;
                for (int i = 1; i <= k - 2; i++) {
                    node = node.next;
                }
                node.next = node.next.next;
            }
            printList();
        }
        else {
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

public class exercise1320 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            final int N = StdIn.readInt();
            final int K = StdIn.readInt();
            List<Integer> list = new List<>();
            for (int i = 0; i < N; i++) {
                list.add(StdIn.readInt());
            }
            for (int i = 0; i < K; i++) {
                int k = StdIn.readInt();
                list.delete(k);
            }
        }
    }
}