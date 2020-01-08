import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;


public class exercise1417 {
    public static void main(String[] args) {
        assert args.length>0;
        double[] a = In.readDoubles(args[0]);
        assert a.length>=2;
        double min = Math.abs(a[0]);
        double max = min;
        for (int i = 1; i < a.length; i++) {
            double tmp = Math.abs(a[i]);
            if (min > tmp) {
                min = tmp;
            }
            else if (max < tmp) {
                max = tmp;
            }
            else {
            }
        }
        StdOut.printf("max diff:%f\n", max-min);
    }
}