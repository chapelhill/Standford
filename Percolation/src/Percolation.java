import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF UF;
	
	private int n;
	private boolean[] grid;
	private boolean[] top;
	private boolean[] bottom;
	private boolean percolates;
	private int numberofopensites = 0;
	
	public Percolation(int n) {
		this.n = n;
		UF = new WeightedQuickUnionUF(n * n);
		this.grid = new boolean[n*n];
		this.top = new boolean[n*n];
		this.bottom = new boolean[n*n];
		for (int i = 0; i < n*n; i++) {
            grid[i] = false;
            top[i] = false;
            bottom[i] = false;
        } 
		percolates = false;

	}

	public void open(int row, int col) {
		// open site (row, col) if it is not open already
		throwIfOutOfBounds(row, col);
		int index = convert(row, col);
		boolean top2 = false;
		boolean bottom2 = false;
		if (!isOpen(row, col)) {
			grid[index] = true;
			numberofopensites++;
			if(row==1){
				top2=true;
			}
			if(row==n){
				bottom2=true;
			}

			// top
			int newrow = row - 1;
			int newcol = col;
			int newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				if( top[UF.find(newindex)]){
					top2=true;
				}
				if( bottom[UF.find(newindex)]){
					bottom2=true;
				}
				UF.union(index, newindex);
				
			}
			// bottom
			newrow = row + 1;
			newcol = col;
			newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				if( top[UF.find(newindex)]){
					top2=true;
				}
				if( bottom[UF.find(newindex)]){
					bottom2=true;
				}
				UF.union(index, newindex);
				
			}
			// bottom
			newrow = row;
			newcol = col - 1;
			newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				if( top[UF.find(newindex)]){
					top2=true;
				}
				if( bottom[UF.find(newindex)]){
					bottom2=true;
				}
				UF.union(index, newindex);
				
			}
			// bottom
			newrow = row;
			newcol = col + 1;
			newindex = convert(newrow, newcol);
			if (inBoundsAndOpen(newrow, newcol)) {
				if( top[UF.find(newindex)]){
					top2=true;
				}
				if( bottom[UF.find(newindex)]){
					bottom2=true;
				}
				UF.union(index, newindex);
				
			}
			
			
			top[UF.find(index)] = top2;
			bottom[UF.find(index)] = bottom2;
			
			if(top[UF.find(index)] && bottom[UF.find(index)]){
				percolates = true;
			}

		}
	}

	public boolean isOpen(int row, int col) {
		throwIfOutOfBounds(row, col);
		return grid[convert(row, col)];
		// is site (row, col) open?
	}

	public boolean isFull(int row, int col) {
		throwIfOutOfBounds(row, col);
		// is site (row i, column j) full?
		// i.e. is site (i, j) connected to the top row?
		// is i, j connected to top site?
		return top[UF.find(convert(row, col))];
		// is site (row, col) full?
	}

	public int numberOfOpenSites() {
		return numberofopensites;
		// number of open sites
	}

	public boolean percolates() {
		return percolates;
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
