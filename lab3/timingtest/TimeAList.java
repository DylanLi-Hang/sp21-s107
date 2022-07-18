package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList Ns = new AList();
        AList times = new AList();
        AList opCount = new AList();

        int count_N = 1000;
        while(count_N <= 128000) {
            AList a = new AList();
            Stopwatch sw = new Stopwatch();
            for(int i=1;i<=count_N;i++){
                a.addLast(0);
            }
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(count_N);
            times.addLast(timeInSeconds);
            opCount.addLast(count_N);
            count_N = count_N * 2;
        }
        printTimingTable(Ns, times, opCount);
    }
}
