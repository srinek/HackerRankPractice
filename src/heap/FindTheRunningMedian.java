package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class FindTheRunningMedian {
	
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			System.out.println(getMedian(scan.nextInt(), maxHeap, minHeap));
		}
		scan.close();
	}
	
	public static double getMedian(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
		addNumber(number, maxHeap, minHeap);
		balanceHeaps(maxHeap, minHeap);
		return findMedian(maxHeap, minHeap);
	}

	private static double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if(maxHeap.size() == minHeap.size()){
			return (double)(maxHeap.peek() + minHeap.peek()) / 2;
		}
		if(maxHeap.size() - minHeap.size() == 1){
			return (double)maxHeap.peek();
		}
		return (double)minHeap.peek();
	}

	private static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		
		PriorityQueue<Integer> bigger = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
		PriorityQueue<Integer> smaller = maxHeap.size() < minHeap.size() ? maxHeap : minHeap;
		if(bigger.size() - smaller.size() >= 2){
			smaller.offer(bigger.poll());
		}
		
	}

	private static void addNumber(int number, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		
		if(maxHeap.isEmpty() || number <= maxHeap.peek() ){
			maxHeap.offer(number);
		}
		else{
			minHeap.offer(number);
		}
		
	}

}
