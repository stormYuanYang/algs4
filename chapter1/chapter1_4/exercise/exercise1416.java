import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;


public class exercise1416 {
    public static void main(String[] args) {
        assert args.length>0;
        double[] a = In.readDoubles(args[0]);
        Arrays.sort(a);
        double minDiff = Double.MAX_VALUE;
        for (int i = 0; i < a.length-1; i++) {
            double diff = Math.abs(a[i]-a[i+1]);
            if (minDiff > diff) {
                minDiff = diff; 
            }
            else {

            }
        }
        StdOut.printf("min diff:%f\n", minDiff);
    }
}