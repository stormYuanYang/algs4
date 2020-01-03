import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

class StaticSetOfInts {
    private int[] a;
    public StaticSetOfInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
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
    private int rankLow(int key) {
        int low = 0;
        int high= a.length-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (mid==0) {
                return mid;
            }
            else if (key == a[mid]) {
                if (a[mid-1] < key) {
                    return mid;
                }
                else {
                    high = mid-1;
                }
            }
            else if (key < a[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    private int rankHigh(int key) {
        int low = 0;
        int high= a.length-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (mid==a.length-1) {
                return mid;
            }
            else if (key == a[mid]) {
                if (key < a[mid+1]) {
                    return mid;
                }
                else {
                    low = mid+1;
                }
            }
            else if (key < a[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int howMany(int key) {
        int low = rankLow(key);
        if (low==-1) {
            return 0;
        } else {}
        int high = rankHigh(key);
        assert low <= high;
        return high - low + 1;
    }
}

public class exercise1411 {
    public static void main(String[] args) {
        assert args.length>=2;
        StaticSetOfInts ssi = new StaticSetOfInts(In.readInts(args[0]));
        int[] keys = In.readInts(args[1]);
        for (int i=0; i<keys.length; i++) {
            StdOut.printf("key:%d count:%d\n", keys[i], ssi.howMany(keys[i]));
        }
    }
}