package basictest;

import java.util.function.Predicate;

public class ClosureTest {

	
	public static void main(String[] args) {
		
		ClosureTest test = new ClosureTest();
		test.closureTest().test(null);
	}
	
	
	public Predicate<Object> closureTest(){
		
		int i = 10 ;
		
		Predicate<Object> p = (o) -> {
			
			System.out.println( i );  // here outer env variable is closed.
			return true;
		};
		
		
		// i++;   doesn't compile.  variable is used in closure
		
		return p;
		
	}
	
	/*
	 * function f(){

		    var i = 10;
		    
		    var p = () => {
		       console.log(i);
		    }
		    
		    i = 11;  // JS let's you do this. a closed variable can be modified in JS
		
		    return p;
		
		}
		
		var p = f()();
	 */
}
