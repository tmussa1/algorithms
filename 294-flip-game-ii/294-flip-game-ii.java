class Solution {
    
    public boolean canWin(String currentState) {
        return canWin(new StringBuilder(currentState), new HashMap<String, Boolean>());
    }
    
    private boolean canWin(StringBuilder currentState, Map<String, Boolean> memo){
        
        String key = currentState.toString();
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        for(int i = 0; i < currentState.length() - 1; i++){

            String temp2 = currentState.substring(i, i + 2);

            if(temp2.equals("++")){
                
                currentState.replace(i, i + 2, "--");
                
                if(!canWin(currentState, memo)){
                    currentState.replace(i, i + 2, temp2);
                    memo.put(key, true);
                    return true;
                }
                currentState.replace(i, i + 2, temp2);
            }
        }
        
        memo.put(key, false);
        return memo.get(key);
    }
}