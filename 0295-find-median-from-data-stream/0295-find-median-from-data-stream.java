class MedianFinder {
    PriorityQueue<Integer>left;
    PriorityQueue<Integer>right;
    public MedianFinder() {
      left = new PriorityQueue(Collections.reverseOrder());
      right = new PriorityQueue(); 
    }
    
    public void addNum(int num) {
        if(right.size() > 0 && num >= right.peek()){
            right.add(num);
        }
        else{
           left.add(num);
        }
        if(right.size() - left.size() == 2 ){
            left.add(right.remove());
        }
        else if(left.size() - right.size() == 2){
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        double median = 0;
        if(left.size() > right.size()){
            median = (double)left.peek();
        }
        else if(left.size() == right.size()){
            median = (double)(left.peek() + right.peek())/2;
        }
        else{
            median = (double)right.peek();
        }
        return median;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();




1 2 3 2 4 
    
1 2 2 3 4
    
    
1 1 2 2 2 3 4
    
1
1 2
1 2,3
2,1 2,3
2,1,2 2,3
2,1,2 2,3,4
2,1,2,1 2,3,4
    
    
    
10 2 0 -3 3
      
    
2 10
2,0 10
2,0,-3 10 => 0,-3 2,10
2,0,-3 3,10
 */