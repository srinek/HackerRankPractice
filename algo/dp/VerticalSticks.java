package algo.dp;

import java.util.Arrays;
import java.util.Scanner;

public class VerticalSticks {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int i=0; i<t;i++){
            int n= sc.nextInt();
            int[] countingArray= new int[1001];
            int[] ar =new int[n];
            for(int j=0; j<n;j++){
                int temp=sc.nextInt();
                ar[j]=temp;
                countingArray[temp]+=1;
            }
            //System.out.println(Arrays.toString(countingArray));
            for(int j=4; j>0; j--){
                countingArray[j-1]=countingArray[j-1]+countingArray[j];
            }
            //System.out.println(Arrays.toString(countingArray));
            float exp=0;
            for(int j=0;j<n;j++){
            	float val = (float)(n+1)/(1+countingArray[ar[j]]);
            	//System.out.println(" j = "+j+" val = "+val);
                exp+= val;
            }
            System.out.printf("%.2f\n" ,exp);
        }
    }
	private static int getAverage(int[] input){
		
		
		
		return 0;
	}
}
