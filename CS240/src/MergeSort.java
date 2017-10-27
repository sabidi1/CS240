import java.util.Random;

/**
 *  Iterative Merge sort implementation
 *
 *  @author: Jayesh Chandrapal
 */



public class MergeSort
{  
    public static void main(String args[])
    {
    		int array[] = new int[10];
    		
    		Random randomObj = new Random();
    		
    		//This loop fills each element of the array with random numbers.
    		for (int q = 0; q < array.length; q++)
    		{
    			array[q] = randomObj.nextInt(1000);
    		}
    		
        System.out.println("Before Sorting: ");
        printArray(array);
        System.out.println("\nAfter Sorting: ");
        mergeSort(array);
        printArray(array);
        
        
        
    }
    
    public static void printArray(int[] array) {
        for(Integer num : array)
            System.out.print(num + " ");
        
    }
    
    public static void mergeSort(int[] array) {
        if(array == null) {
            return;
        }
        
        if(array.length > 1) {
            int mid = array.length / 2;		//spilit into 2 parts 
            
            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++) {
                left[i] = array[i];			//mid included
            }
            
            // Split right part
            int[] right = new int[array.length - mid];
            for(int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];			//mid not included
            }
            
            mergeSort(left);
            mergeSort(right);
            
            int i = 0;
            int j = 0;
            int k = 0;
            
            // Merge left and right arrays
            while(i < left.length && j < right.length) {
                if(left[i] < right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            
            // Collect remaining elements
            while(i < left.length) {
                array[k] = left[i];
                i++; k++;
            }
            
            while(j < right.length) {
                array[k] = right[j];
                j++; k++;
            }
        }
    }
}