package strings;

import java.util.HashMap;
import java.util.Map;

public class IntegerToWords {

	private static Map<Integer, String> numberMap = new HashMap<>();
    private static Map<Integer, String> tenMap = new HashMap<>();
    
    static{
        numberMap.put(0, " Zero");
        numberMap.put(1, " One");
        numberMap.put(2, " Two");
        numberMap.put(3, " Three");
        numberMap.put(4, " Four");
        numberMap.put(5, " Five");
        numberMap.put(6, " Six");        
        numberMap.put(7, " Seven");
        numberMap.put(8, " Eight");
        numberMap.put(9, " Nine");
        numberMap.put(10, " Ten");
        
        tenMap.put(1, " One");
        tenMap.put(10, " Ten");
        tenMap.put(11, " Eleven");
        tenMap.put(12, " Twelve");
        tenMap.put(13, " Thriteen");
        tenMap.put(14, " Fourteen");
        tenMap.put(15, " Fifteen");
        tenMap.put(16, " Sixteen");
        tenMap.put(17, " Seventeen");
        tenMap.put(18, " Eighteen");
        tenMap.put(19, " Nineteen");
        tenMap.put(2, " Twenty");
        tenMap.put(3, " Thirty");
        tenMap.put(4, " Forty");
        tenMap.put(5, " Fifty");
        tenMap.put(6, " Sixty");        
        tenMap.put(7, " Seventy");
        tenMap.put(8, " Eighty");
        tenMap.put(9, " Ninety");
    }
    
    
    public static void main(String[] args) {
    	IntegerToWords sol = new IntegerToWords();
    	System.out.println(sol.numberToWords(20).trim());
	}
    
	// 1234567891
    public String numberToWords(int num) {
    	
    	return numberToWordsHelper(num).trim();
    }
    public String numberToWordsHelper(int num) {
        
        StringBuilder result = new StringBuilder();
        
        // check billions
        int temp = getBillions(num, '/');
        if(temp > 0){
            result.append(numberToWordsHelper(temp)).append(" Billion");
            num = getBillions(num, '%');
        }
        //check millions
        temp = getMillions(num, '/');
        if(temp > 0){
            result.append(numberToWordsHelper(temp)).append(" Million");
            num = getMillions(num, '%');
        }
        //check 100 thousands
        temp = get100Thousands(num, '/');
        if(temp > 0){
            result.append(numberToWordsHelper(temp)).append(" Hundred");
            num = get100Thousands(num, '%');
        }
        
        temp = getThousands(num, '/');
        if(temp > 0){
            result.append(numberToWordsHelper(temp)).append(" Thousand");
            num = getThousands(num, '%');
        }
        
        temp = getHundreds(num, '/');
        if(temp > 0){
            result.append(numberToWordsHelper(temp)).append(" Hundred");
            num = getHundreds(num, '%');
        }
        
        temp = getTens(num, '/');
        if(temp > 1){
            result.append(tenMap.get(temp));
            num = getTens(num, '%');
        }
         if(num/10 == 1){
            result.append(tenMap.get(num));
        }
        if(num/10 == 0){
            result.append(numberMap.get(num));
        }
        return result.toString();
    }
    
    private int getBillions(int num, char op){
        if(op == '%'){
            return num % 1000000000;
        }
        return num / 1000000000;
    }
    
    private int getMillions(int num, char op){
         if(op == '%'){
            return num % 1000000;
        }
        return num / 1000000;
    }
    private int get100Thousands(int num, char op){
        if(op == '%'){
            return num % 100000;
        }
        return num / 100000;
    }
    private int getThousands(int num, char op){
        if(op == '%'){
            return num % 1000;
        }
        return num / 1000;
    }
    private int getHundreds(int num, char op){
        if(op == '%'){
            return num % 100;
        }
        return num / 100;
    }
    private int getTens(int num, char op){
        if(op == '%'){
            return num % 10;
        }
        return num / 10;
    }
}
