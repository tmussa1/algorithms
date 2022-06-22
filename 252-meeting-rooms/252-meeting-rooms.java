class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < intervals.length - 1; i++){
            
            int [] first = intervals[i];
            int [] second = intervals[i + 1];
            
            if(first[0] < second[0] && (first[1] >= second[1] || first[1] > second[0])){
                return false;
            }
            
            if(first[0] == second[0]){
                return false;
            }
        }
        
        return true;
    }
}