package basictest;

public class Singleton {

	
	private Singleton(){
		
	}
	
	public static Singleton getIntance(){
		return SingletonHolder.instance;
	}
	
	private static class SingletonHolder{
		
		private static Singleton instance = new Singleton();
	}
}
