class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, h= numbers.length-1;
        int [] ans = new int[2];
        while(l<h){
            int sum = numbers[l]+numbers[h];
            if(sum==target){
                ans[0]=l+1;
                ans[1]=h+1;
                return ans;
            }
            else if(sum<target){
                l++;
            }   
            else{
                h--;
            }
        }
        return ans;
    }
}