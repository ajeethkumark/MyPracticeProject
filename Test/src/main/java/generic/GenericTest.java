package generic;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String> g1=new Gen<String>("durga");
		g1.show();
		System.out.println("Get object:"+g1.getObject());
		
		Gen<Integer> g2=new Gen<Integer>(10);
		g2.show();
		System.out.println("Get object:"+g2.getObject());
		

	}

}
