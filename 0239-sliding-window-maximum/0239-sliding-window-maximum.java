class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int i=0,j=0;
        for(i=0;i<k;i++){
            while(q.size()>0 && q.peekLast()<nums[i]){
                q.pollLast();
            }
            q.addLast(nums[i]);
        }
        ans[j]=q.peekFirst();
        j++;
        for(i=k;i<nums.length;i++){
            if(q.peekFirst()==nums[i-k])
                q.pollFirst();
            while(q.size()>0 && q.peekLast()<nums[i]){
                q.pollLast();
            }
            q.addLast(nums[i]);
            ans[j]=q.peekFirst();
            j++;
            
        }
        return ans;
        
    }
}


