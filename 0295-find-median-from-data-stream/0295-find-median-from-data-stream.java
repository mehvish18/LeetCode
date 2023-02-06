class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
     
    }
    
    public void addNum(int num) {
       maxHeap.add(num);
       if(maxHeap.size()-minHeap.size()>1 || (minHeap.peek()!=null && minHeap.peek()<maxHeap.peek())){
           minHeap.add(maxHeap.poll());
       }
       if(minHeap.size()-maxHeap.size()>1){
           maxHeap.add(minHeap.poll());
       } 
    }
    
    public double findMedian() {
        Integer minHead = minHeap.peek();
        Integer maxHead = maxHeap.peek();
        /*System.out.println("Min heap size: "+minHeap.size());
        System.out.println("Max heap size: "+maxHeap.size());
        System.out.println("minHead: "+minHeap.peek());
        System.out.println("maxhead: "+maxHeap.peek());*/
        if(minHeap.size()==maxHeap.size()){
            return ((double)(minHead+maxHead)/2);
        }
        else if(minHeap.size()>maxHeap.size()){
            return minHead;
        }
        else {
            return maxHead;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


 
    