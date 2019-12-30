public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    public void push(String item) {
        a[N] = item;
        N = N+1;
    }
    public String pop() {
        N = N-1;
        return a[N];
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }
    public boolean isFull() {
        return N == a.length;
    }
}