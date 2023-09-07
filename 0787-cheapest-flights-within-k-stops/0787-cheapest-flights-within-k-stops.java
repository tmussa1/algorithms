class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int [] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;

        int result = Integer.MAX_VALUE;

        for(int i = 0; i <= k; i++){

            int [] temp = prices.clone();

            for(int j = 0; j < flights.length; j++){

                int from = flights[j][0];
                int to = flights[j][1];
                int price = flights[j][2];

                if(prices[from] == Integer.MAX_VALUE){
                    continue;
                }

                if(prices[from] + price < temp[to]){
                    temp[to] = prices[from] + price;
                }
            }

            result = Math.min(result, temp[dst]);

            prices = temp;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}