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
    public boolean find(String key) {
        Node node = first;
        while (node != null) {
            if (node.item.equals(key)) {
                return true;
            }
            else {
            }
            node = node.next;
        }
        return false;
    }
}
public class exercise1321 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            final int N = StdIn.readInt();
            final int K = StdIn.readInt();
            List<String> list = new List<>();
            for (int i = 0; i < N; i++) {
                list.add(StdIn.readString());
            }
            for (int i = 0; i < K; i++) {
                String key = StdIn.readString();
                boolean finded = list.find(key);
                if (finded) {
                    StdOut.println(String.format("%s finded", key));
                }
                else {
                    StdOut.println(String.format("%s not finded", key));
                }
            }
        }
    }
}