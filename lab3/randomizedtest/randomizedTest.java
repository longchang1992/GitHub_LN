package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class randomizedTest {
    @Test
    public void randomTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> LL = new BuggyAList<>();
        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = LL.size();
                System.out.println("size: " + size);
                assertEquals(size, size2);
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                int last = L.getLast();
                int last2 = LL.getLast();
                System.out.println("get last: " + last);
                assertEquals(last, last2);
            } else if (operationNumber == 3 && L.size() >0) {
                // remoLast
                int last = L.removeLast();
                int last2 = LL.removeLast();
                System.out.println("remove last: " + last);
                assertEquals(last, last2);
            }
        }
    }
}
