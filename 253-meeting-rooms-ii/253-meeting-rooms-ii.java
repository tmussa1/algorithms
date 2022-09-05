class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        
        int [] startTimes = new int[intervals.length];
        int [] endTimes = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int result = 0, currentConfRooms = 0, startIndex = 0, endIndex = 0;
        
        while(startIndex < intervals.length){
            
            if(startTimes[startIndex] < endTimes[endIndex]){
                currentConfRooms++;
                startIndex++;
            } else {
                currentConfRooms--;
                endIndex++;
            }
            
            result = Math.max(result, currentConfRooms);
        }
        
        return result;
    }
}