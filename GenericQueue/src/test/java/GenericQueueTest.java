import edu.gcccd.csis.GenericQueue;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;

public class GenericQueueTest {

    GenericQueue<String> queueTest;

    @Before
    public void setUp() {

         queueTest = new GenericQueue();
    }

    @Test
    public void testAdd() {
        queueTest.enqueue("5");
        assertEquals("5", queueTest.dequeue());
    }

    @Test
    public void testRemove() {
        queueTest.enqueue("7");
        assertEquals("7", queueTest.dequeue());
    }

    @Test
    public void testLength() {
        queueTest.enqueue("5");
        queueTest.enqueue("5");
        queueTest.enqueue("5");
        queueTest.enqueue("5");

        assertEquals(4, queueTest.length());
    }


}
