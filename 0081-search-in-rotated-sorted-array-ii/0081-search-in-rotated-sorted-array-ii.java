class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while(left <= right){

            while(left < right && nums[left] == nums[left + 1]){
                left++;
            }

            while(right > left && nums[right] == nums[right - 1]){
                right--;
            }

            int mid = left + ((right - left) / 2);

            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] <= nums[right]){

                if(target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {

                if(target <= nums[mid] && target >= nums[left]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}