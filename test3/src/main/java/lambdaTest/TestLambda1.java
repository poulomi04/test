package lambdaTest;


public class TestLambda1 {

	public static void main(String[] args) {
		System.out.println("Inside Main:" + Thread.currentThread());
	 	Runnable myRun=() -> System.out.println(Thread.currentThread());
	 	myRun.run();
	 	
	}
	
}
