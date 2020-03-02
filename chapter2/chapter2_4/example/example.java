import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

class MaxPQ {
    private Comparable[] pq;
    private int N=0;
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j) {
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private void swim(int k) {
        while (k>1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j<N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k=j;
        }
    }
    public MaxPQ(int max) { 
        pq = new Comparable[max+1];
    }
    public MaxPQ(Comparable[] a) {
        pq = a;
    }
    public void insert(Comparable v) {
        pq[++N] = v;
        swim(N);
    }
    public Comparable max() {
        return pq[1];
    }
    public Comparable delMax() {
        Comparable max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }
    public boolean isEmpty() {
        return N==0;
    }
    public int size() {
        return N;
    }                 
}

public class example {
    public static void main(String[] args) {
        int N0 = 1000;
        int N1= 1000000;
        int N2= 100000000;
        int N =N0;
        Random random = new Random();
        for (int i=0; i<N; i++) {
            StdOut.println(random.nextInt(N));
        }
    }
} 