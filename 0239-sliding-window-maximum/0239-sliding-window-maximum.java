class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(nums[0]);
        int [] ans = new int[nums.length-k+1];
        for(int i=1;i<k;i++){
           while(q.peekLast()!=null && q.peekLast()<nums[i]){
               q.pollLast();
           } 
           q.add(nums[i]);
        }
        ans[0] = q.peek();
        int j=1;
        for(int i=k;i<nums.length;i++){
            if(q.peek()!=null && q.peek()==nums[i-k])
                q.poll();
            while(q.peekLast()!=null && q.peekLast()<nums[i]){
               q.pollLast();
            } 
            q.add(nums[i]);
            ans[j] = q.peek();
            j++;
        }
        return ans;
    }
}


