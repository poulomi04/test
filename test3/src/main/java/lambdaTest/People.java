package lambdaTest;

public class People {
//to test branch rules in github
//now added a rule to master
	String id;
	String firstName;
	String lastName;
	int age;
	
	
	
	public People() {
	}
	public People(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public People(String id,String firstName, String lastName, int age) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "People [id:" +id + ",firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]" ;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLaastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
