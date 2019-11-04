package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * https://leetcode.com/problems/group-anagrams/
 * 
 * 
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
	        
	        Map<String, List<String>> resultMap = new HashMap<>();
	        for(int i=0; i<strs.length; i++){
	            String s = strs[i];
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            List<String> resultList = resultMap.getOrDefault(String.valueOf(ca), new ArrayList<>());
	            resultList.add(s);
	            resultMap.put(String.valueOf(ca), resultList);
	        }
	        List<List<String>> resultList  = new ArrayList<>();
	        for(List<String> valueList : resultMap.values()){
	            resultList.add(valueList);
	        }
	        return resultList;
	    }
}
