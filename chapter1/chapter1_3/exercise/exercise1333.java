import edu.princeton.cs.algs4.*;

class Deque<Item> {
    private class Node {
        Item item;
        Node prev;
        Node next;
    }
    private Node left;
    private Node right; 
    private int size;
    public Deque() {
    }
    public boolean isEmpty() {
        return left == null;
    }
    public int size() {
        return size;
    }
    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        if (left!=null) {
            node.next = left;
            left.prev = node;
            left = node;
        }
        else {// Deque中无节点 node就是第一个节点
            assert(right==null);
            left = node;
            right = node;
        }
        size++;
        printDeque();
    }
    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        if (right!=null) {
            node.prev = right;
            right.next = node;
            right = node;
        }
        else {
            assert(left==null);
            left = node;
            right = node;
        }
        size++;
        printDeque();
    }
    public Item popLeft() {
        assert(!isEmpty());
        Item tmp = left.item;
        Node newLeft = left.next;
        left.next = null;
        if (newLeft!=null) {
            newLeft.prev = null;
            left = newLeft;
        }
        else {// Deque空了
            left = null;
            right = null;
        }
        size--;
        printDeque();
        return tmp;
    }
    public Item popRight() {
        assert(!isEmpty());
        Item tmp = right.item;
        Node newRight = right.prev;
        right.prev = null;
        if (newRight!=null) {
            newRight.next = null;
            right = newRight;
        }
        else {//Deque 空了
            left = null;
            right = null;
        }
        size--;
        printDeque();
        return tmp;
    }
    public void printDeque() {
        Node current = left;
        if (current == null) {
            StdOut.println("now, Deque is empty");
        }
        else {
            while (current != null) {
                StdOut.print(current.item);
                current = current.next;
                if (current != null) {
                    StdOut.print("<->");
                }
            }
            StdOut.println(String.format("    size:%d", size));
        }
    }
}

// 注意 此类并未编写完
class ResizingArrayDeque<Item> {
    private static int DEFAULT_CAPACITY = 4;
    private static boolean LEFT = true;
    private static boolean RIGHT = false;
    private Item[] leftArray;
    private Item[] rightArray;
    private int leftSize;
    private int rightSize;

    private int to(int index) {
        assert(index<0);
        return (0-index)-1;
    }
    // 这里申请内存失败，应该抛出异常
    // 因为主要目的时学习算法知识，而不是语言 暂时不考虑异常处理
    // 拷贝区间为[first, last) 即A[first] ~ A[last-1]
    private void resize(boolean isLeft, int newcap, int first, int last) {
        assert(first<last);
        if (newcap<=DEFAULT_CAPACITY) {
            return;
        } 
        else {}

        Item[] tmp = (Item[]) new Object[newcap];
        if (isLeft) {
            for (int i = first, j=0; i < last; i++) {
                tmp[j] = leftArray[i];
            }
            leftArray = tmp;
        }
        else {
            for (int i = first, j=0; i < last; i++) {
                tmp[j] = rightArray[i];
            }
            rightArray = tmp;
        }
    }
    public ResizingArrayDeque() {
        leftArray = (Item[]) new Object[DEFAULT_CAPACITY];
        rightArray = (Item[]) new Object[DEFAULT_CAPACITY];
    }
    public boolean isEmpty() {
        if (leftSize<=0) {
            assert(rightSize>0);
            return rightSize + leftSize == 0;
        }
        else if (rightSize<=0) {
            assert(leftSize>0);
            return leftSize + rightSize == 0;
        } else {// 现在 leftSize>0并且rightSize>0
            return false;
        }
    }
    public int size() {
        return leftSize + rightSize;
    }
    public void pushLeft(Item item) {
        if (leftSize < 0) {
            // (0 - leftSize) - 1 是右数组下标
            // 表示右数组中最左侧可以入队的位置
            rightArray[to(leftSize)] = item;
            leftSize = leftSize + 1;
        }
        else {
            if (leftSize == leftArray.length) {
                resize(LEFT, leftSize * 2);
            } else {
            }
            // 以后尽量不写a++，++a之类的代码；这是非常不好的
            // a = a+1;更加清晰，也不容易出错
            leftArray[leftSize] = item;
            leftSize = leftSize + 1;
        }
    }
    public void pushRight(Item item) {
        if (rightSize < 0) {
            leftArray[to(rightSize)] = item;
            rightSize = rightSize + 1;
        }
        else {
            if (rightSize == rightArray.length) {
                // 注意，这里没有对rightSize*2的结果做判断，可能会溢出
                // 在生产环境的代码，应该考虑到容量大小溢出的问题
                resize(RIGHT, rightSize * 2);
            } else {
            }
            rightArray[rightSize] = item;
            rightSize = rightSize + 1;
        }
    }
    public Item popLeft() {
        assert(!isEmpty());
        if (leftSize <= 0) {
            leftSize = leftSize-1;
            Item item = rightArray[to(leftSize)];
            rightArray[to(leftSize)] = null; 
            if (size() <= rightArray.length/4) {
                resize(RIGHT, rightArray.length/2, to(leftSize)+1, rightSize);
                leftSize = 0;
            }
            else {}
            return item;
        }
        else {
            Item item = leftArray[--leftSize];
            if (leftSize <= leftArray.length / 4) {
                resize(LEFT, leftArray.length / 2);
            } else {
            }
            return item;
        }
    }
    public Item popRight() {
        assert(!isEmpty());
        if (rightSize<=0) {
            rightSize = rightSize-1;
            Item item = leftArray[to(rightSize)];
            leftArray[to(rightSize)] = null;
            if (size() <= leftArray.length/4) {
                resize(LEFT, leftArray.length/2, to(rightSize)+1, leftSize);
                rightSize = 0;
            }
            else {}
            return item;
        }
        else {
            Item item = rightArray[--rightSize];
            if (rightSize <= rightArray.length / 4) {
                resize(RIGHT, rightArray.length / 2);
            } else {
            }
            return item;
        }
    }
}

public class exercise1333 {
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            deque.pushLeft(str);    
            deque.pushRight(str);    
        }
        while (!deque.isEmpty()) {
            deque.popRight();
        }
    }
}