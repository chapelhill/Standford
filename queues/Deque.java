
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first, last;
	private int size = 0;

	private class Node {
		Item item;
		Node next;
		Node prev;
	}
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
			return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new java.util.NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
	public Deque() {
	}

	private void assertNotNull(Item item) {
		if (item == null)
			throw new NullPointerException();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		// add the item to the front
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		// first.prev = null;
		first.next = oldFirst;

		if (isEmpty()) {
			last = first;
		} else {
			oldFirst.prev = first;
		}
		size++;
	}

	public void addLast(Item item) {
		// add the item to the end

		Node oldLast = last;
		last = new Node();
		last.item = item;
		// last.next = null;
		last.prev = oldLast;

		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item removedItem = first.item;
		if (size > 1) {
			first = first.next;
			first.prev = null;
		} else {
			first = null;
			last = null;
		}

		size--;
		return removedItem;
		// remove and return the item from the front
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item removedItem = last.item;
		if (size > 1) {
			last = last.prev;
			last.next = null;
		} else {
			first = null;
			last = null;
		}
		size--;
		return removedItem;
		// remove and return the item from the end
	}

	public Iterator<Item> iterator() {
		
		return new DequeIterator() ;
		// return an iterator over items in order from front to end
	}


}
