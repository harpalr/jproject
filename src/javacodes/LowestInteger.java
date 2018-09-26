package javacodes;

/*
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * 
 * [3, 6, -1, 1, 4, 2, 7, 3]
 * 
 * [0, 6, 3, 1, 4, 2, 7, 3]
 * [0, 2, 3, 1, 4, 6, 7, 3]
 * [0, 2, 3, 1, 4, 6, 7, 3]
 * [1, 2, 3, 0, 4, 6, 7, 3]
 * [1, 2, 3, 4, 0, 6, 7, 3]
 * [1, 2, 3, 4, 0, 6, 7, 0]
 * 
 * [1, 2, 0]
 * [1, 2, 0]
 * [1, 2, 0]
 * [1, 2, 0]
 * 
 * [3, 4, -1, 1]
 * [0, 4, 3, 1]
 * [1, 0, 3, 4]
 * [0, 1, 3, 4]
 * 
 * 
  */

public class LowestInteger {
	
	private int[] intArray;
	private int[] sortedArray;
	
	public LowestInteger(int[] intArray) {
		this.intArray = intArray;
	}
	
	public int findLowestInteger() {
		
		int lowintvalue = 0;
		int firstIndex = 0;
		int secondIndex = 0;
		int secondIndexvalue = 0;
		
		
		if(this.intArray.length == 0) return 0;
		sortedArray = new int[this.intArray.length];
		
		for(int i = 0; i < intArray.length; i++) {
			
			firstIndex = i + 1;
			//secondIndex = i + 2;
			
			int firstValue = intArray[i];
			int pointerValue = intArray[firstValue];
			
			if(firstValue < 1) {
				intArray[i] = 0;
			}
			
			//if(firstValue > 0 && (pointerValue < )) 
			
			if(intArray[firstIndex] > 0) {
				secondIndexvalue = intArray[i] - 1;
				
				
			} else {
				intArray[i] = 0;
			}
			
			
			
			
			
			if(intArray[i] > 0) {
				sortedArray[intArray[i] - 1] = intArray[i];				
			}
			
		}
		
		
		for(int i = 0; i < sortedArray.length; i++) {
			if(sortedArray[i] == 0) return i + 1; 
		}
		
		return lowintvalue;
	}
	
	private int getMin(int a, int b) {
		
		if(a < 1 && b > 0) return b;
		if(b < 1 && a > 0) return a;
		if(a < b) return b;
		return a;
		
	}
	
	public static void main(String[] args) {
		int[] intArray = {3, 6, -1, 1, 4, 2, 7, 3};
		LowestInteger li = new LowestInteger(intArray);
		int value = li.findLowestInteger();
		System.out.println(value);
	}

}
