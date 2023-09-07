class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int length = nums.length;
        int [] result = new int [length - k + 1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int left = 0, count = 0;

        while(left < nums.length){

            if(!queue.isEmpty() && queue.peekFirst() < left - k + 1) queue.pollFirst();

            while(!queue.isEmpty() && nums[left] > nums[queue.peekLast()]){
                queue.pollLast();
            }

            queue.addLast(left);

            if(left >= k - 1){
                result[count++] = nums[queue.peekFirst()];
            }

            left++;
        }

        return result;
    }
}