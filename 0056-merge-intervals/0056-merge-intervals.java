class Solution {
    
    
    public int[][] merge(int[][] intervals) {
        
        List<int []> result = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        result.add(intervals[0]);
        
        int prevEnd = 0;
        
        for(int i = 1; i < intervals.length; i++){
            
            int start = result.get(result.size() - 1)[0];
            prevEnd = result.get(result.size() - 1)[1];
            
            if(intervals[i][0] <= prevEnd){
                prevEnd = Math.max(intervals[i][1], prevEnd);
                int [] interval = new int[2];
                interval[0] = start;
                interval[1] = prevEnd;
                result.set(result.size() - 1, interval);
            } else {
                result.add(intervals[i]);
            } 
        }
        
        return result.stream().toArray(int[][]::new);
    }
}