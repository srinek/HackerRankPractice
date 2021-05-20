package strings;

import java.math.BigInteger;

public class Atoi {

	public static void main(String[] args) {
		
		Atoi atoi = new Atoi();
		System.out.println(atoi.myAtoi("-91283472332900909345353534"));
	}
	
	public int myAtoi(String str) {
        
		
		if(str.length() == 0){
			return 0;
		}
		
		int index = 0, sign = 1;
		
		while(index < str.length() && str.charAt(index) == ' '){
			 index ++;
		}
		
		if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
			sign = str.charAt(index) == '+'  ? 1 : -1;
			index++;
		}
		
		int total = 0;
		
		while(index < str.length()){
			if(Character.isDigit(str.charAt(index))){
				int digit = Character.getNumericValue(str.charAt(index));
				if(Integer.MAX_VALUE/10 < total ||  Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit){
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				total = total*10 + digit;
				index++;
			}
			break;
		}
		return sign*total;
    }

}
