import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class test {
    public static void main(String[] args) {
        Queue<String> s;
        s = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                //StdOut.println(item);
                s.enqueue(item);
            }
            else {
            }
        }
        for (String string : s) {
            StdOut.println(string);
        }
        StdOut.println("~~~~~~~~~~~~~~~~");
        while (!s.isEmpty()) {
            String item = s.dequeue();
            StdOut.println(item);
        }
    }
}