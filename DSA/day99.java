class MedianFinder {
 PriorityQueue<Integer> minHeap = new PriorityQueue<>();  //stores bigger half elemnts
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  //stores smaller half element
    
    public MedianFinder() {
        
    }
     
    public void addNum(int num) {
        maxHeap.offer(num);     //add to maxheap
        minHeap.offer(maxHeap.poll());      //shift one element from max to minheap to balance
        if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());      //if there are odd no.of elements then maxheap hold that extra oddone element
    }
    
    public double findMedian() {
         if (maxHeap.size() > minHeap.size())   // we always have that odd extra center element in maxheap so take that.
         return maxHeap.peek();

        return (minHeap.peek() + maxHeap.peek()) / 2.0d;   //mean of two center elements
    }
}

