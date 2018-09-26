package javacodes;

public class ArrayShiftZero {
	
	private int dataArray[];
	
	public ArrayShiftZero(int[] dataArray) {
		this.dataArray = dataArray;
	}
	
	/*
	 * Shift all the 0's to the right of array
	 */
	public int[] shiftArray() {
		int firstIndex = 0;
		int lastIndex = this.dataArray.length - 1;
		for(int i = 0; i < (this.dataArray.length) - 1; i++) {
			if(firstIndex >= lastIndex) break;
			if(dataArray[firstIndex] == 0 && dataArray[lastIndex] != 0) {
				swap(firstIndex, lastIndex);
				firstIndex++;
				lastIndex--;
			} else if (dataArray[firstIndex] != 0 && dataArray[lastIndex] == 0) {
				firstIndex++;
			} else if (dataArray[firstIndex] != 0 && dataArray[lastIndex] != 0) {
				firstIndex++;
			} else {
				lastIndex--;
			}
		}
		return this.dataArray;
	}

	private void swap(int i, int j) {
		int temp = this.dataArray[i];
		this.dataArray[i] = this.dataArray[j];
		this.dataArray[j] = temp; 
	}
	
	public static void main(String args[]) {
		int[] dataArray = {3,1,9,2,0,3,5,5,7,0,0,0};
		ArrayShiftZero shift = new ArrayShiftZero(dataArray);
		dataArray = shift.shiftArray();
		for(int i=0; i< dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
	}	
}
