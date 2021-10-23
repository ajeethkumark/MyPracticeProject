package algorithm;

public class Quicksort {
	
	public static void main(String[] arg)
	{
		int[] arr= {5,3,1,6,22,9,8,2,4};
		Quicksort qs=new Quicksort();
		long startTime=System.currentTimeMillis();
		
		qs.quickSort(arr,0,arr.length-1);
		long endTime=System.currentTimeMillis();
		System.out.println("startTime:"+startTime+"   endTime:"+endTime+"Total Time to processed:"+(startTime-endTime));
		qs.print(arr);
	}
public void quickSort(int[] arr,int low,int high)
{
	if(low<high)
	{
		int pi=partition(arr,low,high);
		quickSort(arr,low,pi-1);
		quickSort(arr,pi+1,high);
	}
}

public int partition(int[] arr,int low,int high)
{
	
	int i=low-1;
	int pivot=arr[high];
	for(int j=low;j<=high;j++)
	{
		if(arr[j]<pivot)
		{
			i++;
			swap(arr,low,j);
			low++;
			
		}
	}
	swap(arr,low,high);
	
	
	return low;
}

public void swap(int[] arr,int i,int j)
{
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
	
}

public void print(int[] arr)
{
	for(int i:arr)
		System.out.println(i);
}

}
