class Solution {
    public int findTheWinner(int n, int k) {
        
        LinkedList<Integer> numList = new LinkedList<Integer>();
        
        for(int i = 1; i <= n; i++){
            numList.addLast(i);
        }
        
        int index = k - 1;
        
        while(numList.size() > 1){
            
            Integer num = numList.get(index);
            
            numList.remove(num);
            
            index += (k - 1);
            index = index % numList.size();
        }
        
        return numList.get(0);
    }
}