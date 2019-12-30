import edu.princeton.cs.algs4.*;
import java.util.*;

class RandomQueue<Item> implements Iterable<Item> {
    private static int DEFAULT_CAPCITY = 4;
    private Item[] m_array = (Item[]) new Object[DEFAULT_CAPCITY];
    private int m_size;
    protected int size() {
        return m_size;
    }
    public RandomQueue() {
    }
    public boolean isEmpty() {
        return m_size==0;
    }
    private void resize(int newcap) {
        assert newcap >= m_size;
        if (newcap<DEFAULT_CAPCITY) {
            newcap = DEFAULT_CAPCITY;
        } 
        else {}

        Item[] tmp = (Item[]) new Object[newcap];
        for (int i = 0; i < m_size; i++) {
            tmp[i] = m_array[i];
            m_array[i]= null;
        }
        m_array = tmp;
    }
    public void enqueue(Item item) {
        if (m_size==m_array.length) {
            int newsize;
            if (m_size > Integer.MAX_VALUE/2) {
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
    public Item dequeue() {
        assert !isEmpty();
        Random random = new Random();
        int randomIndex = random.nextInt(m_size);

        Item tmp = m_array[randomIndex];
        m_array[randomIndex] = m_array[m_size-1];
        m_array[m_size-1] = null;
        m_size--;

        if (m_size < m_array.length/4) {
            resize(m_size*2);
        }
        else {}

        return tmp;
    }
    public Item sample() {
        assert !isEmpty();
        Random random = new Random();
        int randomIndex = random.nextInt(m_size);
        return m_array[randomIndex];
    }
    public void print() {
        if (isEmpty()) {
            StdOut.println("随机队列已空");
            return;
        }
        else {}
        for (int i=0; i<m_size; i++) {
            StdOut.print(m_array[i]);
            StdOut.print(", ");
        }
        StdOut.println(String.format("\tsize:%d cap:%d", size(), m_array.length));
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

class Test {
    public void test1() {
        RandomQueue<String> rq = new RandomQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString(); 
            rq.enqueue(s);
        }
        for (String s : rq) {
            StdOut.print(s);
            StdOut.print(", ");
        }
        StdOut.println();
    }
    // 玩桥牌一般是4个人，每人13张扑克（去掉大小王），一共52张
    // 总共有四种花色：梅花C、方块D、红心H、黑桃S
    public void testCard() {
        RandomQueue<String> rq = new RandomQueue<>();
        // 创建一副扑克（不包含大小王）
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString(); 
            switch (s.charAt(0)) {
            case 'C':
                rq.enqueue(s);
                break;
            case 'D':
                rq.enqueue(s);
                break;
            case 'H':
                rq.enqueue(s);
                break;
            case 'S':
                rq.enqueue(s);
                break;
            default:
                assert false : "非法数据";
            }
        }
        assert rq.size() == 52;
        // 现在，开始发牌
        String[] playerName = {"张三", "李四", "王麻子", "老杨"};
        String[][] A = new String[4][13];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                A[j][i] = rq.dequeue();
            }
        }
        // 打印4位玩家的牌
        for (int i = 0; i < 4; i++) {
            StdOut.print(String.format("%s:\t", playerName[i]));
            for (int j = 0; j < 13; j++) {
                StdOut.print(A[i][j]);
                if (j != 12) {
                    StdOut.print("\t");
                }
                else {}
            }
            StdOut.println();
        }
    }
}

public class exercise1336 {
    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
    }
}