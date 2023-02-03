class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] max = new int[nums.length-k+1];
        LinkedList<Integer> lst = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(lst.size()>0 && nums[i]>nums[lst.peekLast()]){
                lst.pollLast();
            }
            lst.add(i);
            if(i-k+1<0)
                continue;
            max[i-k+1]=nums[lst.peekFirst()];
            if(lst.peekFirst()==(i-k+1))
                lst.pollFirst();
        }
        return max;
    }
}

    