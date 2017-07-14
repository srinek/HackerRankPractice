package algo.warmup;

import java.util.Scanner;

/*Colleen is turning  years old! She has  candles of various heights on her cake, and candle  has height . Because the taller candles tower over the shorter ones, Colleen can only blow out the tallest candles.

Given the height for each individual candle, find and print the number of candles she can successfully blow out.*/

public class BirthdayCandles {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int totalvalues = scan.nextInt();
		int index = 0;
		int max = Integer.MIN_VALUE;
		int result = 0;
		while(index++ < totalvalues){
			int value = scan.nextInt();
			if(value > max){
				max = value;
				result = 1;
			}
			else if(value == max){
				result++;
			}
		}
		System.out.println(result);
		scan.close();
	}
}
