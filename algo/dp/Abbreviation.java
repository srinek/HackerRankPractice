package algo.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abbreviation {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		int index = 0;
		while(index++ < q){
			String a = scan.next();
			String b = scan.next();
			System.out.println(findMatch(a, b));
		}
		scan.close();
		
	}
	
	/*daBcd
	ABC*/
	private static String findMatch(String a, String b){
		Map<Integer, Boolean> matchMap = new HashMap<>();
		compare(a, b, a.length()-1, b.length() -1, matchMap);
		if(matchMap.size() < b.length()){
			return "NO";
		}
		char[] chars = b.toCharArray();
		for(int i = 0; i < chars.length; i++){
			if(!matchMap.get(i)){
				return "NO";
			}
		}
		return "YES";
		
	}

	
	private static boolean compare(String a, String b, int a_index, int b_index, Map<Integer, Boolean> matchMap) {
		if(a_index < 0 || b_index < 0){
			return false;
		}
		char chara = a.charAt(a_index);
		char charb = b.charAt(b_index);
		if(isLowerCase(chara)){
			char upperCase_a = Character.toUpperCase(chara);
			if(matchMap.get(b_index) != null && matchMap.get(b_index)){
				return compare(a, b, a_index, b_index-1, matchMap);
			}
			else if(upperCase_a == charb){
				matchMap.put(b_index, true);
			} 
			return compare(a, b, a_index-1, b_index, matchMap);
		}
		else{
			boolean matched = false;
			if(chara == charb){
				if(matchMap.get(b_index) != null){
					matched = matchMap.get(b_index);
					if(matched){
						char prevChar = b.charAt(b_index - 1);
						if(prevChar == chara){
							return compare(a, b, a_index, b_index-1, matchMap);
						}
					}
				}
				matchMap.put(b_index, true);
				return compare(a, b, a_index-1, b_index-1, matchMap);
			}
			if(matchMap.get(b_index) != null){
				matched = matchMap.get(b_index);
			}
			if(matched){//already matched, do a greedy match
			    	return compare(a, b, a_index, b_index-1, matchMap);
			}
			matchMap.put(b_index, false);
			return false;
		}

	}

	private static boolean isLowerCase(char chara) {
		return Character.isLowerCase(chara);
	}

}
