package algorithm;

public class BubbleSort {
	
	public static void main(String[] arg)
	{
		
		int[] arr= {5,3,1,6,22,9,8,2,4};
		int temp=0;
		
		/*
		 * In bubble sort sort last position will be replaced with largest value and 
		 * consecutive positions are updating with largest value accordingly
		 * 
		 * Finally we will get sorted array
		 */
		
		
		int n=arr.length;
		long startTime=System.currentTimeMillis();
		
		   for(int i=0; i < n; i++){  
			   
            for(int j=1; j < (n-i); j++){  
                     if(arr[j-1] > arr[j]){  
                            //swap elements  
                            temp = arr[j-1];  
                            arr[j-1] = arr[j];  
                            arr[j] = temp;  
                            for(int p:arr)
                         	   System.out.print(p+"  ");
                    }  
               //  System.out.println("\n*********************************j:"+j);
                     
            }  
            //System.out.println("\n--------------------------------------i:"+i);
    }  
		   long endTime=System.currentTimeMillis();
		   System.out.println("startTime:"+startTime+"   endTime:"+endTime+"Total Time to processed:"+(startTime-endTime));
		   
		   for(int i:arr)
				System.out.println("bubble Sorte Array:"+i); 
		
	}

}
