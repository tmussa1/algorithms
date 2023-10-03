class Solution {
    
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        LinkedList<Integer> result = new LinkedList<>();
        
        int index = num.length - 1, carry = 0;
        
        while(index >= 0){
            int val = carry + num[index] + (k % 10);
            result.addFirst(val % 10);
            carry = val / 10;
            k /= 10;
            index--;
        }
        
        int rem = carry + k;
        
        while(rem > 0){
            result.addFirst(rem % 10);
            rem /= 10;
        }
           
        return result;
    }
}