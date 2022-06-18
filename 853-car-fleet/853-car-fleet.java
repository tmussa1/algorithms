class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
            
        Map<Integer, Integer> indexToPositionMap = new HashMap<>();
        Stack<Double> monoStack = new Stack<>();
        
        for(int i = 0; i < position.length; i++){
            indexToPositionMap.put(position[i], i);
        }
        
        Arrays.sort(position);
        
        double [] time = new double[position.length];
        
        for(int i = 0; i < position.length; i++){
             time[i] = (1.0 * (target - position[i]))/speed[indexToPositionMap.get(position[i])];
        }
        
        int index = position.length - 1;
        
        while(index >= 0){
           
            if(monoStack.isEmpty() || time[index] > monoStack.peek()){
                monoStack.push(time[index]);
            }
            
            index--;
        }
        
        return monoStack.size();
    }

}