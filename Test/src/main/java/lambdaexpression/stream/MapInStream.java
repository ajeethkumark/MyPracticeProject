package lambdaexpression.stream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapInStream {
	public static void main(String[] arg)
	{
		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

        System.out.println("Imperative Style: ");

        for (String name : names) {
            if (!name.equals("Sam")) {
                User user = new User(name);
                System.out.println(user);
            }
        }

        System.out.println("Functional Style: ");
       

        names.stream()
                .filter(MapInStream::isNotSam)
                .map(name->new User(name))
                .forEach(System.out::println);

        List<User> userList = names.stream()
                .filter(MapInStream::isNotSam)
                .map(User::new)
                .collect(Collectors.toList());
        
        System.out.println("..............");
        userList.forEach(t->System.out.println("name:"+t.getName()+" Age:"+t.getAge()));
        
        
        
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        
        Map<Integer,String> mapTest=HOSTING.entrySet().stream().filter(x->x.getValue()!="linode.com").collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println("Map..........:"+mapTest);
        
     List<Integer> mapTest2=  mapTest.entrySet().stream().filter(x->x.getKey()==2).map(x->x.getKey()*3).collect(Collectors.toList());
     System.out.println("List:"+mapTest2);
        

        
	}
	 private static boolean isNotSam(String name) {
	        return !name.equals("Sam");
	    }


	    static class User {
	        private String name;
	        private Integer age = 30;

	        public User(String name) {
	            this.name = name;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public Integer getAge() {
	            return age;
	        }

	        public void setAge(Integer age) {
	            this.age = age;
	        }

	        @Override
	        public String toString() {
	            return "name : " + name + " age : " + age;
	        }  
	    }

}
