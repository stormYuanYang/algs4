import edu.princeton.cs.algs4.*;

import java.util.*;
import java.lang.*;

class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0; i<N; i++) {
            int min = i;
            for (int j=i+1; j<N; j++) {
                if (example.less(a[j], a[min])) {
                    min = j;
                }
            }
            example.exchange(a, i, min);
        }
    }
}

class Insertion {
    public static void sort(Comparable[] a) {
        //StdOut.println("开始插入排序");
        int N = a.length;
        for (int i=1; i<N; i++) {
            Comparable key = a[i];
            int j = i-1;
            for (; j>=0 && example.less(key, a[j]); j--) {
                a[j+1] = a[j];
            }
            a[j+1] = key;
        }
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        for (int i=lo+1; i<=hi; i++) {
            Comparable key = a[i];
            int j = i-1;
            for (; j>=lo && example.less(key, a[j]); j--) {
                a[j+1] = a[j];
            }
            a[j+1] = key;
        }
    }
}

class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i=h; i<N; i++) {
                for (int j=i; j>=h && example.less(a[j], a[j-h]); j-=h) {
                    example.exchange(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
}

class Merge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i>mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (example.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi<=lo) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (example.less(a[mid+1], a[mid])) {
            merge(a, aux, lo, mid, hi);
        }
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }
}

class MergeBU {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i>mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (example.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }
    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[a.length];
        for (int sz=1; sz<N; sz = sz+sz) {
            for (int lo=0; lo < N-sz; lo += sz+sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }
}

class Quick {
    private static int X = 12;
    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo + X) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i=lo, j=hi+1;    
        Comparable v = a[lo];
        while (true) {
            while (example.less(a[++i], v)) {
                if (i==hi) {
                    break;
                }
            }
            while (example.less(v, a[--j])) {
                if (j==lo) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            example.exchange(a, i, j);
        }
        example.exchange(a, lo, j);
        return j;
    }
}

class Quick3way {
    public static void sort(Comparable[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo) {
            return;
        }
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp<0) {
                example.exchange(a, lt++, i++);
            }
            else if (cmp>0) {
                example.exchange(a, i, gt--);
            }
            else {
                i++;
            }
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
}

class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }
        else if (alg.equals("Selection")) {
            Selection.sort(a);
        }
        else if (alg.equals("Shell")) {
            Shell.sort(a);
        }
        else if (alg.equals("Merge")) {
            Merge.sort(a);
        }
        else if (alg.equals("MergeBU")) {
            MergeBU.sort(a);
        }
        else if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        else if (alg.equals("Quick3way")) {
            Quick3way.sort(a);
        }
        double ret = timer.elapsedTime();
        assert example.isSorted(a);
        return ret;
    }
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t=0; t<T; t++) {
            for (int i=0; i<N; i++) {
                //a[i] = 10.0;
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
}

public class example {
    public static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a) {
        for (int i=0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
    public static void sort(Comparable[] a) {
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("%s time:%.3f, %s time:%.3f rate:%.1f\n", alg1, t1, alg2, t2, t2/t1);
    }
}