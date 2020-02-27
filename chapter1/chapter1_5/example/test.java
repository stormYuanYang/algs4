import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

class UF {
    private int[] id;
    private int count;
    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot==qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public boolean connected(int p, int q) {
        return find(p)==find(q);
    }
    public int count() {
        return count;
    }
}

class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i=0; i<N; i++) {
            sz[i] = 1;
        }
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        while (p!=id[p]) {
            p=id[p];
        }
        return p;
    }
    // 小树合并到大树降低 降低树的高度
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i==j) {
            return;
        }
        if (sz[i]<sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}

public class test {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                //StdOut.println(p + " " + q);
            }
        }
        StdOut.println(uf.count() + "components");
    }
}