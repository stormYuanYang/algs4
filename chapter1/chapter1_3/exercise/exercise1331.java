import edu.princeton.cs.algs4.*;

class List<Item> {
    public class DoubleNode {
        Item item;
        DoubleNode prev;
        DoubleNode next;
    };
    public DoubleNode first;
    public DoubleNode last;
    public List() {
    }
    public void add2head(Item item) {
        assert(item!=null);
        DoubleNode node = new DoubleNode();
        node.item = item; 
        if (first == null) {
            assert(last==null);
            last = node;
        }
        else {
            node.next = first;
            first.prev = node;
        }
        first = node;
        printList();
    }
    public void add2tail(Item item) {
        assert(item!=null);
        DoubleNode node = new DoubleNode();
        node.item = item; 
        if (last == null) {
            assert(first==null);
            first = node;
        }
        else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        printList();
    }
    public boolean isEmpty() {
        return first == null;
    }
    public Item deleteHead() {
        assert(first!=null);
        Item item = first.item;
        first = first.next;
        if (first==null) {
            last = null;
        }
        else {
        }
        printList();
        return item;
    }
    public Item deleteTail() {
        assert(last!=null);
        Item item = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        }
        else {
            last.next = null;
        }
        printList();
        return item;
    }
    public void insertFront(DoubleNode node, Item item) {
        assert(node!=null);
        assert(item!=null);
        DoubleNode newnode = new DoubleNode();
        newnode.item = item;

        newnode.prev = node.prev;
        newnode.next = node;

        if (node==first) {
            first = newnode;
        }
        else {
            node.prev.next = newnode;
        }
        node.prev = newnode;
        printList();
    }
    public void insertAfter(DoubleNode node, Item item) {
        assert(node!=null);
        assert(item!=null);
        DoubleNode newnode = new DoubleNode();
        newnode.item = item;

        newnode.prev = node;
        newnode.next = node.next;
        if (node==last) {
            last = newnode;
        }
        else {
            node.next.prev = newnode;
        }
        node.next = newnode;
        printList();
    }
    public void delete(DoubleNode node) {
        assert(node!=null);
        if (node.prev!=null && node.next!=null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            StdOut.println(first.item);
        }
        else {
            if (node.prev == null) {
                assert(node==first);
                if (node.next != null) {
                    node.next.prev = null;
                }
                else {}
                first = node.next;
            }
            else {
            }

            if (node.next == null) {
                assert(node==last);
                if (node.prev != null) {
                    node.prev.next = null;
                }
                else {}
                last = node.prev;
            }
            else {
            }
        }
        node.prev = null;
        node.next = null;
        printList();
    }
    public void printList() {
        DoubleNode current = first;
        if (current==null) {
            StdOut.println("there is nothing in list");
        }
        else {
            while (current != null) {
                StdOut.print(current.item);
                current = current.next;
                if (current != null) {
                    StdOut.print("<-->");
                } else {
                }
            }
            StdOut.println();
        }
    }
}

public class exercise1331 {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        int size = 0;
        while (! StdIn.isEmpty()) {
            int item = StdIn.readInt();
            list.add2tail(item);
            size++;
        }
        StdOut.println("--------------");
        list.insertAfter(list.last, -1);
        list.insertAfter(list.last, -2);
        list.insertAfter(list.last.prev.prev.prev, -1);
        list.insertAfter(list.first, -1);

        StdOut.println("--------------");
        list.delete(list.first);
        list.delete(list.first);
        list.delete(list.first);
        list.delete(list.last);
        list.delete(list.last);
        list.delete(list.last);
        list.delete(list.first);
        list.delete(list.last);
    }
}