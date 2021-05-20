package strings;

public class InterleavingStrings {
	
	/*
	 * 
s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbbaccc"

s3 should be made of s1 and s2 and the order of s1 and s2 should be preserved
https://leetcode.com/articles/interleaving-strings/
 
	 */ 
	public static void main(String[] args) {
		InterleavingStrings prg = new InterleavingStrings();
		System.out.println(prg.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	public boolean is_Interleave(String s1,int i,String s2,int j,String res,String s3)
    {
		System.out.println(res);
        if(res.equals(s3) && i==s1.length() && j==s2.length())
            return true;
        boolean ans=false;
        if(i<s1.length())
            ans|=is_Interleave(s1,i+1,s2,j,res+s1.charAt(i),s3);
        if(j<s2.length())
            ans|=is_Interleave(s1,i,s2,j+1,res+s2.charAt(j),s3);
        return ans;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        //return is_Interleave(s1,0,s2,0,"",s3);
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
    	boolean[][] ret = new boolean[s1.length()+1][s2.length()+1];
    	
    	for(int i=0; i<ret.length; i++){
    		for(int j=0; j<ret[i].length; j++){
    			if(i==0 && j==0){
    				ret[i][j] = true;
    			}
    			else if(i==0 ){
    				ret[i][j] = s2.charAt(j-1) == s3.charAt(i+j-1) && ret[i][j-1];
    			}
    			else if(j==0 ){
    				ret[i][j] = s1.charAt(i-1) == s3.charAt(i+j-1) && ret[i-1][j];
    			}
    			else if(s1.charAt(i-1) == s3.charAt(i+j-1)){
    				ret[i][j] = ret[i-1][j];
    			}
    			else if(s2.charAt(j-1) == s3.charAt(i+j-1)){
    				ret[i][j] = ret[i][j-1];
    			}
    		}
    	}
    	
    	return ret[s1.length()][s2.length()];
    }

}
