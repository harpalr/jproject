package javacodes;

public class MatrixLargestSquare {
	
	public int[][] matrix;
	public int[][] matrixClone;
	public int result = 0;
	
	public MatrixLargestSquare(int[][] matrix) {
		this.matrix = matrix;
		this.matrixClone = matrix.clone();
	}
	
	/*
	 * Approach is consider the current as bottom right of the 2 x 2 square
	 * Method is to find the min in adjacent and add it to the value of present index
	 */
	
	public int findLargestSquare() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(i == 0 || j == 0) {
				} else {
					this.matrix[i][j] += this.findMin(this.matrix[i-1][j], this.matrix[i][j-1], this.matrix[i-1][j-1]);
					if(this.matrix[i][j] > this.result) this.result = this.matrix[i][j];
				}
			}
		}
		return this.result;
	}
	
	private int findMin(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
	
	void printArray(){
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print("(i = " + i + ", j = " + j + ") " + matrix[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String args[]) {
		int[][] matrix = {{0,1,1,0}, {1,1,1,1}, {0,1,1,1}, {0,1,1,1}};
		MatrixLargestSquare mSquare = new MatrixLargestSquare(matrix);
		mSquare.printArray();
		System.out.println(mSquare.findLargestSquare());
	}

}
