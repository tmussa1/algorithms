class Solution {
    
    public boolean makesquare(int[] matchsticks) {
        
        int [] sides = new int[4];
        
        int sum = Arrays.stream(matchsticks).sum();
        
        if(sum % 4 != 0) return false;
        
        Arrays.sort(matchsticks);
        
        int target = sum / 4;
        
        Integer [] matchstickArr = new Integer[matchsticks.length];
        
        for(int i = 0; i < matchsticks.length; i++){
            matchstickArr[i] = matchsticks[i];
        }
        
        Arrays.sort(matchstickArr, (a, b) -> b - a);
        
        return isPossible(matchstickArr, sides, 0, target);
    }
    
    private boolean isPossible(Integer[] matchsticks, int [] sides, int i, int target){
        
        if(i == matchsticks.length){
           for(int j = 0; j < 4; j++){
              if(sides[j] != target){
                  return false;
              }
           }
            return true;
        }
        
            
        for(int j = 0; j < 4; j++){

            if(matchsticks[i] + sides[j] <= target){

                sides[j] += matchsticks[i];

                if(isPossible(matchsticks, sides, i + 1, target)){
                    return true;
                }

                sides[j] -= matchsticks[i];
            }
        }
        
        return false;
    }
}