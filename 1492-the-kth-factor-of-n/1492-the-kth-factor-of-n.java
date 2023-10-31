import java.util.*;

class Solution {
    
    public int kthFactor(int n, int k) {
        
        if(n <= 1) return n;
        
        TreeSet<Integer> factors = new TreeSet<>();
        factors.add(1);
        
        for(int i = 2; i <= n; i++){
            
            if(n % i == 0 && !factors.contains(i)){
                
                int num = i;
                
                while(num <= n){
                    if(n % num == 0){
                       factors.add(num);
                    }
                    num *= 2;
                }
                
            }
            
            NavigableSet<Integer> facts = factors.headSet(i, true);
            
            if(facts.size() >= k){
                
                Iterator<Integer> iter = facts.iterator();
                
                int count = 0;
                
                while(count < k && iter.hasNext()){
                    count++;
                    int val = iter.next();
                    
                    if(count == k){
                        return val;
                    }
                }
            }
        }
        
        return -1;
    }
}