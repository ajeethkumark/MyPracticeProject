package algorithm;

public class QuickSort {
	
	// Driver Code
	public static void main(String[] args)
	{
	    int[] arr = { 10, 7, 8, 9, 1, 5 };
	    int n = arr.length;
	      
	    quickSort(arr, 0, n - 1);
	    System.out.println("Sorted array: ");
	    printArray(arr, n);
	}
	
	
	// Function to print an array 
	static void printArray(int[] arr, int size)
	{
	    for(int i = 0; i < size; i++)
	        System.out.print(arr[i] + " ");
	          
	    System.out.println();
	}
	
	
	/* The main function that implements QuickSort
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index
*/
static void quickSort(int[] arr, int low, int high)
{
	
	System.out.println("quicksort********:low---:"+low+"****hight:"+high);
if (low < high) 
{
    
  // pi is partitioning index, arr[p]
  // is now at right place 
	System.out.println("quicksort-----:low---:"+low);
  int pi = partition(arr, low, high);

  // Separately sort elements before
  // partition and after partition
  quickSort(arr, low, pi - 1);
  quickSort(arr, pi + 1, high);
}
}


/* This function takes last element as pivot, places
the pivot element at its correct position in sorted
array, and places all smaller (smaller than pivot)
to left of pivot and all greater elements to right
of pivot */
static int partition(int[] arr, int low, int high)
{
   
 // pivot
 int pivot = arr[high]; 
 
 //System.out.println("partition---low:-----"+low);
   
 // Index of smaller element and
 // indicates the right position
 // of pivot found so far
 int i = (low - 1); 

 for(int j = low; j <= high - 1; j++)
 {
	 
	 //System.out.println("partition---j------:"+j+"--arr[j] -------:"+arr[j]);
       
     // If current element is smaller 
     // than the pivot
     if (arr[j] < pivot) 
     {
           
         // Increment index of 
         // smaller element
         i++; 
         swap(arr, i, j);
     }
 }
 System.out.println("left partition completed:-----------");
 printArray(arr,arr.length);
 System.out.println("Above is the left partition data:"+i+1+"---high:"+high);
 
 
 swap(arr, i + 1, high);
 return (i + 1);
}

//A utility function to swap two elements
static void swap(int[] arr, int i, int j)
{
 int temp = arr[i];
 arr[i] = arr[j];
 arr[j] = temp;
 System.out.println("After sort*****");
 printArray(arr,arr.length);
 
}


}
