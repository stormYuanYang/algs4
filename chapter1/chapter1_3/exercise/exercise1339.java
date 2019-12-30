import edu.princeton.cs.algs4.*;
import java.util.*;

class RingBuffer<Item> {
    private Item[] m_array;
    private int m_head;
    private int m_tail;
    public RingBuffer(int capacity) {
        assert capacity > 0;
        m_array = (Item[]) new Object[capacity];
    }
    public void enqueue(Item item) {
        assert !isFull();
        m_array[m_tail] = item;
        if (m_tail+1==m_array.length) {// 环绕
            m_tail = 0;
        }
        else {
            m_tail++;
        }
    }
    public Item dequeue() {
        assert !isEmpty();
        Item ret = m_array[m_head];
        m_array[m_head] = null;
        if (m_head+1 == m_array.length) {
            m_head = 0;
        }
        else {
            m_head++;
        }
        return ret;
    }
    public boolean isEmpty() {
        return m_head == m_tail;
    }
    public boolean isFull() {
        if ((m_tail+1)%m_array.length == m_head) {
            return true;
        }
        else {
            return false;
        }
    }
    public void print() {
        if (m_head <= m_tail) {
            for (int i = m_head; i < m_tail; i++) {
                StdOut.print(m_array[i]);
                if (i < m_tail-1) {
                    StdOut.print("->");
                }
                else {}
            }
        }
        else {
            for (int i = m_head; i < m_array.length; i++) {
                StdOut.print(m_array[i]);
                if (i < m_array.length-1) {
                    StdOut.print("->");
                }
                else {}
            }
            for (int i = 0; i < m_tail; i++) {
                StdOut.print("->");
                StdOut.print(m_array[i]);
            }
        }
        StdOut.println();
        for (int i = 0; i < m_array.length; i++) {
            StdOut.print(m_array[i]);
            StdOut.print(", ");
        }
        StdOut.println();
        StdOut.println("-----------");
    }
}

public class exercise1339 {
    public static void main(String[] args) {
        RingBuffer<String> rb = new RingBuffer<>(4);
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                StdOut.println(String.format("deleted:%s", rb.dequeue()));
                rb.print();
            }
            else {
                rb.enqueue(str);
                rb.print();
            }
        }
    }
}