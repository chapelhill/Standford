
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomizedQueueTest {
	private RandomizedQueue qr;
	@Before
	public void setUp() throws Exception {
		qr = new RandomizedQueue();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnqueue() {
		qr.enqueue(123);
		assertEquals(123,qr.dequeue());
	}

	@Test
	public void testIsEmpty() {
		qr.isEmpty();
	}



}
