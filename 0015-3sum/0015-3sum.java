class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if((i==0) || (nums[i]!=nums[i-1])){
                int sum = 0-nums[i];
                int l = i+1;
                int h = nums.length-1;
                while(l<h){
                    if(nums[l]+nums[h]==sum){
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[l]);
                        a.add(nums[h]);
                        ans.add(a);
                        while (l < h && nums[l] == nums[l+1]) l++;
                        while (l < h && nums[h] == nums[h-1]) h--;
                        l++;
                        h--;
                    }
                    else if(nums[l]+nums[h]>sum)
                        h--;
                    else
                        l++;
                        
                }
            }
        }
        return ans;
    }
}