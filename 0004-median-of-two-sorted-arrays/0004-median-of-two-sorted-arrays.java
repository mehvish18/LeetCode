class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length)/2;
        int partition1 = nums1.length/2, partition2;
        boolean isEven = false;
        if((nums1.length + nums2.length)%2==0)
            isEven = true;
        int num1left,num2left,num1right, num2right;
        while(partition1>=0 && partition1<=nums1.length){
            partition2 = mid - partition1;
            num1left = (partition1>0)?nums1[partition1-1]:Integer.MIN_VALUE;
            num2left = (partition2>0)?nums2[partition2-1]:Integer.MIN_VALUE;
            num1right = (partition1<nums1.length)?nums1[partition1]:Integer.MAX_VALUE;
            num2right = (partition2<nums2.length)?nums2[partition2]:Integer.MAX_VALUE;
            if(num1left<=num2right && num2left<=num1right){
                if(isEven){
                    int  frstHalf = Math.max(num1left,num2left);
                    int  scndHalf = Math.min(num1right,num2right);
                    return (double)(frstHalf+scndHalf)/2;
                }
                else {
                    return Math.min(num1right,num2right);
                }
            }
            else if(num1left>num2right)
                partition1--;
            else
                partition1++;
            
        }
        return 0;
    }
}
/* 
mid = 3
p1=2
p2 =1


1 4 4
2 5 5 6

1 2 4 4 5 5 6 
4.5


mid =4 

p1 = 2
p2 = 2



[1,3]

[2]

p1 = 1
p2 = 0

[1,2]
[3]
p1 = 1
p2= 0


*/