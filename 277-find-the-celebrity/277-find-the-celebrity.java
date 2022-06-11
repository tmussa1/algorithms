/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    public int findCelebrity(int n) {
        
        int celebrity = -1, knowsSomeone = 0, knownByAll = 0;
        
        for(int i = 0; i < n; i++){
            
            knowsSomeone = 0;
            knownByAll = 0;
            
            for(int j = 0; j < n; j++){
                if(knows(i, j)){
                    knowsSomeone++;
                }
                if(knows(j, i)){
                    knownByAll++;
                }
            }
            
            if(knowsSomeone == 1 && knownByAll == n) {
                return i;
            }
        }
        
        return celebrity;
    }
}