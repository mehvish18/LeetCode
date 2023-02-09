class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> digits = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for(int i=2;i<=N;i++){
            List<Integer> numbers = new ArrayList<>();
            for(int d: digits){
                int y = d%10;
                if(y+K<10)
                    numbers.add(d*10+y+K);
                if(K>0 && y-K>=0)
                    numbers.add(d*10+y-K);
            }
            digits=numbers;
        }
        int [] ans = new int[digits.size()];
        for(int i=0;i<digits.size();i++){
            ans[i]=digits.get(i);
        }
        return ans;
    }
}

    
