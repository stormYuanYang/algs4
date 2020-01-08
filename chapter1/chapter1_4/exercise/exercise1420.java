import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

public class exercise1420 {
    public static int findIndexOfMax(int[] a) {
        assert a.length>=3;
        int low = 0;
        int high = a.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (mid == 0 || mid == a.length-1) {
                return -1;
            }
            else {
                if (a[mid-1]<a[mid] && a[mid]>a[mid+1]) {
                    return mid;                    
                }
                else if (a[mid-1]>a[mid]) {
                    high = mid-1;
                }
                else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
    public static boolean binarySearchLeft(int[] a, int key, int high) {
        int low = 0;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (key == a[mid]) {
                return true;
            }
            else if (key < a[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return false;
    }
    public static boolean binarySearchRight(int[] a, int key, int low) {
        int high = a.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (key == a[mid]) {
                return true;
            }
            else if (key > a[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        assert args.length>=2;
        int[] a = In.readInts(args[0]);
        int[] keys = In.readInts(args[1]);
        int indexOfMax = findIndexOfMax(a);
        StdOut.printf("indexOfMax:%d\n", indexOfMax);
        assert indexOfMax != -1;
        for (int i = 0; i < keys.length; i++) {
            int key = keys[i];
            if (binarySearchLeft(a, key, indexOfMax)) {
                StdOut.printf("finded in left key:%d\n", key);
            }
            else if (binarySearchRight(a, key, indexOfMax)) {
                StdOut.printf("finded in right key:%d\n", key);
            }
            else {
                StdOut.printf("找不到key:%d\n", key);
            }
        }
    }
}