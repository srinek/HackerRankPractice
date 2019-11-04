package basictest;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MapTest {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Map<String, String> singletonMap = Collections.singletonMap("one", "1");
		
		// System.out.println( singletonMap);
		
		Map<SimpleObject, String> mapTest = new HashMap<>();
		
		Map<WeakReference<SimpleObject>, String> weakMapTest = new WeakHashMap<>();
		
		SimpleObject key1 = new SimpleObject(1);
		
		mapTest.put(key1, "val1");
		
		weakMapTest.put(new WeakReference<SimpleObject>(key1), "val1");
		
		key1 = null;
		
		System.gc();
		
		
		System.out.println( mapTest.size() +"  "+weakMapTest.size());
		
	}
	
	public static class SimpleObject{
		
		public int val;
		
		public SimpleObject(int val){
			this.val = val;
		}
	}
	

}
