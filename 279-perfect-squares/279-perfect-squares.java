class Solution {
    public int numSquares(int n) {
       
        List<Integer> squares = perfectSquares(n);
        
        int [] cache = new int[n + 1];
        
        Arrays.fill(cache, n + 1);
        
        cache[0] = 0;
        
        for(int i = 1; i <= n; i++){
            for(Integer square: squares){
                if(i >= square){
                    cache[i] = Math.min(cache[i - square] + 1, cache[i]);
                }
            }
        }
        
        return cache[n];
    }
    
    List<Integer> perfectSquares(int n){
        
        List<Integer> squares = new ArrayList<>();
        
        int start = 1;
        
        while(start * start <= n){
            squares.add(start * start);
            start++;
        }
        
        return squares;
    }
}