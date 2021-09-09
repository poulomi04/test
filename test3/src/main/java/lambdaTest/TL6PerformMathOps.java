package lambdaTest;

public class TL6PerformMathOps {

	interface MathOperable{
		double operate(int a,int b);
	}
	
	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		MathOperable mathOperable = (p,q) -> p+q;
		System.out.println("Sum is:" + mathOperable.operate(a, b));
		
		mathOperable = (p,q) -> p-q;
		System.out.println("Diff is:" + mathOperable.operate(a, b));
		
		mathOperable = (p,q) -> p*q;
		System.out.println("Product is:" + mathOperable.operate(a, b));
		
		if(b!=0) {
			mathOperable = (p,q) -> p/q;
			System.out.println("Quotient is:" + mathOperable.operate(a, b));
			
		}
	}

}
