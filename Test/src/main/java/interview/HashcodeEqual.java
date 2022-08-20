package interview;

import java.util.HashMap;

public class HashcodeEqual {
	
	/*
	 * As per my observation, it will go to the hashcode first if it not unique then then it will go to equal method and check and eliminate duplicate
	 * hashcode retun int,equals return boolean
	 * if equals method return true then it mean duplicate
	 * 
	 */
	
	public static void main(String[] arg)
	{
		//System.out.println("Testing1...");
		Student s1=new Student();
		s1.setName("AAA");
		s1.setRollNo(1);
		s1.setHeight(72);
		s1.setWeight(50);
		
		//System.out.println("Testing2...");
		Student s2=new Student();
		s2.setName("BBB");
		s2.setRollNo(2);
		s2.setHeight(72);
		s2.setWeight(50);
		
		
		//System.out.println("Testing3...");
		Student s3=new Student();
		s3.setName("CCC");
		s3.setRollNo(3);
		s3.setHeight(72);
		s3.setWeight(50);
		
		HashMap<Student,String> hashMap=new HashMap<Student,String>();
		hashMap.put(s1, "AAA");
		System.out.println("AAA over...");
		hashMap.put(s2, "BBB");
		
		System.out.println("BBB over...");
		
		hashMap.put(s3, "CCC");
		System.out.println("CCC over...");
		
		System.out.println("HashMap result:"+hashMap.size());
		
	}

}

class Student
{
	String name;
	int rollNo;
	int height;
	int weight;
	@Override
	public int hashCode() {
		System.out.println("Entering to hashCode()");
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollNo;
		result = prime * result + weight;
		System.out.println("resut:"+result);
		//return result;
		return 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Entering to equal...");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
}
