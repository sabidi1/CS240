
/**
	A radix sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	
*/

import java.util.Random;

public class RadixSortIter
{
	public static void main(String[] args)
	{
		int[] array = new int[10];
		int[] temp = new int[array.length]; //Creates a temporary array to hold sorted data
		
		Random randomObj = new Random();
		
		System.out.println("Before Sort");
		//This loop fills each element of the array with random numbers.
		for (int q = 0; q < array.length; q++)
		{
			array[q] = randomObj.nextInt(1000);
			System.out.print(array[q] + " ");
		}
		
		
		System.out.println("\n After sort");
		
		//Sorts the items according to the 1's place based on the temporary array 
		//stores it in the temporary array
		int m = 0;
		for (int i = 0; i < 10; i++)
		{
			for (int q = 0; q < array.length; q++)
			{
				if (array[q]%10 == i)
				{
					temp[m] = array[q];
					m++;
				}
			}
		}
		
		//Sorts the items in the 10's places based temporary array
		//stores it back in the array
		int z = 0;
		for (int i = 0; i < 10; i++)
		{
			for (int q = 0; q < array.length; q++)
			{
				if (((temp[q]%100)/10) == i)
				{
					array[z] = temp[q];
					z++;
				}
			}
		}
		
		//Sorts the items according to the 100's place 
		//stores it in the temporary array
		int b = 0;
		for (int i = 0; i < 10; i++)
		{
			for (int q = 0; q < array.length; q++)
			{
				if ((array[q]/100) == i)
				{
					temp[b] = array[q];
					b++;
				}
			}
		}
		
		
		//This loop prints out the sorted array.
		for (int a = 0; a < temp.length; a++)
		{
			System.out.print(temp[a] + " ");
		}
	}
}