class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        
        if(intervals == null || intervals.length == 0) {
            int [] [] intervalResult = new int [1] [2];
            intervalResult[0] = newInterval;
            return intervalResult;
        }
            
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < intervals.length; i++){
            queue.offer(intervals[i]);
        }
        
        List<int []> result = new ArrayList<>();
        
        boolean overlapped = false;
        
        while(!queue.isEmpty()){
            
            int [] curr = queue.poll();
            
            if(newInterval[0] >= curr[0] && curr[1] >= newInterval[1]){
                result.add(curr);
                overlapped = true;
                continue;
            }
            
            if(curr[0] >= newInterval[0] && curr[0] <= newInterval[1]){
                
                overlapped = true;
                
                int first = newInterval[0];
                
                int last = Math.max(curr[1], newInterval[1]);
                
                while(!queue.isEmpty() && queue.peek()[0] <= newInterval[1]){
                    last = queue.poll()[1];
                }
                
                result.add(new int [] {first, Math.max(last, newInterval[1])});
                
            } else if(curr[1] >= newInterval[0] && curr[1] <= newInterval[1]){
                
                overlapped = true;
                
                int first = curr[0];
                
                int last = newInterval[1];
                
                while(!queue.isEmpty() && newInterval[1] >= queue.peek()[0]){
                    last = queue.poll()[1];
                }
                
                result.add(new int [] {first, Math.max(last, newInterval[1])});
            } else {
                result.add(curr);
            }
        }
        
        if(!overlapped){
            result.add(newInterval);
        }
        
        Set<String> set = new HashSet<>();
        
        List<int []> res = new ArrayList<>();
        
        for(int i = 0; i < result.size(); i++){
            if(!set.contains((result.get(i)[0] + "," + result.get(i)[1]))){
                res.add(result.get(i));
            }
            set.add((result.get(i)[0] + "," + result.get(i)[1]));
        }
        
        Collections.sort(res, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int [] [] resultArray = new int [res.size()] [2];
        
        for(int i = 0; i < res.size(); i++){
            resultArray[i] = res.get(i);
        }
        
        return resultArray;
    }
}