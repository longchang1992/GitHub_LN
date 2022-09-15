package randomizedtest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testThreeAddThreeRemove {
    @Test
    public void testAddConstantOne() {
        AListNoResizing<Integer> noSizing = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        noSizing.addLast(5);
        noSizing.addLast(10);
        noSizing.addLast(15);

        buggy.addLast(5);
        buggy.addLast(10);
        buggy.addLast(15);

        assertEquals(noSizing.size(), buggy.size());
        assertEquals(noSizing.get(1), buggy.get(1));

        assertEquals(noSizing.removeLast(), buggy.removeLast());
        assertEquals(noSizing.removeLast(), buggy.removeLast());
        assertEquals(noSizing.removeLast(), buggy.removeLast());
    }

}
