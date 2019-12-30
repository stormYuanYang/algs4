import edu.princeton.cs.algs4.*;
import java.util.*;

public class Stopwatch {
    public final long start;
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    public double elapsedTime() {
        final long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(final String[] args) {
        final int N = Integer.parseInt(args[0]);
        final int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        final Stopwatch timer = new Stopwatch();
        final int cnt = ThreeSum.count(a);
        final double time = timer.elapsedTime();
        StdOut.println(cnt+" triples "+time+" seconds");
    }
}