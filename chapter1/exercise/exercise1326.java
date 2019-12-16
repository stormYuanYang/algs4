import edu.princeton.cs.algs4.*;
class List<Item> {
    private class Node {
        Item item;
        Node next;
    }
    private Node first;
    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }
    public boolean isEmpty() {
        return first == null;
    }
    // 如果用额外的一个哨兵节点，这个方法可以写得更加美观
    // 采用哨兵节点，就不用单独判断首节点
    public void remove(Item item) {
        if (isEmpty()) {
            return;
        }
        else { }
        Node current = first;  
        while (current.next != null) {
            if (current.next.item.equals(item)) {
                current.next = current.next.next;
            }
            else { 
                current = current.next;
            }
        }
        // 最后才判断第一个节点是否是需要移除的节点（这样写，代码更清晰）
        if (first.item.equals(item)) {
            first = first.next;
        }
        else {
        }
        printList();
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
public class exercise1326 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            final int N = StdIn.readInt();
            List<String> list = new List<>();
            for (int i = 0; i < N; i++) {
                list.add(StdIn.readString());
            }
            list.printList();
            while (!StdIn.isEmpty()) {
                String key = StdIn.readString();
                StdOut.println(String.format("key:%s", key));
                list.remove(key);
            }
        }
    }
}