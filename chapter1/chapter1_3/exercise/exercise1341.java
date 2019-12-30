import edu.princeton.cs.algs4.*;
import java.util.*;

class Queue<Item> {
    private static int DEFAULT_CAPACITY = 4;
    private Item[] m_array;
    private int m_head;
    private int m_tail;
    private int m_size;
    public Queue() {
        m_array = (Item[]) new Object[DEFAULT_CAPACITY];
    }
    public Queue(Queue<Item> q) {
        m_array = (Item[]) new Object[q.m_array.length];
        if (q.m_head <= q.m_tail) {
            for (int i = q.m_head, j = 0; i < q.m_tail; i++, j++) {
                m_array[j] = q.m_array[i];
            }
        }
        else {
            int j = 0;
            for (int i = q.m_head; i < q.m_array.length; i++, j++) {
                m_array[j] = q.m_array[i];
            }
            for (int i = 0; i < q.m_tail; i++, j++) {
                m_array[j] = q.m_array[i];
            }
        }
        m_head = 0;
        m_tail = q.m_size;
        m_size = q.m_size;
    }
    private void resize(int newcap) {
        assert newcap >= 0;
        if (newcap <= DEFAULT_CAPACITY) {
            return;
            //newcap = DEFAULT_CAPACITY;
        }
        else {}

        Item[] tmp = (Item[]) new Object[newcap];
        if (m_head <= m_tail) {
            for (int i = m_head, j = 0; i < m_tail; i++, j++) {
                tmp[j] = m_array[i];
            }
        }
        else {// 队列环绕就需要拷贝两段数据
            int j = 0;
            for (int i = m_head; i < m_array.length; i++, j++) {
                tmp[j] = m_array[i];
            }
            for (int i = 0; i < m_tail; i++, j++) {
                tmp[j] = m_array[i];
            }
        }
        m_array = tmp;
        m_head = 0;
        m_tail = m_size;
    }
    private int size() {
        return m_size;
    }
    public boolean isEmpty() {
        return m_head==m_tail;
    }
    private void checkIncreaseCapcity() {
        if (m_size+1==m_array.length) {
            int newcap;
            if (m_array.length > Integer.MAX_VALUE/2) {
                assert m_array.length < Integer.MAX_VALUE;
                newcap = Integer.MAX_VALUE;
            }
            else {
                newcap = m_array.length*2;
            }
            resize(newcap);
        }
        else {}
    }
    public void enqueue(Item item) {
        checkIncreaseCapcity();
        m_array[m_tail] = item;
        if (m_tail+1 == m_array.length) {
            m_tail = 0;
        }
        else {
            m_tail++;
        }
        m_size++;
    }
    private void checkDecreaseCapcity() {
        if (m_size <= m_array.length/4) {
            resize(m_size*2);
        }
        else {}
    }
    public Item dequeue() {
        Item ret = m_array[m_head];
        m_array[m_head] = null;// 不再持有其引用
        if (m_head+1 == m_array.length) {
            m_head = 0;
        }
        else {
            m_head++;
        }
        m_size--;
        checkDecreaseCapcity();
        return ret;
    }
    public void print() {
        for (int i = 0; i < m_array.length; i++) {
            if (m_array[i] == null) {
                StdOut.print("nil");
            }
            else {
                StdOut.print(m_array[i]);
            }
            if (i < m_array.length-1) {
                StdOut.print(", ");
            }
            else {}
        }
        StdOut.println(String.format("\tsize:%d capcity:%d", m_size, m_array.length));
    }
}

public class exercise1341 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                q.dequeue();
            }
            else {
                q.enqueue(str);
            }
            q.print();
        }
        StdOut.println("------------");
        Queue<String> r = new Queue<>(q);
        while (!q.isEmpty()) {
            r.enqueue(q.dequeue());
        }
        StdOut.println("q:");
        q.print();
        StdOut.println("r:");
        r.print();
    }
}