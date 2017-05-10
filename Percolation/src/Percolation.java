import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF UF;
	private int virtualtop;
	private int virtualbottom;
	private int n;
	private boolean[][] grid;
	private int numberofopensites = 0;

	public Percolation(int n) {
		this.n = n;
		UF = new WeightedQuickUnionUF(n * n + 2);
		this.grid = new boolean[n][n];
		virtualtop = n * n;
		virtualbottom = n * n + 1;

	}

	public void open(int row, int col) {
		// open site (row, col) if it is not open already
		throwIfOutOfBounds(row, col);
		int index = convert(row, col);
		if (!isOpen(row, col)) {
			grid[row - 1][col - 1] = true;
			numberofopensites++;
			  if (row == 1) {
		            UF.union(index, virtualtop);
		        }
		       if (row == n) {
		            UF.union(index, virtualbottom);
		        }


			// top
			int newrow = row - 1;
			int newcol = col;
			int newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				UF.union(index, newindex);
			}
			// bottom
			newrow = row + 1;
			newcol = col;
			newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				UF.union(index, newindex);
			}
			// bottom
			newrow = row;
			newcol = col - 1;
			newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				UF.union(index, newindex);
			}
			// bottom
			newrow = row;
			newcol = col + 1;
			newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				UF.union(index, newindex);
			}

		}
	}

	public boolean isOpen(int row, int col) {
		throwIfOutOfBounds(row, col);
		return grid[row - 1][col - 1];
		// is site (row, col) open?
	}

	public boolean isFull(int row, int col) {
		throwIfOutOfBounds(row, col);
		if (!isOpen(row, col)) {
			// i, j can't be connected to the top if it's not open
			return false;
		}
		// is site (row i, column j) full?
		// i.e. is site (i, j) connected to the top row?
		// is i, j connected to top site?
		return UF.connected(convert(row, col), virtualtop);
		// is site (row, col) full?
	}

	public int numberOfOpenSites() {
		return numberofopensites;
		// number of open sites
	}

	public boolean percolates() {
		return  UF.connected(virtualtop, virtualbottom);
		// does the system percolate?
	}

	private int convert(int row, int col) {
		return n * (row - 1) + (col - 1);

	}

	private boolean isInBounds(final int i) {
		return (i >= 1 && i <= n);
	}

	private boolean inBoundsAndOpen(int newI, int newJ) {
		return isInBounds(newI) && isInBounds(newJ) && isOpen(newI, newJ);
	}

	private void throwIfOutOfBounds(final int i, final int j) {
		if (!isInBounds(i) || !isInBounds(j)) {
			throw new IndexOutOfBoundsException(String.format("%d or %d out of bounds 1..N (%d)", i, j, n));
		}
	}

	public static void main(String[] args) {
		// test client (optional)
	}
}
