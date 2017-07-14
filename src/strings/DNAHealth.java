package strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNAHealth {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int index = 0;
		String[] genes = new String[total];
		int[] health = new int[total];
		while(index < total){
			genes[index++] = scan.next();
		}
		index = 0;
		while(index < total){
			health[index++] = scan.nextInt();
		}
		int totalStrs = scan.nextInt();
		index = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		while(index++ < totalStrs){
			int start = scan.nextInt();
			int end = scan.nextInt();
			String str = scan.next();
			int strhealth = findDNAHealth(str, genes, health, start, end);
			if(strhealth > max){
				max = strhealth;
			}
			if(strhealth < min){
				min = strhealth;
			}
		}
		System.out.println(min +" "+max);
		scan.close();
	}
	
	private static int findDNAHealth(String str, String[] genes, int[] health, int start, int end){
		
		if(start < 0 || start > genes.length){
			return 0;
		}
		if(end < 0 || end > genes.length){
			return 0;
		}
		
		int strHealth = 0;
		for(int c = start; c <= end; c++){
			Pattern pattern = Pattern.compile(genes[c]);
			Matcher matcher = pattern.matcher(str);
			int from = 0;
			while(matcher.find(from)){
				from = matcher.start() + 1;
				strHealth += health[c];
			}
			
		}
		
		return strHealth;
	}

}
