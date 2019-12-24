import edu.princeton.cs.algs4.*;
import java.util.*;

// 题目中提到第3章中的算法和数据结构可以保证insert()和delete()
// 的运行时间和队列中的元素数量成对数关系
// 应该采用的就是树结构
// 这里还是按一般结构实现GeneralizedQueue
class GeneralizedQueue<Item> {
    private static int DEFAULT_CAPCITY = 8;
    private Item[] m_array;
    private int m_size;
    public GeneralizedQueue() {
        m_array = (Item[]) new Object[DEFAULT_CAPCITY];
    }
    public boolean isEmpty() {
        return m_size==0;
    }
    private void resize(int newcap) {
        if (newcap < DEFAULT_CAPCITY) {
            newcap = DEFAULT_CAPCITY;
        }
        else {}
        Item[] tmp = (Item[]) new Object[newcap];
        for (int i = 0; i < m_size; i++) {
            tmp[i] = m_array[i];
        }
        m_array = tmp;
    }
    public void insert(Item x) {
        if (m_size==m_array.length) {
            int newsize;
            if (m_size > Integer.MAX_VALUE/2) {
                assert m_array.length != Integer.MAX_VALUE;
                newsize =  Integer.MAX_VALUE;
            }
            else {
                newsize = m_size*2;
            }
            resize(newsize);
        }
        else {}
        m_array[m_size++] = x;
    }
    public Item delete(int k) {
        assert (0 < k && k <= m_size);
        Item ret = m_array[k-1];
        for (int i = k-1; i < m_size-1; i++) {
            m_array[i] = m_array[i+1];
        }
        m_array[--m_size] = null;
        return ret;
    }
    public void print() {
        for (int i = 0; i < m_size; i++) {
            StdOut.print(m_array[i]);
            StdOut.print(", ");
        }
        StdOut.println();
    }
}

public class exercise1338 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int N = StdIn.readInt();
            int M = StdIn.readInt();
            GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();
            for (int i = 0; i < N; i++) {
                queue.insert(StdIn.readInt());
            }
            queue.print();
            for (int i = 0; i < M; i++) {
                StdOut.println(queue.delete(StdIn.readInt()));
                queue.print();
            }
        }
    }
}