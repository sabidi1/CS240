

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		//fixed sized array of 10
		int array[] = new int[10];
		populateArray(array);
		System.out.println("Before Sorting: ");
		printArray(array);
		// sort the array
		insertionSort(array);
		System.out.println("\nAfter Sorting: ");
		printArray(array);
	}

	/**
	 * This method will sort the integer array using insertion sort in java algorithim
	 * @param arr
	 */
	private static int[] insertionSort(int[] arr) {
		int i,j,valueToSort;
		for ( i = 1; i < arr.length; i++) { 	//i up to the length of the list
			valueToSort = arr[i];		//valueToSort is index of Array
			
			//Move elements of arr if they are smaller than the valuetoSort
			//J equals index of array -1
			for( j = i -1; j>=0 && valueToSort < arr[j]; j--)
				arr[j+1] = arr[j ]; 		//put element one behind
				arr[j+1] = valueToSort;	
			}
			return arr;
		}


	
	//printArray method to show the two arrays
	public static void printArray(int[] A) {
		System.out.println(Arrays.toString(A));
	}

		//Random numbers to populate array of 10
	public static void populateArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = (int) (Math.random() * 100);
		}
	}
}