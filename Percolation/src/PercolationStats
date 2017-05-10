import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int experimentsCount;
    private Percolation pr;
    private double[] fractions;

    public PercolationStats(int N, int T) {
    	throwIfOutOfBounds(N, T);
        experimentsCount = T;
        fractions = new double[experimentsCount];
        for (int expNum = 0; expNum < experimentsCount; expNum++) {
            pr = new Percolation(N);
            int openedSites = 0;
            while (!pr.percolates()) {
                int i = StdRandom.uniform(1, N + 1);
                int j = StdRandom.uniform(1, N + 1);
                if (!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
            }
            double fraction = (double) openedSites / (N * N);
            fractions[expNum] = fraction;
        }
    }

	public double mean() {
		return StdStats.mean(fractions);
		// sample mean of percolation threshold
	}

	public double stddev() {
		return StdStats.stddev(fractions);
		// sample standard deviation of percolation threshold
	}

	public double confidenceLo() {
		 return mean() - ((1.96 * stddev()) / Math.sqrt(experimentsCount));
		// low endpoint of 95% confidence interval
	}

	public double confidenceHi() {
	     return mean() + ((1.96 * stddev()) / Math.sqrt(experimentsCount));
		// high endpoint of 95% confidence interval
	}

	   public static void main(String[] args) {
	        int N = 200;
	        int T = 100;
	        PercolationStats ps = new PercolationStats(N, T);

	        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
	        StdOut.println("mean                    = " + ps.mean());
	        StdOut.println("stddev                  = " + ps.stddev());
	        StdOut.println("95% confidence interval = " + confidence);
	    }

	private void throwIfOutOfBounds(int n, int trials) {
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException(" n < 0 or trials < 0");
		}
	}

}
