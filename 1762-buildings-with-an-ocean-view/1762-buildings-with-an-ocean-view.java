class Solution {
    
    public int[] findBuildings(int[] heights) {
        
        List<Integer> lst = new ArrayList<>();
        lst.add(heights.length - 1);
        
        int max = heights[heights.length - 1];
        
        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i] > max){
                max = heights[i];
                lst.add(i);
            } 
        }
        
        Collections.reverse(lst);
        
        int [] result = new int[lst.size()];
        int count = 0;
        
        for(Integer num: lst){
            result[count++] = num;
        }
        
        return result;
    }
}