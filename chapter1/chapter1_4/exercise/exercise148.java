import edu.princeton.cs.algs4.*;
import java.util.*;
import java.lang.*;

public class exercise148 {
    public static void main(String[] args) {
        int[] datas = In.readInts(args[0]);
        Arrays.sort(datas);
        int count = 0;
        for (int i = 0; i < datas.length-1; i++) {
            if (datas[i] == datas[i+1]) {
                count++; 
                i++;
            }
            else {}
        }
        StdOut.printf("相等的整数对有%d个\n", count);
    }
}