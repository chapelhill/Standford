import static org.junit.Assert.*;

import java.util.NoSuchElementException;

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
	public void testEnqueueEmpty() {
		qr.enqueue(123);
		qr.dequeue();
		qr.enqueue(1233);
		assertEquals(1233,qr.dequeue());
		assertEquals(true, qr.isEmpty());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testEnqueueCount() {
		qr.enqueue(123);
		qr.enqueue(1233);
		qr.enqueue(1233);
		qr.enqueue(1233);
		qr.enqueue(1233);
		qr.enqueue(1233);
		assertEquals(6, qr.size());
	}
	@Test(expected = NoSuchElementException.class)
	public void testfailEnqueue() {
		qr.enqueue(123);
		qr.dequeue();
		qr.dequeue();
		qr.dequeue();

	}
	@Test
	public void testIsEmpty() {
		qr.isEmpty();
	}
}