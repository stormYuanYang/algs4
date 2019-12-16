import edu.princeton.cs.algs4.*;

class CircularQueue<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    public CircularQueue() {
    }
    public void enqueue(Item item) {
        Node newnode = new Node();
        newnode.item = item;
        // 新增节点后必须要调整last的位置
        if (last == null) {
            // last等于null时，first也必须是null
            assert(first==null);
            first = newnode;
            last = newnode;
        }
        else {
            last.next = newnode;
            last = newnode;
        }
        // 最后让last节点连接到first节点
        last.next = first;
        StdOut.println("function enqueue:");
        printList();
    }
    public boolean isEmpty() {
        return first == null;
    }
    public Item dequeue() {
        assert(first!=null && last!=null);
        Item item = first.item;
        // 当只有一个节点时，必须单独判断一下
        // 否则时不能正确移除节点的
        if (first == last) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
            last.next = first;
        }
        StdOut.println("function dequeue:");
        printList();
        return item;
    }
    public void printList() {
        if (first==null) {
            return;
        }
        StdOut.print(first.item);
        Node node = first.next;
        while (node != first) {
            StdOut.print("<-");
            StdOut.print(node.item);
            node = node.next;
        }
        StdOut.println("\n----------");
    }
} 

public class exercise1329 {
    public static void main(String[] args) {
        CircularQueue<String> cq = new CircularQueue<>();
        while (! StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.equals("-")) {
                cq.dequeue();
            }
            else {
                cq.enqueue(word);
            }
        }
    }
}