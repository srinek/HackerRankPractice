package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompareParagraphs {

	// "This is Text", "This is"
	// "This is Text", "This new is"
	// "This is Text", "This Text is"
	// "This is Text", "This Text is"
	//"This is Text", "is Text"
	// "This is Text","These changes are added is Text This" -- fail
	// "This is Text", "Text added changes new"
	// "This is Text", "This is added changes new"
	

	/*public static void main(String[] args) {
		System.out.println(compare("This is Text", "This is"));
		System.out.println(compare("This is Text", "This new is"));
		//System.out.println(compare("This is Text", "This Text is"));  //fail
		System.out.println(compare("This is Text", "is Text")); 
		//System.out.println(compare("This is Text","These changes are added is Text This")); //fail
		//System.out.println(compare("This is Text","These changes are added is Text This"));
		System.out.println(compare("This is Text", "Text added changes new"));
		//System.out.println(compare("This is Text. The Text added here is for testing The This and is", "This is Text. people Text added here is for test of The This and is"));
	}*/
	public static void main(String[] args) {
		/*compare("This is Text", "This is");
		System.out.println(" ------------------- ");
		compare("This is Text", "This new is");
		System.out.println(" ------------------- ");
		compare("This is Text", "is Text");
		System.out.println(" ------------------- ");*/
		//compare("This is Text", "Text added changes new");
		//System.out.println(" ------------------- ");
		//compare("hello my name is", "hello is to my name");
		//compare("This is Text another is","These changes are added is Text This");
		//System.out.println(" ------------------- ");
		compare("This is Text. The Text added here is for testing The This and is", "This is Text. people Text added here is for test of The This and is");
	}
	private static String compare(String a, String b) {

    	if (a == null && b == null) {
			return null;
		}
		String[] as = a.trim().split(" ");
		String[] bs = b.trim().split(" ");
		BiDiMap biMap = new BiDiMap();
		comapreUtil(as, bs, as.length-1, bs.length-1, biMap);
		Map<Integer, String> deleteIndexes = new HashMap<>();
		for(int i = 0; i < as.length; i++){
			Integer destValue = biMap.getFromSrcKey(i);
			if(destValue == null){
				int key = i;
				while(deleteIndexes.get(key) != null){
					key++;
				}
				deleteIndexes.put(key, "<strike>"+as[i]+"</strike>");
			}
			else{
				while(deleteIndexes.get(destValue) != null){
					destValue++;
				}
				deleteIndexes.put(destValue, as[i]);
			}
		}
		Map<Integer, String> addIndexes = new HashMap<>();
		int prevKey = -1;
		for(int i = 0; i < bs.length; i++){
			Integer destValue = biMap.getFromRvrsKey(i);
			int key = ++prevKey;
			if(destValue == null){
				while(addIndexes.get(key) != null){
					key++;
				}
				addIndexes.put(key, "<u>"+bs[i]+"</u>");
			}
			else{
				while(addIndexes.get(destValue) != null){
					destValue++;
				}
				key = destValue;
				addIndexes.put(key, bs[i]);
			}
			prevKey = key;
		}
		System.out.println(deleteIndexes);
		System.out.println(addIndexes);
		List<String> finalList = new ArrayList<>();
		for(int i = 0; i < bs.length + as.length; i++){
			finalList.add(null);
		}
		Set<Integer> deleteKeys = deleteIndexes.keySet();
		for(Integer deleteKey : deleteKeys){
			finalList.add(deleteKey,  deleteIndexes.get(deleteKey));
		}
		Set<Integer> addKeys = addIndexes.keySet();
		for(Integer addKey : addKeys){
			if(finalList.get(addKey) == null){
				finalList.add(addKey,  addIndexes.get(addKey));
			}
			else if(!finalList.get(addKey).equals(addIndexes.get(addKey))){
				finalList.add(addKey,  addIndexes.get(addKey));
			}
			
		}
		
		System.out.println(finalList);
		//System.out.println(Arrays.toString(addList));
		return "";//mergeLists(deleteList, addList);
		

	}
	// "This is Text", "This is"
	private static void comapreUtil(String[] as, String[] bs, int length, int length2, BiDiMap biMap) {
		if (length < 0 && length2 < 0) {
			return;
		}
		if (length < 0) {
			/*if(list.get(length2) == null){
				list.put(length2, "<u>" + bs[length2] + "</u>");
			}*/
			return;
		}
		if (length2 < 0) {
			//addkey(as, length, list);
			return;
		}
		if (as[length].equalsIgnoreCase(bs[length2])) {
			/*if(addList[length2] == null){
				addList[length2] =  bs[length2];
			}
			if(deleteList[length] == null){
				deleteList[length] = as[length];
			}*/
			biMap.addValue(length, length2);
			comapreUtil(as, bs, length - 1, length2 - 1, biMap);
		} else {
			comapreUtil(as, bs, length - 1, length2, biMap);
			comapreUtil(as, bs, length, length2 - 1, biMap);
		}
	}
	private static void addkey(String[] as, int length, Map<Integer, String> list) {
		if(list.values().contains(as[length])){
			return;
		}
	    Integer key = length;
		while(list.get(key) != null){
		    key++;
		}
		list.put(key, "<strike>" + as[length] + "</strike>");
	}
	
	static class BiDiMap{
		
		Map<Integer, Integer> fwdMap = new HashMap<>();
		Map<Integer, Integer> rvrsMap = new HashMap<>();
		
		public BiDiMap() {
			
		}
		
		public void addValue(int srcInde, int destIndex){
			fwdMap.put(srcInde, destIndex);
			rvrsMap.put(destIndex, srcInde);
		}
		
		public Integer getFromSrcKey(int src){
			return fwdMap.get(src);
		}
		
		public Integer getFromRvrsKey(int dest){
			return rvrsMap.get(dest);
		}
	}
}