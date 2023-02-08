class Solution {
    Set<String> mp = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();
    public void permutation(List<Integer> combi, String c,int [] nums, int s){
        List<Integer> lst = new ArrayList<>(combi);
        if(nums.length==s){
            if(!mp.contains(c)){
                ans.add(lst);
                mp.add(c);
            }
            return;
        }
        int idx=s;
        s++;
        permutation(lst,c,nums,s);
        c=c+nums[idx];
        lst.add(nums[idx]);
        permutation(lst,c,nums,s);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        permutation(new ArrayList<>(),"",nums,0);
        return ans;
    }
}

           