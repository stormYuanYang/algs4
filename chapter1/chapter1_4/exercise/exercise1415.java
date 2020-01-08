import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

public class exercise1415 {
    public static void twoSum(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (set.contains(-A[i])) {
                set.remove(-A[i]);
                StdOut.printf("%d %d\n", -A[i], A[i]);
                count++;
            }
            else {
                set.add(A[i]);
            }
        }
        StdOut.printf("count:%d\n", count);
    }
    public static void threeSum(int[] A) {
    }
    public static void main(String[] args) {
        assert args.length>0;
        twoSum(In.readInts(args[0]));
    }
}