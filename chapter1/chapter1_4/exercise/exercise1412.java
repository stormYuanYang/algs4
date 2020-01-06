import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;


public class exercise1412 {
    public static void printCommonElement(int[] A, int[] B, int len) {
        assert A!=null;
        assert B!=null;
        assert len>=0 && len<=A.length && len<=B.length;
        for (int i=0, j=0; i<len && j<len;) {
            if (A[i]==B[j]) {
                StdOut.printf("%d ", A[i]);
                i++;
                j++;
            }
            else {
                if (A[i]<B[j]) {
                    i++;
                }
                else {
                    j++;
                }
            }
        }
        StdOut.println();
    }
    
    public static void main(String[] args) {
        assert args.length>=2;
        int[] A = In.readInts(args[0]);
        int[] B = In.readInts(args[1]);
        assert A.length==B.length;
        printCommonElement(A, B, A.length);
    }
}