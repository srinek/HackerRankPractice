package heap;

import java.util.Scanner;

public class QHeap1 {
	
	static class Heap{
		
		int[] heap = null;
		int heapsize = 0;
		
		public Heap(int max){
			heap = new int[max+1]; // 1 based index
		}
		
		//   0 1  4  3 10  9   6
		//   5 9 21 14  7 32  18
		// 0 1 2 3  4  5  6  7
		public boolean insert(int val){
			
			heapsize++; // 1 based index
			heap[heapsize] = val;
			minify(heapsize);
			return true;
		}
		
		private void minify(int pos) {
			int parentpos = pos / 2;
			if(parentpos > 0){
				if(heap[pos] < heap[parentpos]){
					swap(pos, parentpos);
					minify(parentpos);
				}
			}
			
		}

		private void swap(int pos, int parentpos) {
			
			int temp = heap[pos];
			heap[pos] = heap[parentpos];
			heap[parentpos] = temp;
		}

		public int getMin(){
			return heap[1]; // 1 based index
		}
		
		public boolean delete(int val){
			int deleteIndex = findDeleteIndex(val);
			deleteByIndex(deleteIndex);
			return true;
		}

		private void deleteByIndex(int deleteIndex) {
			if(hasChild(deleteIndex)){
				int leftIndex = deleteIndex * 2;
				int rightIndex = deleteIndex * 2 + 1;
				if(rightIndex > heapsize){
					heap[deleteIndex] = heap[leftIndex];
					deleteIndex = leftIndex;
				}
				else if(heap[leftIndex] < heap[rightIndex]){
					heap[deleteIndex] = heap[leftIndex];
					deleteIndex = leftIndex;
				}
				else{
					heap[deleteIndex] = heap[rightIndex];
					deleteIndex = rightIndex;
				}
				deleteByIndex(deleteIndex);
			}
			else{
				while(deleteIndex < heapsize){
					heap[deleteIndex] = heap[deleteIndex + 1];
					deleteIndex++;
				}
				heapsize--;
			}
		}
		
		private boolean hasChild(int deleteIndex) {
			if(deleteIndex * 2 <= heapsize){
				return true;
			}
			return false;
		}

		private int findDeleteIndex(int val) {
			int deleteIndex = 0;
			int begin = 1;
			for(int i = begin; i <= heapsize; i++){
				if(heap[i] == val){
					deleteIndex = i;
				}
			}
			return deleteIndex;
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int queries = scan.nextInt();
		Heap heap = new Heap(queries);
		int index = 0;
		while(index < queries){
			int op = scan.nextInt();
			if(op == 1){
				heap.insert(scan.nextInt());
			}
			else if(op == 2){
				heap.delete(scan.nextInt());
			}
			else{
				System.out.println(heap.getMin());
			}
			index++;
		}
		scan.close();
	}

}
