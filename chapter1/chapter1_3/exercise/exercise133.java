import edu.princeton.cs.algs4.*;
import java.util.ArrayList;
public class exercise133 {
    public static void main(String[] args) {
        int N = 10;
        while (!StdIn.isEmpty()) {
            ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
            StringBuffer stringbuffer = new StringBuffer();
            for (int i = 0; i < N; i++) {
                int a = StdIn.readInt();
                stringbuffer.append(a);
                stringbuffer.append(' ');
                boolean flag = true;
                for (int j = A.size()-1; j >= 0; j--) {
                    if ( a < A.get(j).get(0)) {
                        A.get(j).add(a);
                        flag = false;
                        break;
                    }
                    else {
                    }
                }
                if (flag) {
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(a);
                    A.add(al);
                }
                else {
                }
            }
            //for (int i = 0; i < A.size(); i++) {
            //    for (int j = 0; j < A.get(i).size(); j++) {
            //        StdOut.print(A.get(i).get(j) + " ");
            //    }
            //    StdOut.println();
            //}
            //StdOut.println("~~~");
            boolean impossible = false;
            for (int i = 0; i < A.size(); i++) {
                ArrayList<Integer> al = A.get(i);
                for (int j = 1; j < al.size(); j++) {
                    if (al.get(j-1) < al.get(j)) {
                        impossible = true;
                        break;
                    }
                    else {
                    }
                }
                if (impossible) {
                    stringbuffer.append(" is impossible");
                    StdOut.println(stringbuffer.toString());
                    break;
                }
                else {
                }
            }
        }
    }
}