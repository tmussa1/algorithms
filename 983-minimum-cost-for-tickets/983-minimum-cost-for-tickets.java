class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {
        
        int max = days[days.length - 1];
        
        int [] cache = new int[max + 1];
        
        Arrays.fill(cache, Integer.MAX_VALUE);
        
        Set<Integer> daySet = new HashSet<Integer>();
        
        for(Integer day: days){
            daySet.add(day);
        }
        
        cache[0] = 0;
        
        for(int i = 1; i <= max; i++){
            
            if(daySet.contains(i)){
            
                cache[i] = Math.min(cache[Math.max(i - 1, 0)] + costs[0], cache[i]);
                cache[i] = Math.min(cache[Math.max(i - 7, 0)] + costs[1], cache[i]);
                cache[i] = Math.min(cache[Math.max(i - 30, 0)]+ costs[2], cache[i]);
            } else {
                cache[i] = cache[i - 1];
            }
        }
        
        return cache[max];
    }
}