package graphs;

/*
 * https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
 */
public class CircleOfStrings {
	
	public static void main(String[] args) {
		String[] input = new String[]{"abc", "efg", "cde", "ghi", "ija"};
		System.out.println( CircleOfStrings.hasCircle(input));
	}

	public static boolean  hasCircle(String[] strings){
		
		boolean ret = true;
		
		Graph<Character> g = new Graph<>();
		/*for(Character c : charArr){
			vList.add(g.createVertex(c));
		}*/
		Vertex<Character> v1 = null, v2 = null ;
		for(String str : strings){
			
			if(str.length() > 2){
				v1 = g.createVertex(str.charAt(0));
				v2 = g.createVertex(str.charAt(str.length() - 1));
				g.addEdge(v1, 0, v2);
			}
		}
		
		if(g.isStronglyConnectedComponent()){
			
			for(Vertex<Character> v : g.getVertexList()){
				if(v.getOutDegree() != v.getInDegree()){
					ret = false;
					break;
				}
			}
		}
		else{
			ret = false;
		}
		return ret;
		
	}
}
