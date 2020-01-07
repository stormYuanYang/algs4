import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;


public class exercise1414 {
    public static int binarySearch(int[] A, int key, int low, int high) {
        assert A!=null;
        assert low<=high;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (key==A[mid]) {
                return mid;
            }
            else if (key<A[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public static int fourSum(int[] A) {
        assert A!=null;
        int count=0;
        for (int i=0; i<A.length-3; i++) {
            for (int j=i+1; j<A.length-2; j++) {
                for (int k=j+1; k<A.length-1; k++) {
                    int z = binarySearch(A, 0-A[i]-A[j]-A[k], k+1, A.length-1);
                    if (z != -1) {
                        StdOut.printf("%d %d %d %d\n", A[i], A[j], A[k], A[z]);
                        count++;
                    }
                    else {}
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        assert args.length>=1;
        int[] A = In.readInts(args[0]);
        StdOut.printf("count:%d\n", fourSum(A));
    }
}