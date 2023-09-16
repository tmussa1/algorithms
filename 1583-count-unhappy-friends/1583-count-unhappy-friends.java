class Solution {
    
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int [] pairMap = new int[n];
        
        int result = 0;
        
        for(int [] pair: pairs){
            pairMap[pair[0]] = pair[1];
            pairMap[pair[1]] = pair[0];
        }
        
        for(int i = 0; i < n; i++){
            
            int currentFriend = i;
            int [] preference = preferences[i];
            int partner = pairMap[currentFriend];
            
            for(int j = 0; j < preference.length; j++){
                
                int friend = preference[j];
                
                if(friend == partner){
                   break;
                }
                
                int friendPartner = pairMap[friend];
                int [] friendPreference = preferences[friend];
                
                if(findIndex(friendPreference, currentFriend) < findIndex(friendPreference, friendPartner)){
                    result++;
                    break;
                }
            }
        }
        
        return result;
    }
    
    private int findIndex(int [] friendPreference, int target){
        for(int i = 0; i < friendPreference.length; i++){
            if(friendPreference[i] == target){
                return i;
            }
        }
        return -1;
    }
}