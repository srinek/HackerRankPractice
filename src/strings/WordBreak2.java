package strings;

import java.util.*;

public class WordBreak2 {

	public static void main(String[] args) {

		WordBreak2 wb2 = new WordBreak2();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		// System.out.println(wb2.wordBreak("catsanddog", wordDict));
		System.out.println(wb2.bfsSol("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		LinkedList<String>[] dp = new LinkedList[s.length() + 1];
		LinkedList<String> initial = new LinkedList<>();
		initial.add("");
		dp[0] = initial;
		for (int i = 1; i <= s.length(); i++) {
			LinkedList<String> list = new LinkedList<>();
			for (int j = 0; j < i; j++) {
				if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
					for (String l : dp[j]) {
						list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
					}
				}
			}
			dp[i] = list;
		}
		return dp[s.length()];
	}

	static class Pair {
		public int start;
		public Pair parent;
		public Pair(int start, Pair parent) {
			this.start = start;
			this.parent = parent;
		}
	}

	private List<String> bfsSol(String s, List<String> wordDict){

		List<String> result = new ArrayList<>();
		Queue<Pair> bfs = new LinkedList<>();
		bfs.offer(new Pair(0, null));

		while(!bfs.isEmpty()){
			Pair p = bfs.poll();
			for(int i = p.start+1; i <= s.length(); i++){
				if(wordDict.contains(s.substring(p.start, i))){
					bfs.add(new Pair(i, p));
					if(i == s.length()){
						StringBuilder sb = new StringBuilder();
						int end = i;
						Pair tempParent = p;
						while (tempParent != null) {
							sb.insert(0, s.substring(tempParent.start, end));
							end = tempParent.start;
							tempParent = tempParent.parent;
							if (tempParent != null) {
								sb.insert(0, " ");
							}
						}
						result.add(sb.toString());
					}
				}
			}
		}
		return result;
	}
}
