import java.util.Arrays;



public class ShellSortIT {
		
	
	
		public static int arraySize = 10;
		public static int[ ] array = new int[arraySize];
		
		
		public static void main(String[] args)
		{
			populateArray(array);
			System.out.println("Before sorting: ");
			printArray(array);
			//Select sort the array
			shellSort(array);
			System.out.println("After Sorting: ");
			printArray(array);
			
		}
		
		
		
	    public static void shellSort(int [] array) 
	    {
	        int increment = array.length / 2;
	        while (increment > 0) 
	        {
	            for (int i = increment; i < array.length; i++) 
	            {
	                int j = i;
	                int temp = array[i];
	                while (j >= increment && array[j - increment] > temp) 
	                {
	                    array[j] = array[j - increment];
	                    j = j - increment;
	                }
	                array[j] = temp;
	            }
	            if (increment == 2)
	                increment = 1;
	            else
	                increment *= (5.0 / 11);
	 
	        }
	    }
	    
	    public static void printArray(int[] A) {
			System.out.println(Arrays.toString(A))
			;
		}
	    public static void populateArray(int[] A) {
			for (int i = 0; i < A.length; i++) {
				A[i] = (int) (Math.random() * 100);
			}
	    }
}