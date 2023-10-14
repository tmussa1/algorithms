class Solution {
    
    public int sumSubarrayMins(int[] arr) {
        
        long mod = 1000000007;
        
        Stack<Integer> stack = new Stack<>();
        
        int right = 0;
        long result = 0;
        
        while(right <= arr.length){
            
            while(!stack.isEmpty() && (right == arr.length || arr[stack.peek()] >= arr[right])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long count = (mid - left) * (right - mid) % mod;
                long sum = (arr[mid] * count);
                result += sum;
                result %= mod;
            }
            
            stack.push(right);
            
            right++;
        }
        
        return ((int) (result % mod));
    }
}