class MinStack {
    List<Integer> lst = new ArrayList<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        lst.add(val);
    }
    
    public void pop() {
        lst.remove(lst.size()-1);
    }
    
    public int top() {
        return lst.get(lst.size()-1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<lst.size();i++){
            if(lst.get(i)<min)
                min = lst.get(i);
        }
        return min;
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