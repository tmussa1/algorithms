class Solution {
    
    public double myPow(double x, int n) {
        
        Map<String, Double> cache = new HashMap<>();
        
        if(n == 0) return 1.0;
        
        long num = ((long) n);
        
        if(n < 0){
            return pow(1 / x, Math.abs(num), cache);
        }
        
        return pow(x, num, cache);
    }
    
    private double pow(double x, long n, Map<String, Double> cache) {
        
        String key = x + "," + n;
        
        if(n <= 1){
            return x;
        }
        
        if(cache.containsKey(key)) return cache.get(key);
        
        if(n % 2 == 1){
            double res = x * pow(x, n / 2, cache) * pow(x, n / 2, cache);
            cache.put(key, res);
            return res;
        }
        
        double res = pow(x, n / 2, cache) * pow(x, n / 2, cache);
        cache.put(key, res);
        return res;
    }
}