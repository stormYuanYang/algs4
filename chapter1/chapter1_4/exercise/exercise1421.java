import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

class StaticSetOfInts {
    private int[] a;
    public StaticSetOfInts(int[] keys) {
        int[] tmp = new int[keys.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = keys[i];
        }
        Arrays.sort(tmp);

        if (tmp.length==0) {
            a = new int[0];
        }
        else {
            int len = 1;
            for (int i = 0; i < tmp.length - 1; i++) {
                if (tmp[i] != tmp[i + 1]) {
                    len++;
                } 
                else {
                }
            }
            a = new int[len];
            a[0] = tmp[0];
            for (int i = 0, j=1; i < tmp.length-1; i++) {
                if (tmp[i] != tmp[i + 1]) {
                    a[j++] = tmp[i + 1];
                } 
                else {
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            StdOut.printf("%d ", a[i]);
        }
        StdOut.println();
    }
    private int rank(int key) {
        int lo = 0;
        int hi = a.length-1;
        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if (key == a[mid]) {
                return mid;
            }
            else if (key < a[mid]) {
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return -1;
    }
    public boolean contains(int key) {
        return rank(key) != -1;
    }
}

public class exercise1421 {
    public static void main(String[] args) {
        assert args.length>=2;
        StaticSetOfInts ssi = new StaticSetOfInts(In.readInts(args[0]));
        int[] keys = In.readInts(args[1]);
        for (int i=0; i<keys.length; i++) {
            StdOut.printf("key:%d finded in:%s\n", keys[i], ssi.contains(keys[i]));
        }
    }
}