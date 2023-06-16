class Solution {
    public int[] updateCellStatus(int[] cells){
        int [] newCell = new int[8];
        for(int i=1;i<7;i++){
            if(cells[i-1]==cells[i+1])
                newCell[i] = 1;
        }
        return newCell;
    }
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashSet<String> set = new HashSet<>(); 
        boolean hasCycle=false;
        int i=0;
        for(i=0;i<n;i++){
            int[] next = updateCellStatus(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){
                set.add(key);
            }
            else{
                hasCycle = true;
                break;
            }
            cells = next;   
        }
        if(hasCycle){
            n = n%i;
            for(int j=0;j<n;j++){
                cells = updateCellStatus(cells);
            }   
        }
        return cells;
    }
}
