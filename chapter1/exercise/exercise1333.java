import edu.princeton.cs.algs4.*;

class Deque<Item> {
    private class Node {
        Item item;
        Node prev;
        Node next;
    }
    private Node left;
    private Node right; 
    private int size;
    public Deque() {
    }
    public boolean isEmpty() {
        return left == null;
    }
    public int size() {
        return size;
    }
    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        if (left!=null) {
            node.next = left;
            left.prev = node;
            left = node;
        }
        else {// Deque中无节点 node就是第一个节点
            assert(right==null);
            left = node;
            right = node;
        }
        size++;
        printDeque();
    }
    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        if (right!=null) {
            node.prev = right;
            right.next = node;
            right = node;
        }
        else {
            assert(left==null);
            left = node;
            right = node;
        }
        size++;
        printDeque();
    }
    public Item popLeft() {
        assert(!isEmpty());
        Item tmp = left.item;
        Node newLeft = left.next;
        left.next = null;
        if (newLeft!=null) {
            newLeft.prev = null;
            left = newLeft;
        }
        else {// Deque空了
            left = null;
            right = null;
        }
        size--;
        printDeque();
        return tmp;
    }
    public Item popRight() {
        assert(!isEmpty());
        Item tmp = right.item;
        Node newRight = right.prev;
        right.prev = null;
        if (newRight!=null) {
            newRight.next = null;
            right = newRight;
        }
        else {//Deque 空了
            left = null;
            right = null;
        }
        size--;
        printDeque();
        return tmp;
    }
    public void printDeque() {
        Node current = left;
        if (current == null) {
            StdOut.println("now, Deque is empty");
        }
        else {
            while (current != null) {
                StdOut.print(current.item);
                current = current.next;
                if (current != null) {
                    StdOut.print("<->");
                }
            }
            StdOut.println(String.format("    size:%d", size));
        }
    }
}

public class exercise1333 {
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            deque.pushLeft(str);    
            deque.pushRight(str);    
        }
        while (!deque.isEmpty()) {
            deque.popRight();
        }
    }
}