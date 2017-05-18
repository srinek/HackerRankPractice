package algo.warmup;

import java.util.Scanner;

public class ArraySum {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int i = 0;
        int sum = 0;
        while(i++ < total){
            int num = scan.nextInt();
            sum += num;
        }
        scan.close();
        System.out.println(sum);
    }

}
