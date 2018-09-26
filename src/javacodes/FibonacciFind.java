package javacodes;

public class FibonacciFind {

	int findValueAtPositionFibonacci (int position) {
		int last = 0, slast = 0;
		int pointer = 1;
		int temp;
		if(position == 1) return last;
		while(pointer <= position) {
			if(pointer < 2) { 
				slast = last;
				last = pointer;
			} else {
				temp = last;
				last = last + slast;
				slast = temp; 
			}
			pointer++;
		}
		return last;
	}
	
	int findValueAtPositionFibonacci2 (int position) {
		int last = 0, slast = 0;
		int pointer = 1;
		int temp;
		if(position == 1) return last;
		while(pointer <= position) {
			if(pointer < 2) { 
				slast = last;
				last = pointer;
			} else {
				temp = last;
				last = last + slast;
				slast = temp; 
			}
			pointer++;
		}
		return last;
	}
	
	public static void main(String args[]) {
		FibonacciFind fib = new FibonacciFind();
		System.out.println(fib.findValueAtPositionFibonacci(25));
	}	
	
}

