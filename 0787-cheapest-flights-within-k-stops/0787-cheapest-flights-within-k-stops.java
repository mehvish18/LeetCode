class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i = 0 ; i< n;i++){
            graph[i] = new ArrayList<int[]>();
        }
        for(int[] flight: flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[]{to,price});
        }
        //dijkstra algorithm
        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        int[] stops = new int[n];
        Arrays.fill(stops,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->{
            return a.price - b.price;
        });
        //from src to src, price:0 stop:0
        queue.offer(new Pair(src,0,0));
        prices[src] = 0;
        stops[src] = 0;
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int city = cur.city;
            int stop = cur.stop;
            int price = cur.price;
            if(city == dst){
                return price;
            }
            if(stop >= k+1){
                continue;
            }
            
            for(int[] neighbor:graph[city]){
                int next = neighbor[0];
                int priceTo = neighbor[1];
                if(priceTo + price < prices[next]){
                    prices[next] = priceTo + price;
                    stops[next] = stop + 1;
                    queue.offer(new Pair(next,stop+1,priceTo + price));
                }
                else if(priceTo + price > prices[next] && stop + 1 > stops[next]){
                    continue;
                }
                else if(stop + 1 < stops[next]){
                    queue.offer(new Pair(next,stop+1,priceTo + price));

                }
            }
        }
        return -1;

        
    }
    
}
class Pair{
    int city;
    int stop;
    int price;
    Pair(int city, int stop, int price){
        this.city = city;
        this.stop = stop;
        this.price = price;
    }
}