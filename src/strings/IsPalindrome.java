package strings;

public class IsPalindrome {
	
	public static void main(String[] args) {
		//System.out.println(isPalindrome("ababczz"));
		System.out.println(isPalindrome("a but tuba"));
	}

	public static boolean isPalindrome(String inp){

		if(inp == null){
			return false;
		}
		inp = inp.replace(" ", "");
		int i = 0, j=inp.length()-1;
		while( i <= j){
			
			if(inp.charAt(i) != inp.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
