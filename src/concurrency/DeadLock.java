

/*

package concurrency;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DeadLock{

	private List<String> mutex = new ArrayList<>();
	
	public void add(String a){
		synchronized (mutex) {
			if(a.equals("c")){
				remove(a);
			}
			else{
				mutex.add(a);
			}
		}
	}
	
	public void remove(String a){
		synchronized (mutex) {
			if(mutex.contains(a)){
				mutex.remove(a);
			}
			else{
				Executor e = Executors.newSingleThreadExecutor();
				e.execute(new Runnable() {
					
					@Override
					public void run() {
						add(a);
						
					}
				});
				
			}
		}
	}
	
}*/

package concurrency;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock{

	Lock locka = new ReentrantLock();
	Lock lockb = new ReentrantLock();
	
	public void methodA(){
		
		try{
			System.out.println( "entered in methodA");
			locka.lock();
			
			Thread.sleep(1000);
			System.out.println( "waiting in methodA for lockB");
			lockb.lock();
			
			
			System.out.println( "done in methodA");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
		
			lockb.unlock();
			locka.unlock();
			System.out.println( "unlocking methodA");
		}
	}
	
	public void methodB(){
		
		try{
			System.out.println( "entered in methodB");
			lockb.lock();
			Thread.sleep(1000);
			System.out.println( "waiting in methodA for lockA");
			locka.lock();
			
			System.out.println( "done in methodB");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
		
			locka.unlock();
			lockb.unlock();
			System.out.println( "unlocking methodB");
		}
	}
	
	
	public static void main(String[] args){
		
		DeadLock deadLock = new DeadLock();
		
		Thread t1 = new Thread( () -> {deadLock.methodA();});
		Thread t2 = new Thread( () -> {deadLock.methodB();});
		t1.start();
		t2.start();
	}

}