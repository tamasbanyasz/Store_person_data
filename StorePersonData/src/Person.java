
public class Person {
	
	/*
	 * 
	 * Person class with the two value.
	 * 
	 * 
	 * 
	 */
	
	private String age;
	private String name;
	
	
	public Person(String age, String name) {
		this.age = age;
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}
