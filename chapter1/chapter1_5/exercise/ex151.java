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
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        return id[p];
    }
    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        if (pID==qID) {
            return;
        }
        for (int i=0; i<id.length; i++) {
            if (id[i]==qID) {
                id[i] = pID;
            }
        }
        count--;
    }
    public void print() {
        for (int i=0; i<id.length; i++) {
            StdOut.printf("%d ", id[i]);
        }
        StdOut.println();
    }
}

public class ex151 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (! uf.connected(p, q)) {
                uf.union(p, q);
            }
            uf.print();
        }
        StdOut.println(uf.count()+"components");
    }
}