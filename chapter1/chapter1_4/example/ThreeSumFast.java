import edu.princeton.cs.algs4.*;
import java.util.*;

public class ThreeSumFast {
    public static int rank(int[] a, int key) {
        int first = 0;
        int last = a.length-1;
        while (first <= last) {
            int mid = first + (last-first)/2;
            if (key == a[mid]) {
                return mid;
            }
            else if (key < a[mid]) {
                last = mid-1;
            }
            else {
                first = mid+1;
            }
        }
        return -1;
    }
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i=0; i < N; i++) {
            for (int j =i+1; j<N; j++) {
                if (rank(a, 0 - a[i] - a[j]) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}