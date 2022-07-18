package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static AListNoResizing <Integer> std = new AListNoResizing<>();
    public static BuggyAList <Integer> buggy = new BuggyAList<>();
    public static int N = 1000;

    @Test
    public void randomizedTest() {
        for(int i=1;i<=N;i++)
        {
            int op = StdRandom.uniform(0,2);
            if(op == 0)
            {
                int addnum = StdRandom.uniform(0,10000);
                std.addLast(addnum);
                buggy.addLast(addnum);
                System.out.println("stdaddLast(" + addnum + ")");
                System.out.println("bugaddLast(" + addnum + ")");
                assertEquals(std.getLast(), buggy.getLast());
            }
            else if(op == 1)
            {
                int size = std.size();
                assertEquals(std.size(), buggy.size());
                if(size > 0) {
                    assertEquals(std.removeLast(), buggy.removeLast());
                    System.out.println("stdsize after delete: " + std.size());
                    System.out.println("bugsize after delete: " + buggy.size());
                }
            }
            else if(op == 2)
            {
                assertEquals(std.getLast(), buggy.getLast());
            }
        }




    }

}
