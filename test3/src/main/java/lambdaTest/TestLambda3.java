package lambdaTest;

import java.util.function.Consumer;

public class TestLambda3 {

	public static void main(String[] args) {
		new TestLambda3().test("Poulomi",(s)-> System.out.println("Hello " +s));
	}
	
	public void test(String s,Consumer<String> consumer) {
		consumer.accept(s);
		}
	
}
