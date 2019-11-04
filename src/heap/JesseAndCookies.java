package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class JesseAndCookies {

	static class Heap {
		int[] heap = null;
		int heapsize = 0;
		int heapstart = 1;

		public Heap(int max) {
			heap = new int[max + 1]; // 1 based index
		}

		// 0 4 3 6 2 7 8
		// 0 2 3 6 4 7 8
		public void insert(int val) {
			heap[++heapsize] = val;
			fixheap(heapsize);
		}

		private void fixheap(int pos) {

			int parentIndex = pos / 2;
			if (parentIndex >= heapstart) {
				if (heap[parentIndex] > heap[pos]) {
					swap(parentIndex, pos);
					fixheap(parentIndex);
				}
			}

		}
		
		private void minify(int pos) {
			if(pos > 0 && pos <= heapsize){
				int current = heap[pos];
				int left = getLeft(pos);
				int right = getRight(pos);
				int min = left < current ? left : current;
				if(right < min){
					swap(pos, pos*2 + 1);
					minify(pos*2 + 1);
				}
				else if(min != current){
					swap(pos, pos*2);
					minify(pos*2);
				}
			}
		}
		
		public int getLeft(int pos){
			if(pos*2 > heapsize){
				return Integer.MAX_VALUE;
			}
			int left = heap[pos*2];
			return left;
		}
		
		public int getRight(int pos){
			if(pos*2+1 > heapsize){
				return Integer.MAX_VALUE;
			}
			int right = heap[pos*2 + 1];
			return right;
		}
		
		public int pop(){
			int min = heap[1];
			heap[1] = heap[heapsize];
			heapsize--;
			minify(1);
			return min;
		}
		
		public int mixElemsLessThanK(int k){
			int iterations = 0;
			print();
			while (heap[1] < k){
				if(heapsize == 1){
					return -1; // heap has only one element
				}
				int least = heap[1];
				int nextLeast = findNextLeast();
				int newval = least + 2 * nextLeast;
				pop();
				print();
				pop();
				print();
				insert(newval);
				print();
				iterations++;
			}
			return iterations;
		}
		
		public void print(){
			System.out.println(Arrays.toString(heap) +"        "+heapsize);
		}

		private int findNextLeast() { // expects atleast 2 elems in Heap
			int nextleast = heap[2];
			if(3 <= heapsize &&  heap[3] < nextleast){
				nextleast = heap[3];
			}
			
 			return nextleast;
		}

		private void swap(int pos, int parentpos) {
			if(parentpos > heapsize ){
				return;
			}
			int temp = heap[pos];
			heap[pos] = heap[parentpos];
			heap[parentpos] = temp;
		}
	}

	
	private static int mixElemsLessThanK(Queue<Integer> heapQ, int k){
		
		int result = 0;
		while(!heapQ.isEmpty() && heapQ.peek() < k){
			int first = heapQ.poll();
			int second = 0;
			if(!heapQ.isEmpty()){
				second = heapQ.poll();
			}
			heapQ.add((first*1) + (second*2));
			result++;
		}
		return result;
	}
	
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		//Heap heap = new Heap(n);
		Queue<Integer> heapQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			//heap.insert(temp);
			heapQ.add(temp);
		}
		//System.out.println(heap.mixElemsLessThanK(k));
		System.out.println(mixElemsLessThanK(heapQ, k));
		scan.close();
	}
}
