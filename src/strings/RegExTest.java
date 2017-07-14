package strings;

public class RegExTest {

	
	public static void main(String[] args) {
		
		String str = "beabeefeab".replaceAll("[^be]", "");
		System.out.println(str);
	}
}
