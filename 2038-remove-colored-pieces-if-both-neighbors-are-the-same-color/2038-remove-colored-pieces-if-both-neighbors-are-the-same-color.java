class Solution {
    
    public boolean winnerOfGame(String colors) {
        
        int index = 0, alice = 0, bob = 0;
        
        char [] colorsList = colors.toCharArray();
        
        while(index < colors.length() - 2){
            
            if(colorsList[index] == colorsList[index + 1] && colorsList[index + 1] == colorsList[index + 2]){
                if(colorsList[index] == 'A'){
                    alice++;
                } else {
                    bob++;
                }
            }
            
            index++;
        }
        
        return alice > bob;
    }
}