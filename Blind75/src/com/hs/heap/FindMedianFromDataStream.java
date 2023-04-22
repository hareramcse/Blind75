package com.hs.heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	private PriorityQueue<Integer> maxHeap = null;
	private PriorityQueue<Integer> minHeap = null;

	public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> (b-a));
        minHeap = new PriorityQueue<Integer>((a,b) -> (a-b));
    }

	public void addNum(int num) {
		if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}

		balance();
	}

	public double findMedian() {
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else if (maxHeap.size() < minHeap.size()) {
			return minHeap.peek();
		} else {
			// maxHeap == minHeap size
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}

	private void balance() {
		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.offer(maxHeap.poll());
		} else if (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.offer(minHeap.poll());
		}
	}
}
