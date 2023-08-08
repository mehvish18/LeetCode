class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        int [] ans = new int[2];
        while(i<j){
            int sum = numbers[i]+numbers[j];
            //System.out.println(i+" "+j+" "+sum);
            if(sum==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
            else if(sum>target){
                j--;
            }
            else
                i++;
        }
        return ans;
    }
}