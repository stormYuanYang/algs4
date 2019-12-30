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
    public void push(Item item) {
        if (isFull()) {
            resize(m_size*2);
        }
        else {
        }
        m_stack[m_size++] = item;
    }
    public Item top() {
        return m_stack[m_size-1];
    }
    public Item pop() {
        if (m_size < m_stack.length/4) {
            resize(m_size*2);
        }
        else {
        }
        Item item = m_stack[--m_size];
        m_stack[m_size] = null;
        return item;
    }
    public boolean isEmpty() {
        return m_size==0;
    }
    private boolean isFull() {
        return m_size==m_stack.length;
    }
    private void resize(int newcap) {
        assert(newcap>0);
        Item[] tmp = (Item[]) new Object[newcap];
        for (int i = 0; i < m_size; i++) {
            tmp[i] = m_stack[i];
        }
        m_stack = tmp;
    }
    public int size() {
        return m_size;
    }
    public void print() {
        for (int i = 0; i < m_size; i++) {
            StdOut.print(m_stack[i]);
            StdOut.print(" ");
        }
        StdOut.println();
    }
}

public class exercise138 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("-")) {
                stack.pop();
            }
            else {
                stack.push(str);
            }
        }
        stack.print();
        StdOut.println(stack.size());
    }
}