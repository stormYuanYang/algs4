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
}

public class exercise134 {
    public static boolean isComplete(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '[':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.pop()=='[') {
                        // do nothing
                    }
                    else {
                        return false;
                    }
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.pop()=='(') {
                        // do nothing
                    }
                    else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop()=='{') {
                        // do nothing
                    }
                    else {
                        return false;
                    }
                    break;
                default:
                // do nothing 忽略所有其他字符
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        // 还有剩余的左括号，说明没有配对完整
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            StdOut.println(isComplete(line));
        }
    }
}