package strings;

import java.util.List;
import java.util.ArrayList;

/*
 * https://careercup.com/question?id=5758006474571776
 * Find the indices of all anagrams of a given word in a another word. 
 * For example: Find the indices of all the anagrams of AB in ABCDBACDAB (Answer: 0, 4, 8)
 *   "top" in "aobcotpxyztopoptpot"
 */
/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class AnagramsInString {

	public static void main(String[] args){
		AnagramsInString sol = new AnagramsInString();
		List<Integer> output = sol.findAnagrams("abcdbacdab", "ab");
		//List<Integer> output = sol.findAnagrams("aobcotpxyztopoptpot", "top");
		//List<Integer> output = sol.findAnagrams("cbaebabacd","abc"); // 0, 6
		System.out.println(output);
	}
	
	public List<Integer> findAnagrams(String str, String t) {
	
		List<Integer> output = new ArrayList<>();
		
		if(t.length() > str.length()){
			return output;
		}
		int[] sarr = new int[26];
		int[] tarr = new int[26];
		// initialize the window
		for(int i=0; i<t.length(); i++){
			tarr[t.charAt(i)-'a']++;
			sarr[str.charAt(i)-'a']++;
		}
		int k=0;
		for(; k<str.length()-t.length(); k++){
			
			if(compareArrays(sarr, tarr)){
				output.add(k);
			}
			
			//sliding window
			sarr[str.charAt(k)-'a']--;
			sarr[str.charAt(k+t.length())-'a']++;
		}
		if(compareArrays(sarr, tarr)){
			output.add(k);
		}
		return output;
	}
	
	private boolean compareArrays(int[] sarr, int[] tarr) {
		
		for(int i=0; i<sarr.length; i++){
			if(sarr[i] != tarr[i]){
				return false;
			}
		}
		return true;
		
	}
	/*public List<Integer> findAnagrams(String str, String a) {
		
		if(str == null || a == null){
			return null;
		}
		List<Integer> output = new ArrayList<>();
		
		boolean[] temp = new boolean[a.length()];
		int i=0;
		int index = -1;
		int tempIndexMatch  = -1, totalMatch = 0;
		while(i < str.length()){
			if(i== 10){
				System.out.println();
			}
			index = a.indexOf(str.charAt(i));
			if(index >= 0){
				if(tempIndexMatch == -1){
					tempIndexMatch = i;
				}
				temp[index] = true;
				totalMatch++;
				if(totalMatch == a.length() && checkForAllMatch(temp)){
					output.add(tempIndexMatch);
					resetTemp(temp);
					tempIndexMatch = -1;
					totalMatch = 0;
				}
			}
			else{
				resetTemp(temp);
				tempIndexMatch = -1;
				totalMatch = 0;
			}
			i++;
		}
		
		return output;
	}
	
	private static void resetTemp(boolean[] temp){
		
		for(int i=0; i<temp.length; i++){
			temp[i] = false;
		}
	}
	
	private static boolean checkForAllMatch(boolean[] temp){
		
		for(int i=0; i<temp.length; i++){
			if(!temp[i]){
				return false;
			}
		}
		return true;
	}*/

	
	
}
