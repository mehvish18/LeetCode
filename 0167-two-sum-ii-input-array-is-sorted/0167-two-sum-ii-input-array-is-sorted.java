class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        int [] ans = new int[2];
        while(l<r){
            int a = numbers[l];
            int b = numbers[r];
            if(a+b==target){
                ans[0]=l+1;
                ans[1]=r+1;
                return ans;
            }
            if(a+b>target)
                r--;
            else
                l++;
        }
        return ans;
    }
}