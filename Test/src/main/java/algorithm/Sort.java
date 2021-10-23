package algorithm;

public class Sort {
	
	public static void main(String[] arg)
	{
		int[] arr= {44,33,32,24,12,11,2};
		int temp=0;
		
		/*
		 * In Normal sort first position will be replaced with small value and 
		 * consecutive values are updating with small value
		 * 
		 * Finally we will get sorted array
		 */
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i:arr)
			System.out.println("Sorted Array:"+i); 
		
		
		
		
	}

}
