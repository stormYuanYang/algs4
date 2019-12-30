import edu.princeton.cs.algs4.*;

public class exercise1313 {
    // 比起1.3.3简单多了，因为不管怎么入队、出队
    //出队的顺序都是固定的（先进先出）
    public static void main(String[] args) {
        int N = 10;
        while (!StdIn.isEmpty()) {
            StringBuffer strBuf = new StringBuffer();
            boolean impossible = false;
            int a = StdIn.readInt();
            strBuf.append(a);
            strBuf.append(' ');
            for (int i = 1; i < N; i++) {
                int b = StdIn.readInt();
                strBuf.append(b);
                strBuf.append(' ');
                if (a > b) {
                    impossible = true;
                }
                else {
                }
                a = b;
            }
            if (impossible) {
                strBuf.append("is impossible");
            }
            else {
            }
            StdOut.println(strBuf);
        }
    }
}