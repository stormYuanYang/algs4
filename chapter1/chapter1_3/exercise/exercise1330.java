import edu.princeton.cs.algs4.*;

class List<Item> {
    private class Node  {
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
    public void reverse() {
        if (first == null) {
            return;
        } 
        // 只有一个节点时，无须翻转
        else if (first.next == null) {
            return;
        }
        else {
            Node prev = null;
            Node mid = first;
            Node next = first.next;
            while (next != null) {
                mid.next = prev;// 改变链表方向
                // 继续移动指针
                prev = mid;
                mid = next;
                next = next.next;
            }// while循环结束时 prev指向倒数第二个节点，mid指向最后一个节点
            // 让最后一个节点连接到倒数二个节点上
            mid.next = prev;
            first = mid;
        }
    }
    public void printList() {
        Node current = first;
        while (current != null) {
            StdOut.print(current.item);
            current = current.next;
            if (current != null) {
                StdOut.print("->");
            }
            else {
            }
        }
        StdOut.println("\n--------------");
    }
}

public class exercise1330 {
    public static void main(String[] args) {
        List<String> list = new List<>();
        while (! StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("reverse")) {
                list.reverse();
                list.printList();
            }
            else {
                list.add(str);
                list.printList();
            }
        }
    }
}