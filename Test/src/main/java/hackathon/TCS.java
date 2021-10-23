package hackathon;

import java.util.ArrayList;

public class TCS {
	
	public static void main(String[] arg)
	/*
	 * N --> No of data which will assign to 1 initially
	 * M --> No of input -->B[]
	 */
	{
		int[] data= {1,1,1,1,1,1};
		int multiplyBy=0;
		int B[]= {2,2,1}; 
		
		for(int i=0;i<B.length;i++)
		{
			++multiplyBy;
			ArrayList<Integer> positions=null;
			positions=positionToBeUpdate(positions,B[i],data);
			arrayResult(positions);
			for(int j=0;j<positions.size();j++)
			{
				//System.out.println("j--:"+j);
				data[positions.get(j)]=data[positions.get(j)]*multiplyBy;
			}
		}
		
		printResult(data);
		//136363
		//636363
	}

	private static void arrayResult(ArrayList<Integer> positions) {
		// TODO Auto-generated method stub
		System.out.println("--------start------");
		for(int i:positions)
			System.out.print(i);
		
		System.out.println("--------***End*****------");
	}

	private static void printResult(int[] b) {
		// TODO Auto-generated method stub
		System.out.println("Final Result:\n");
		for(int i:b)
			System.out.print(i);
		
	}

	private static ArrayList<Integer> positionToBeUpdate(ArrayList<Integer> positions, int index,int[] data) {
		// TODO Auto-generated method stub
		positions=new ArrayList<Integer>();
		for(int i=0;i<data.length;i++)
		{
			if((i%index)!=0 || index==1)
			{
				System.out.println("ll:"+i);
				positions.add(i);
			}
		}
		return positions;
		
		
	}

}
