package strings;

import java.util.Scanner;

public class MarsExploration {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		if (s != null) {
			String input = s.next();
			if (input.length() % 3 == 0) {
				char[] val = input.toCharArray();
				int counter = 0;
				for (int i = 0; i < val.length; i+=3) {
					if(val[i] != 'S'){
						counter++;
					}
					if(val[i+1] != 'O'){
						counter++;
					}
					if(val[i+2] != 'S'){
						counter++;
					}
				}
				System.out.println(counter);
			}
		}
	}
}

