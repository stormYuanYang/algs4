import edu.princeton.cs.algs4.*;
import java.util.*;
import java.io.*;

class Stack<Item> {
    private static final int DEFAULT_CAPCITY = 8;
    private Item[] m_array;
    private int m_size;
    public Stack() {
        m_array = (Item[]) new Object[DEFAULT_CAPCITY];
    }
    public void push(Item item) {
        if (m_size==m_array.length) {
            int newsize;
            if (m_size > Integer.MAX_VALUE/2) {
                assert m_size < Integer.MAX_VALUE;
                newsize = Integer.MAX_VALUE; 
            }
            else {
                newsize = m_size*2;
            }
            resize(newsize);
        } else {}
        m_array[m_size++] = item;
    }
    public boolean isEmpty() {
        return m_size == 0;
    }
    public Item pop() {
        assert !isEmpty();
        Item ret = m_array[--m_size];
        m_array[m_size] = null;
        return ret;
    }
    private void resize(int newcap) {
        assert newcap >= 0;
        if (newcap <= DEFAULT_CAPCITY) {
            return;
        } else {}
        Item[] tmp = (Item[]) new Object[newcap];
        for (int i =0; i < m_size; i++) {
            tmp[i] = m_array[i];
            m_array[i] = null;
        }
        m_array = tmp;
    }
}

class MyFile {
    public File file;
    public int depth;
    public MyFile(File file, int depth) {
        this.file = file;
        this.depth = depth;
    }
}

public class exercise1343 {
    public static void print(File file, int depth) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            buffer.append("  ");
        }
        StdOut.println(String.format("%s%s", buffer, file.getName()));
    }
    // 存粹使用递归函数 打印目录及其所有内容
    public static void func(File file, int depth) {
        assert file != null;
        if (depth > 500) {
            return;
        } else {}
        print(file, depth);
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                func(subFile, depth+1);
            }
        }
        else {}
    }
    // 使用栈存储需要打印的文件
    public static void func1(File rootFile) {
        assert rootFile != null;
        Stack<MyFile> stack = new Stack<>();
        stack.push(new MyFile(rootFile, 0));
        while (! stack.isEmpty()) {
            MyFile myFile = stack.pop();
            print(myFile.file, myFile.depth);
            if (myFile.file.isDirectory()) {
                for (File subFile : myFile.file.listFiles()) {
                    stack.push(new MyFile(subFile, myFile.depth+1));
                }
            }
            else {}
        }
    }
    public static void main(String[] args) {
        assert args.length == 1;
        File f = new File(args[0]);
        func1(f);
    }
}