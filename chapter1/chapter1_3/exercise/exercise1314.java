import edu.princeton.cs.algs4.*;

// 题目只要求实现字符串的队列 这里用模板实现
class ResizingArrayQueue<Item> {
    private static final int DEFAULT_CAPACITY = 6;
    private Item[] m_queue;
    private int m_head;
    private int m_tail;
    public ResizingArrayQueue() {
        m_queue = (Item[]) new Object[DEFAULT_CAPACITY];
        printQueue();
    }
    public ResizingArrayQueue(int cap) {
        assert(cap > 0);
        if (cap < DEFAULT_CAPACITY) {
            cap = DEFAULT_CAPACITY;
        }
        else {
        }
        m_queue = (Item[]) new Object[cap];
        printQueue();
    }
    private void resize(int newcap) {
        assert(newcap > 0);
        //if (newcap < DEFAULT_CAPACITY) {
        //    newcap = DEFAULT_CAPACITY;
        //}
        Item[] tmp = (Item[]) new Object[newcap];
        // 注意这里一定要用<=,不能用<
        // 当m_head等于m_tail时，表示整个队列为空
        StdOut.println(String.format("------ function resize ------\noldcap:%d,newcap:%d", m_queue.length, tmp.length));
        StdOut.println("old queue:");
        printQueue();
        if (m_head <= m_tail) {
            for (int i = m_head, j = 0; i < m_tail; i++, j++) {
                tmp[j] = m_queue[i];
            }
        }
        // 数据环绕之后，就在原数组的两端
        else {
            int j = 0;
            for (int i = m_head; i < m_queue.length; i++, j++) {
                tmp[j] = m_queue[i];
            }
            for (int i = 0; i < m_tail; i++, j++) {
                tmp[j] = m_queue[i];
            }
        }
        int size = size();
        m_queue = tmp;
        m_head = 0;
        m_tail = size;
        StdOut.println("new queue:");
        printQueue();
        StdOut.println("------ function resize end ------");
    }
    private void printQueue() {
        StdOut.println(String.format("cap:%d,m_head:%d,m_tail:%d", m_queue.length, m_head, m_tail));
        for (int i = 0; i < m_queue.length; i++) {
            if (m_queue[i] == null) {
                StdOut.print("null");
            }
            else {
                StdOut.print(m_queue[i]);
            }
            StdOut.print(", ");
        }
        StdOut.println();
    }
    public void enqueue(Item item) {
        if (isFull()) {
            resize(m_queue.length*2);
        }
        else {
        }
        m_queue[m_tail++] = item;
        // 环绕
        if (m_tail == m_queue.length) {
            m_tail = 0;
        }
        else {
        }
        StdOut.println("enqueue:");
        printQueue();
    }
    public int size() {
        // <= 不能用 <
        if (m_head <= m_tail) {
            return m_tail - m_head;
        }
        // 环绕之后队列中的数据就分布在数组的两端
        else {
            return m_queue.length - (m_head - m_tail);
        }
    }
    public Item dequeue() {
        if (size() <= m_queue.length/4) {
            resize(m_queue.length/2);
        }
        else {
        }
        Item item = m_queue[m_head];
        m_queue[m_head] = null;
        m_head++;
        if (m_head == m_queue.length) {
            m_head = 0;
        }
        else {
        }
        StdOut.println("dequeue:");
        printQueue();
        return item;
    }
    public boolean isFull() {
        if ((m_tail+1) % m_queue.length == m_head) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isEmpty() {
        return m_head == m_tail;
    }
}

public class exercise1314 {
    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                assert(!queue.isEmpty());
                queue.dequeue();
            }
            else {
                queue.enqueue(str);
            }
        }
    }
}