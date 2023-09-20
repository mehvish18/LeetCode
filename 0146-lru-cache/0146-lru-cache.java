class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> mp = new LinkedHashMap<Integer,Integer>();
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(mp.get(key)==null)
            return -1;
        int val = mp.get(key);
        mp.remove(key);
        mp.put(key,val);
        return val;
    }
    
    public void put(int key, int value) {
        if(mp.get(key)==null && mp.size()==cap){
            for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
                System.out.println(entry.getKey());
                mp.remove(entry.getKey());
                break;
            }
        } else{
             mp.remove(key);
        }
        mp.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 
2: 3
1: 1
 
 
 
 
 
 */