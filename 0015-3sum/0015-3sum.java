class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       //System.out.println(Arrays.toString(nums));
       List<List<Integer>> ans = new ArrayList<>();
       for(int i=0;i<nums.length-1;i++){
           int sum = -nums[i];
           int l = i+1;
           int h = nums.length-1;
           if(i!=0 && nums[i]==nums[i-1])
              continue;
           while(l<h){
               if(nums[l]+nums[h]==sum){
                   List<Integer> a = new ArrayList<>();
                   a.add(nums[i]);
                   a.add(nums[h]);
                   a.add(nums[l]);
                   ans.add(a); 
                   while(l<h && nums[l+1]==nums[l])
                    l++;
                   while(l<h && nums[h-1]==nums[h])
                    h--;
                   l++;
                   h--;
               }
               else if(nums[l]+nums[h]<sum)
                   l++;
               else 
                   h--;
           }
       }
        return ans;
    }
}
//[-5, -5, -4, -4, -4, -2, -2, -2, 0, 0, 0, 1, 1, 3, 4, 4]
//-5 4 1, -4 3 1, -4 40, -2,-2,4,
    
//-2 0  1
