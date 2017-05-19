package Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] randomQueue;
	private int n;
	private int capacity;

	public RandomizedQueue() {
		// construct an empty randomized queue
		capacity = 1;
		randomQueue = (Item[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return n == 0;
		// is the queue empty?
	}

	public int size() {
		return n;
		// return the number of items on the queue
	}

	public void enqueue(Item item) {
		addnullitem(item);
		if (n >= capacity) {
			resize(2 * capacity);
		}
		randomQueue[n] = item;
		n++;
		// add the item
	}

	public Item dequeue() {
		emptyCheck();
		int randomIndex = StdRandom.uniform(n);

		Item item = randomQueue[randomIndex];
		if (n - 1 == randomIndex) {
			randomQueue[n - 1] = null;
		} else {
			randomQueue[randomIndex] = randomQueue[n - 1];
			randomQueue[n - 1] = null;
		}

		if (n > 0 && n == capacity / 4) {
			resize(capacity / 2);
		}
		n--;
		return item;
		// remove and return a random item
	}

	private void resize(int capacity) {
		Item[] newRandomQueue = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			newRandomQueue[i] = randomQueue[i];
		}
		randomQueue = newRandomQueue;
	}

	private void addnullitem(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
	}

	public Item sample() {
		return randomQueue[StdRandom.uniform(n)];
		// return (but do not remove) a random item
	}

	public Iterator<Item> iterator() {
		return new RandomizedIterator();
		// return an independent iterator over items in random order
	}

	private class RandomizedIterator implements Iterator<Item> {

		private int copyN = n;
		private Item[] Narray = (Item[]) new Object[randomQueue.length];

		public RandomizedIterator() {
			for (int i = 0; i < Narray.length; i++) {
				Narray[i] = randomQueue[i];
			}
		}

		public boolean hasNext() {
			return copyN > 0;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			int randomIndex = StdRandom.uniform(n);

			Item item = Narray[randomIndex];
			if (randomIndex == copyN - 1) {
				Narray[randomIndex] = null;
			} else {
				Narray[randomIndex] = Narray[copyN - 1];
				Narray[copyN - 1] = null;
			}
			copyN--;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private void emptyCheck() {
		if (n == 0) {
			throw new NoSuchElementException();
		}
	}

	public static void main(String[] args) {
		// unit testing (optional)
	}
}
