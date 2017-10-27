import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String [] args) {
		
		int array[] = new int[10];
		populateArray(array);
		System.out.println("Before Sortinggg: ");
		printArray(array);
		//Select sort the array
		selectionSort(array);
		System.out.println("After Sorting: ");
		printArray(array);
	}
	
	public static int[] selectionSort(int [] arr) {
		for(int i = 0; i <arr.length -1; i++)
		{
			int minIndex = i;
			
			for(int j = i +1; j <arr.length; j++)
			{
				if(arr[j] < arr[minIndex])	//if minIndex greater
				{	
					minIndex = j;					// new minIndex = equals 
				}
			}
				//swap
				int smallerNumber = arr[i];	//smaller number = minIndex of array
				arr[i] = arr[minIndex];				// array minIndex
				arr[minIndex] = smallerNumber;
			
		}
		
		return arr;
	}
	
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
