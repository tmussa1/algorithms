class Solution {
    
    public double soupServings(int n) {
        
        if(n == 0) return 0.5;
        
        if(n < 25) return 2.5 / 4;
        
        int num = (n / 25) + (n % 25 == 0 ? 0 : 1);
        
        Map<String, Double> memo = new HashMap<>();
        
        for(int i = 1; i <= num; i++){
            if(soupServings(i, i, memo) > 1 - 1e-5){
                return 1.0;
            }
        }
        
        return soupServings(num, num, memo);
    }
    
    private double soupServings(int soupA, int soupB, Map<String, Double> memo) {
        
        if(soupA <= 0 && soupB <= 0){
            return 0.5;
        }
        
        if(soupA <= 0){
            return 1.0;
        }
        
        if(soupB <= 0){
            return 0.0;
        }
        
          
        String key = soupA + "," + soupB;
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        double first = soupServings(Math.max(soupA - 4, 0), Math.max(soupB, 0), memo);
        double second = soupServings(Math.max(soupA - 3, 0), Math.max(soupB - 1, 0), memo);
        double third = soupServings(Math.max(soupA - 2, 0), Math.max(soupB - 2, 0), memo);
        double fourth = soupServings(Math.max(soupA - 1, 0), Math.max(soupB - 3, 0), memo);
        
        double res = 0.25 * (first + second + third + fourth);
        
        memo.put(key, res);
        
        return res;
    }
}