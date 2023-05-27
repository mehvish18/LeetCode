class Solution {
    public int minCostClimbingStairs(int[] cost) {
       	int n = cost.length;
	    int first = cost[0];
	    int second = cost[1];
	    if (n<=2) return Math.min(first, second);
	    for (int i=2; i<n; i++) {
		    int curr = cost[i] + Math.min(first, second);
		    first = second;
		    second = curr;
	    }
	return Math.min(first, second);
    }
}

/*

10 20 15

0  1  2
10 10 10

curr = 25
first = 25
second curr




0  1  2  3

0 10 10  15+10, 15+10, 20+10, 20+0



0  1           2  
10 min(10,15)  20+10
               20+10
               15+10
               15+0
               
               
               
[1,100,1,1,1,100,1,1,100,1]
 0 1   2 3 4. 5. 6 7  8. 9
 
 0 1 2 3 4 5 6 7 8 9 10
 0 1 1 2 3 2 4 3 5 8 6


10 15 20

0 -> 1 step top
10
-----------------
0 -> 2steps top
10

0 -> 1 -> 1step top
10+15 =25

1-> 1step top
15

min = 10
------------------
0->1->2-> 1step top (10+15+20) = 45
0->1-> 2steps top (10+15) = 25
0->2-> 1step top (10+20) = 30
1->2-> 1step top (15+20) = 35
1-> 2step top (15) = 15

min = 15





*/


