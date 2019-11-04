package strings;


/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FindUniqueCharactersInaString {

	public int firstUniqChar(String s) {
        if(s == null || s == ""){
            return -1;
        }
        int[] dups = new int[26];
        int[] indexes = new int[26];
        for(int i=0; i<s.length(); i++){
            dups[s.charAt(i) - 'a']++;
            indexes[s.charAt(i) - 'a'] = i; 
        }
        int minIndex = Integer.MAX_VALUE;
        for(int j=0; j<dups.length; j++){
            if(dups[j] == 1){
                minIndex = Math.min(minIndex, indexes[j]);
            }
        }
        if(minIndex == Integer.MAX_VALUE){
            minIndex = -1;
        }
        return minIndex;
    }
}
