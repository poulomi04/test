package lambdaTest;

public class TL5AddTwoNumbers {

	
	interface Addable{
		int add(int a,int b);
	}
	
	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		Addable addable=(p,q) -> p+q;
		System.out.println("Sum is :"+ addable.add(a, b));
	}
}
