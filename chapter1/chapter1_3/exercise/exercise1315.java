import edu.princeton.cs.algs4.*;

class Queue<Item> {
    private Item[] m_queue;
    private int m_tail;
    public Queue() {
        m_queue = (Item[]) new Object[4];
    }
    private void resize(int newcap) {
        assert(newcap > 0);
        Item[] tmp = (Item[]) new Object[newcap];
        for (int i = 0; i < m_queue.length; i++) {
            tmp[i] = m_queue[i];
        }
        m_queue = tmp;
    }
    public boolean isFull() {
        return m_tail == m_queue.length;
    }
    public void enqueue(Item item) {
        if (isFull()) {
            // 不考虑溢出
            resize(m_queue.length*2);
        }
        else {
        }
        m_queue[m_tail++] = item;
    }
    public Item get(int k) {
        assert(k > 0 && k <= m_tail);
        return m_queue[m_tail-k];
    }
}

public class exercise1315 {
    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);
        Queue<String> queue = new Queue<>();        
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        StdOut.println(queue.get(k));
    }
}