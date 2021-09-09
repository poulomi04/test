package lambdaTest;

import java.util.function.Predicate;

public class TL7CapturingLambda {

	public static void main(String[] args) {
		new TL7CapturingLambda().capturingLamdaTest("poulomi");
	}
	
	//the lambda exp gets the refernce of the myName String which is called capturing lambda
	public void capturingLamdaTest(String myName) {
		//myName=""; this cannot be done as myName must be effectively final
		//local variables are treated as immutable as they exist on stack as opposed to heap for instance hence they are 
		//thread safe. as no other thread can access to the stack apart from the thread itself.
		//there may be a situation where a lambda is still running although the thread 
		//that created it is recycled hence lambda is required to capture the value of these local variables
		//so compiler will not allow us to change
		//but this does not apply to instance variables.. but recommendation is to not change even instance variables/
		Predicate<String> predicate=(s) -> s.equalsIgnoreCase(myName);
		System.out.println("Match found:" +predicate.test("Poulomi"));
	}
}
