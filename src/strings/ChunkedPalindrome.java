package strings;

/*
 * https://leetcode.com/discuss/interview-question/337515/Google-or-Onsite-or-Chunked-Palindrome
 * 
 * Normal palindrome is defined as a string that reads the same backwards as forwards, for example "abccba".
Chunked palindrome is defined as a string that you can split into chunks and it will form a palindrome.
For example, "volvo". You can split it into (vo)(l)(vo). Let A = "vo", B = "l", so the original string is ABA which is a palindrome.

Given a string str, find the maximum number of chunks we can split that string to get a chuncked palindrome.

Example 1:

Input: "valve"
Output: 1
Explanation: You can't split it into multiple chunks so just return 1 (valve)
Example 2:

Input: "voabcvo"
Output: 3
Explanation: (vo)(abc)(vo)
Example 3:

Input: "vovo"
Output: 2
Explanation: (vo)(vo)
Example 4:

Input: "volvolvo"
Output: 5
Explanation: (vo)(l)(vo)(l)(vo)
Example 5:

Input: "volvol"
Output: 2
Explanation: (vol)(vol)
Example 6:

Input: "aaaaaa"
Output: 6
Explanation: We can split it into (aaa)(aaa), but the optimal split should be (a)(a)(a)(a)(a)(a)
 */
public class ChunkedPalindrome {

	public int chunkedPalindromeCount(String str){
		
		int i = 0, j = 1; 
		int y=str.length(), x = y-1;
		int count = 0;
		
		while( i <= x ){
			
			if( i == x){
				count++;
				break;
			}
			
			String s1 = str.substring(i, j);
			String s2 = str.substring(x, y);
			
			if(s1.equals(s2)){
				
				i = j;
				y = x;
				j++;
				x--;
				count += 2;
			}
			else{
				
				j++;
				x--;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		ChunkedPalindrome obj = new ChunkedPalindrome();
        System.out.println(obj.chunkedPalindromeCount("a")); // 1
        System.out.println(obj.chunkedPalindromeCount("voabcvo")); // 3
        System.out.println(obj.chunkedPalindromeCount("vovo")); // 2
        System.out.println(obj.chunkedPalindromeCount("volvolvo")); // 5
        System.out.println(obj.chunkedPalindromeCount("aaaaaa")); // 6
        System.out.println(obj.chunkedPalindromeCount("abcbad")); // 1
        System.out.println(obj.chunkedPalindromeCount("volvol")); // 2
	}
}
