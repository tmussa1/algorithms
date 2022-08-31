class Solution {
    
    enum Player {
        PLAYER_1, PLAYER_2
    }
    
    public boolean canWin(String currentState) {
        return canWin(new StringBuilder(currentState), new Boolean [currentState.length()], Player.PLAYER_1);
    }
    
    private boolean canWin(StringBuilder currentState, Boolean [] memo, Player player){
        
        for(int i = 0; i < currentState.length() - 1; i++){

            String temp2 = currentState.substring(i, i + 2);

            if(temp2.equals("++")){
                
                currentState.replace(i, i + 2, "--");

                if(!canWin(currentState, memo, player == Player.PLAYER_2 ? Player.PLAYER_1 : Player.PLAYER_2)){
                    currentState.replace(i, i + 2, temp2);
                    return true;
                }
                
                currentState.replace(i, i + 2, temp2);
            }
        }
        
        return false;
    }
}