package Deque;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class dequeTest {
	private Deque<Comparable> deque = new Deque();

	@Test
	public void addFirstTEST() {
		deque.addFirst("test");
		assertEquals(1, deque.size());
		deque.addFirst(12);
		assertEquals(2, deque.size());
	}

	@Test
	public void addLastTEST() {
		deque.addLast("test");
		assertEquals(1, deque.size());
		deque.addLast(12);
		assertEquals(2, deque.size());
	}

	@Test
	public void RemoveLaastTEST() {
		deque.addLast("test");
		deque.addLast(12);

		Object item = deque.removeLast();
		assertEquals(12, item);

		item = deque.removeLast();
		assertEquals("test", item);
	}

	@Test
	public void RemoveFirstTEST() {
		deque.addFirst("test");
		assertEquals(1, deque.size());
		deque.addFirst(12);
		assertEquals(2, deque.size());
		Object item = deque.removeFirst();
		assertEquals(12, item);
		item = deque.removeFirst();
		assertEquals("test", item);
	}

	@Test(expected = NoSuchElementException.class)
	public void RemoveFirstTESTNull() {
		Object item = deque.removeFirst();
		assertEquals(null, item);
	}

	@Test(expected = NoSuchElementException.class)
	public void removeLastTESTNull() {
		Object item = deque.removeLast();
		assertEquals(null, item);
	}
	
	@Test
	public void itertest(){
		deque.addFirst("test1");
		deque.addFirst("test2");
		deque.addFirst("test3");
		deque.addFirst("test4");
		
		Iterator<Comparable> comparable = deque.iterator();
			 
			  while(comparable.hasNext()){
				  System.out.println(comparable.next());
			  }
		
	}
}
