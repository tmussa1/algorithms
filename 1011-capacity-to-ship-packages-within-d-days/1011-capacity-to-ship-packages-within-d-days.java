class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        int min = Arrays.stream(weights).max().getAsInt();
        return searchDays(weights, days, min, sum);
    }

    private int searchDays(int[] weights, int days, int left, int right){

        int result = Integer.MAX_VALUE;

        while(left <= right){

            int mid = left + ((right - left) / 2);
            int daysCalculated = countDays(weights, mid);

            if(daysCalculated == days){
                result = Math.min(result, mid);
                right = mid - 1;
            } else if(daysCalculated > days){
                left = mid + 1;
            } else {
                result = Math.min(result, mid);
                right = mid - 1;
            }
        }

        return result;
    }

    int countDays(int[] weights, int mid){

        int index = 0, sum = 0, result = 1;

        while(index < weights.length){
            sum += weights[index];
            if(sum > mid){
                sum = weights[index];
                result++;
            }
            index++;
        }
        return result;
    }
}