package sample;

public class CountStringWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="Testtess";
		int flag=0;
		int[] array=new int[data.length()];
		char[] charArray=new char[data.length()];
		int count=0;
		for(int i=0;i<array.length;i++)
		{
			array[i]=0;
		}
		for(int i=0;i<array.length;i++)
		{
			if(count==0)
			{
				charArray[count]=data.charAt(i);				
				array[count]++;				
				count++;
			}
			else
			{
				for(int j=0;j<count;j++)
				{
					if(data.charAt(i)==charArray[j])
					{
						array[j]++;
						flag=1;
					}
				}
				if(flag!=1)
				{
					charArray[count]=data.charAt(i);
					array[count]++;
					count++;
					flag=0;
				}
			}
		}
		System.out.println("Validation over:");
		for(int x=0;x<count;x++)
		{
			System.out.println("character:"+charArray[x]+"       Number of count:"+array[x]);
		}
		
		

	}

}
