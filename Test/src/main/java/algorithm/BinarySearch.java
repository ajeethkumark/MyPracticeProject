package algorithm;

public class BinarySearch {
	
	public static void main(String[] arg)
	{
		int[] arr= {1,2,3,4,5,6,7,8,9};
		
		int n=arr.length;
		int start=0;
		int end=n-1;
		int key=8;
		int value=binarySearch(arr,start,end,key);
		if(value!=-1)
			System.out.println("Key found at "+value+" position");
		else
			System.out.println("Key not found");
	}

	private static int binarySearch(int[] arr, int start, int end,int key) {
		// TODO Auto-generated method stub
		int mid;
		System.out.println("start---");
		
		while(start<end)
		{
			mid=((start+end)/2);
			System.out.println("Mid:"+mid);
			
			if(key==arr[mid])
				return mid;
			else if(key < arr[mid])
			{
				end=mid-1;
			}
			else 
				start=mid+1;
		}
		
		System.out.println("End---");
		return -1;
		
	}

}
