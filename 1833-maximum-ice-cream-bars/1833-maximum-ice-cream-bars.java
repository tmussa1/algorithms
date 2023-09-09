class Solution {
    
    public int maxIceCream(int[] costs, int coins) {
        
        int max = Arrays.stream(costs).max().getAsInt();
        int min = Arrays.stream(costs).min().getAsInt();
        
        if(coins < min) return 0;
        
        int [] count = new int[max + 1];
        
        for(int cost: costs){
            count[cost]++;
        }
        
        int result = 0, index = 0;
        
        while(coins > 0 && index <= max){
            
            int sum = 0;
            int counter = 0;
    
            while(coins >= sum + index && counter < count[index]){
                sum += index;
                counter++;
            }
            
            result += counter;
            coins -= sum;
            index++;
        }
        
        return result;
    }
}