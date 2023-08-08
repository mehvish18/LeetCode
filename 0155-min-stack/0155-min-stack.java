class MinStack {
    List<Integer> lst = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        lst.add(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(lst.get(lst.size()-1));
        lst.remove(lst.size()-1);    
    }
    
    public int top() {
        return lst.get(lst.size()-1);
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */