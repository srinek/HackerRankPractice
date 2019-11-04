package basictest;

public class LazyClassLoading {

	
	static {
		System.out.println("static block - class is loading when it is imported");
	}
	
	public static LazyClassLoading getInstance(){
		return new LazyClassLoading();
	}
}
