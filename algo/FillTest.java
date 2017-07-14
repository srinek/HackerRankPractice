package algo;

import java.util.Arrays;
import java.util.List;

public class FillTest {

	public static void main(String[] args) {
		
		int[] mailRecipients = new int[]{1,2,3};
		int[] retArr = new int[5];
	    int[] email = new int[]{ 4,5};
	    
		System.arraycopy(mailRecipients, 0, retArr, 0, mailRecipients.length);
		System.arraycopy(email, 0, retArr, mailRecipients.length, email.length);
		
		System.out.println(" retArr "+ Arrays.toString(retArr) );
	}
}
