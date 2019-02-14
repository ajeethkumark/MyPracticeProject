package defensivecode;

public class DefensiveCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "ajeeth";
		 
		data = null;
		 
		if(!"".equals(data)){
		    // do something 
			System.out.println("Entering..1");
		} else {
		    // do something else
			System.out.println("Not Enter1");
		}
		 

		if(!data.equals("")){
		    // do something 
			System.out.println("Enter2");
		} else {
		    // do something else
			System.out.println("Not Enter2");
		}  
		 

	}

}
