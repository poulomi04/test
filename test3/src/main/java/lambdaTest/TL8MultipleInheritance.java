package lambdaTest;

interface Animal{
	default public String call() {
		return "Animal Calls";
	}
}

interface Dog extends Animal{
	default public String call() {
		return "Dog Barks";
	}
}

//multiple inheritance
public class TL8MultipleInheritance implements Animal,Dog{
	//compiler will not complain as long as this class has its own implementation of call()
	public String call() {
		//return "All animals call";
		return Dog.super.call();
	}
	 public static void main(String[] args) {
		System.out.println(new TL8MultipleInheritance().call());
	}
}
