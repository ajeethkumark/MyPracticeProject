package test;

import java.math.BigDecimal;

public class BigDecimalTest {
	
	public static void main(String[] arg)
	{
		// Creating a Long Object
        Long ln = new Long("789654");
        BigDecimal income=new BigDecimal(1730.67);
  
        // Assigning the bigdecimal value of ln to BigDecimal b
        // with scale 3
        BigDecimal b = BigDecimal.valueOf(1);
  
        // Displaying the BigDecimal value
        System.out.println("The BigDecimal value is " + b);
        System.out.println("output:"+income.divide(b,2,BigDecimal.ROUND_DOWN));
        
        
	}

}
