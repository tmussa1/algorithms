class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int left = 0, right = people.length - 1, boats = 0;
        
        while(right >= left){
            
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else {
                right--;
            }
            
            boats++;
        }
        
        return boats;
    }
}