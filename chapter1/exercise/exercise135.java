import edu.princeton.cs.algs4.*;

class Stack<Item> {
    private Item[] m_stack;
    private int m_size;
    public Stack() {
        m_stack = (Item[]) new Object[8];
    }
    public Stack(int cap) {
        assert(cap>0);
        m_stack = (Item[]) new Object[cap];
    }
    private boolean isFull() {
        if (m_size==m_stack.length) {
            return true;
        }
        else {
            return false;
        }
    }
    private void resize(int newcap) {
        assert(newcap>0);
        Item[] tmp = (Item[]) new Object[newcap];
        for (int i = 0; i < m_size; i++) {
            tmp[i] = m_stack[i];
        }
        m_stack = tmp;
    }
    public boolean isEmpty() {
        if (m_size==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public void push(Item item) {
        if (isFull()) {
            resize(m_size*2);
        }
        else {
        }
        m_stack[m_size++] = item;
    }
    public Item pop() {
        if (m_size < m_stack.length/4) {
            resize(m_size*2);
        }
        Item item = m_stack[--m_size];
        m_stack[m_size] = null;
        return item;
    }
}

public class exercise135 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            Stack<Integer> stack = new Stack<>();
            int N = StdIn.readInt();
            while (N > 0) {
                stack.push(N % 2);
                N = N / 2;
            }
            while (!stack.isEmpty()) {
                StdOut.print(stack.pop());
            }
            StdOut.println();
        }
    }
}