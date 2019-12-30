import edu.princeton.cs.algs4.*;
import java.util.*;

class RandomBag<Item> implements Iterable<Item> {
    private static int DEFAULT_CAPCITY = 4;
    private Item[] m_array = (Item[]) new Object[DEFAULT_CAPCITY];
    private int m_size;
    public RandomBag() {
    }
    public boolean isEmpty() {
        return m_size==0;
    }
    public int size() {
        return m_size;
    }
    public int capcity() {
        return m_array.length;
    }
    private void resize(int newcap) {
        assert (newcap > DEFAULT_CAPCITY) : String.format("newcap:%d", newcap);
        Item[] tmpArray = (Item[]) new Object[newcap];
        for (int i = 0; i < m_size; i++) {
            tmpArray[i] = m_array[i];
            m_array[i] = null;
        }
        m_array = tmpArray;
    }
    public void add(Item item) {
        if (m_size == m_array.length) {
            int newsize;
            if (m_size > Integer.MAX_VALUE/2) {
                // 当m_size已经等于Integer.MAX_VALUE时
                // 应当抛出内存不足的异常 这里简单地给一个断言已示提醒
                assert m_size < Integer.MAX_VALUE;
                newsize = Integer.MAX_VALUE;
            } 
            else {
                newsize = m_size*2;
            }
            resize(newsize);
        }
        else {}
        m_array[m_size++] = item;
    }
    private class RandomIterator implements Iterator<Item> {
        private int index = 0;
        public RandomIterator() {
            Random random = new Random();
            for (int i = 0; i < m_size; i++) {
                int r = random.nextInt(m_size);
                Item tmp = m_array[i];
                m_array[i] = m_array[r];
                m_array[r] = tmp;
            }
        }
        public boolean hasNext() {
            return index<m_size;
        }
        public Item next() {
            return m_array[index++];
        }
        public void remove() {
        }
    }
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }
}

public class exercise1334 {
    public static void main(String[] args) {
        RandomBag<String> rb = new RandomBag();
        while (! StdIn.isEmpty()) {
            String str = StdIn.readString();
            rb.add(str);
            for (String s : rb) {
                StdOut.print(s);
                StdOut.print(", ");
            }
            StdOut.println(String.format("\tsize:%d cap:%d", rb.size(), rb.capcity()));
        }
    }
}