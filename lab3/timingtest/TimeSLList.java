package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        int op = 10000;
        AList<Integer> ops = new AList();
        ops.addLast(op);
        ops.addLast(op);
        ops.addLast(op);
        ops.addLast(op);
        ops.addLast(op);
        ops.addLast(op);
        ops.addLast(op);
        ops.addLast(op);
        AList<Double> times = new AList();
        AList<Integer> Ns = new AList();
        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);
        for (int i = 0; i < Ns.size(); i += 1) {
            SLList<Integer> original = new SLList();
            for (int j = 0; j < Ns.get(i); j += 1) {
                original.addLast(1);
            }
            Double time = timeGetLast(original, op);
            times.addLast(time);
        }
        printTimingTable(Ns, times, ops);
    }

    public static Double timeGetLast(SLList<Integer> original, int op) {
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < op; i += 1) {
            original.getLast();
        }
        double time = sw.elapsedTime();
        return time;
    }

}
