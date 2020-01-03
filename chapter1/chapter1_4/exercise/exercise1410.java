import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

public class exercise1410 {
    public static int binarySearch(int[] A, int key) {
        int first = 0;
        int last = A.length-1;
        while (first<=last) {
            int mid = first + (last-first)/2;
            if (mid==0) {
                return mid;
            }
            else if (key==A[mid]) {
                if (A[mid-1] < key) {
                    return mid;
                }
                else {
                    last = mid-1;
                }
            }
            else if (key < A[mid]) {
                last = mid-1;
            }
            else {
                first = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        assert args.length>=2;
        int[] A = In.readInts(args[0]);
        int[] keys = In.readInts(args[1]);
        Arrays.sort(A);
        for (int i = 0; i < keys.length; i++) {
            StdOut.printf("key:%d index:%d\n", keys[i], binarySearch(A, keys[i]));
        }
    }
}