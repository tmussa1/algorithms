class Solution {
    
    public int countPrimes(int n) {
        
        if(n < 2) return 0;
        
        boolean [] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                for(int j = i + i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        
        for(boolean prime: isPrime){
            if(prime){
                count++;
            }
        }
        
        return count - 2;
    }
}