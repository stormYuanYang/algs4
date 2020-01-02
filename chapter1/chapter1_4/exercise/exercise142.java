import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise142 {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int min, mid, max;
                    if (a[i] < a[j]) {
                        min = a[i];
                        mid = a[j];
                    }
                    else {
                        min = a[j];
                        mid = a[i];
                    }

                    if (a[k] < min) {
                        max = mid;
                        mid = min;
                        min = a[k];
                    }
                    else if (a[k] < mid) {
                        max = mid;
                        mid = a[k];
                    }
                    else {
                        max = a[k];
                    }

                    // 全部为正数或者全部为负数时，其和不可能为0
                    // 全部为正数，也可能和为0（此时溢出了，结果当然是错误的）
                    // 比如 2 + Integer.MAX_VALUE + Integer.MAX_VALUE
                    if (min > 0 || max < 0) {
                    }
                    else {
                        // 如果能满足条件则 min 一定是负数，max一定是正数
                        // min+max一定不会溢出
                        // (min+max) + mid 可能会溢出
                        // 但是当其溢出时，就不可能为0了(除非min和mid都等于Integer.MIN_VALUE)
                        if (min == mid && min == Integer.MIN_VALUE) {
                        }
                        else if ((min + max) + mid == 0) {
                            cnt++;
                        }
                        else {}
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
        StdOut.printf("%d\n", Integer.MIN_VALUE + Integer.MIN_VALUE);
    }
}