import edu.princeton.cs.algs4.*;

// push和pop操作都在first端操作
// enqueue在last端操作
// Steque既可以当作栈使用也可以当作队列使用
class Steque<Item> {
    private class Node {
        Item item;
        Node next;
    };
    private Node first;
    private Node last;
    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        if (first==null) {
            assert(last==null);
            last = node;
        }
        else {}
        first = node;
        printList();
    }
    public Item pop() {
        assert(first!=null);
        Item tmp = first.item;
        if (first==last) {// 剩最后一个节点，需要设置last为null
            first = null;
            last = null;
        }
        else {
            first = first.next;
        }
        printList();
        return tmp;
    }
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (last==null) {// Steque当前无节点 node就是第一个节点
            assert(first==null);
            first = node;
        }
        else {
            last.next = node;
        }
        last = node;
        printList();
    }
    public boolean isEmpty() {
        return first==null;
    }
    public void printList() {
        Node current = first;
        if (current==null) {
            StdOut.println("there is nothing in list");
        }
        else {
            while (current != null) {
                StdOut.print(current.item);
                current = current.next;
                if (current != null) {
                    StdOut.print(", ");
                } else {
                }
            }
            StdOut.println();
        }
    }
}

public class exercise1332 {
    public static void main(String[] args) {
        Steque<String> s = new Steque<>();
        boolean bl = false;
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                s.pop();
            }
            else {
                //s.enqueue(str);
                if (bl) {
                    bl = false;
                    s.push(str);
                }
                else {
                    bl = true;
                    s.enqueue(str);
                }
            }
        }
    }
}