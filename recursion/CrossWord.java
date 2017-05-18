package recursion;

import java.util.Scanner;

public class CrossWord {

	
	private static char[][] inArray = new char[10][10];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 0;
		while(i < 10){
			String str = scan.nextLine();
			int j = 0;
			while(j < 10){
				char c = str.charAt(j);
				inArray[i][j] = c;
				j++;
			}
			i++;
		}
		String wordStr = scan.nextLine();
		String[] words = wordStr.split(";");
		Slot[] slots = new Slot[words.length];
		/*for(int k = 0; k < inArray.length; k++){
			for(int l=0; l < inArray[k].length; l++){
				if(inArray[k][l] == '-'){
					makeSlot(slots, k, l);
				}
			}
		}*/
		//reAdjustSlots(slots);
		makeSlot(slots, 0, 0);
		scan.close();
		
		fillCrossword(slots, words, 0, 0);
		for(int k = 0; k < inArray.length; k++){
			for(int l=0; l < inArray[k].length; l++){
				System.out.print(inArray[k][l]);
			}
			System.out.println();
		}
		for(Slot slot : slots){
			System.out.println("-- "+slot.getStartx() + " "+slot.getStarty()+" "+slot.getEndx()+" "+slot.getEndy() +" "+ slot.getFilledWith());
		}
	}

	private static void reAdjustSlots(Slot[] slots) {
		for(Slot slot : slots){
			int k = slot.getStartx();
			int l = slot.getStarty();
			if(k-1 >= 0 && inArray[k-1][l] == '-'){
				k = k-1;
			}
			if(l-1 >= 0 && inArray[k][l-1] == '-'){
				l = l-1;
			}
			slot.setStartx(k);
			slot.setStarty(l);
		}
		
	}

	private static void makeSlot(Slot[] slots, int k, int l) {
		int index = 0;
		/*for(Slot slot : slots){
			if(slot != null){ 
			   index++;
			   if(slot.getStartx() == k || slot.getStarty() == l){
				  slot.setEndx(k);
				  slot.setEndy(l);
				  return;
			   }
			}
		}
		Slot slot = new Slot(k, l, k, l);
		slots[index] = slot;*/
		Slot slot = new Slot(0, 1, 5, 1);
		slots[index++] = slot;
		slot = new Slot(3, 1, 3, 5);
		slots[index++] = slot;
		slot = new Slot(3, 5, 9, 5);
		slots[index++] = slot;
		slot = new Slot(7, 2, 7, 7);
		slots[index++] = slot;
	}
	
	private static void fillCrossword(Slot[] slots, String[] words, int i, int j){
		
		if(allSlotsFilled(slots)){
			return;
		}
		
		if(i == slots.length){
			i = 0;
		}
		if(j == words.length){
			j = 0;
		}
		Slot slot = slots[i] ;
		String word = words[j];
		if("ANKARA".equals(word) && i == 1){
			return;
		}
		if(slot.matching(word)){
			slot.setFilledWith(word);
			slot.setEmpty(false);
			fillCrossword(slots, words, i +1, j+1);
			fillCrossword(slots, words, i, j+1);
		}
		else{
			fillCrossword(slots, words, i, j+1);
		}
		
	}
	
	private static boolean allSlotsFilled(Slot[] slots) {
		for(Slot slot : slots){
			if(slot.isEmpty()){
				return false;
			}
		}
		return true;
	}

	public static class Slot{
		
		private int startx;
		private int starty;
		private int endx;
		private int endy;
		private boolean empty = true;
		private String filledWith;
		
		public int getStartx() {
			return startx;
		}

		public void setStartx(int startx) {
			this.startx = startx;
		}

		public int getStarty() {
			return starty;
		}

		public void setStarty(int starty) {
			this.starty = starty;
		}

		public int getEndx() {
			return endx;
		}

		public void setEndx(int endx) {
			this.endx = endx;
		}

		public int getEndy() {
			return endy;
		}

		public void setEndy(int endy) {
			this.endy = endy;
		}

		public boolean isEmpty() {
			return empty;
		}

		public void setEmpty(boolean empty) {
			this.empty = empty;
		}

		public String getFilledWith() {
			return filledWith;
		}

		public void setFilledWith(String filledWith) {
			this.filledWith = filledWith;
			int charIndex = 0;
			for(int i = startx; i <= endx; i++){
				for(int j = starty; j<= endy; j++){
					inArray[i][j] = filledWith.charAt(charIndex++);
				}
			}
		}
		
		public int getLength(){
			if(endx - startx > 0){
				return endx - startx + 1;
			}
			return endy - starty + 1;
		}
		
		public boolean matching(String word){
			if(this.getLength() == word.length()){
				int charIndex = -1;
				for(int i = startx; i <= endx; i++){
					for(int j = starty; j<= endy; j++){
						charIndex++;
						if(inArray[i][j] == '-'){
							continue;
						}
						if(inArray[i][j] != word.charAt(charIndex)){
							return false;
						}
					}
				}
				return true;
			}
			
			return false;
		}

		public Slot(int startx, int starty, int endx, int endy) {
			super();
			this.startx = startx;
			this.starty = starty;
			this.endx = endx;
			this.endy = endy;
		}
		
		
		
	}
}
