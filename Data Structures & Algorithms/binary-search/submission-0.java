class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            int mid = left + (right-left)/2;
            int midValue = nums[mid];
            int leftValue = nums[left];
            int rightValue = nums[right];
            if(midValue == target) {
                return mid;
            }
            if (target < midValue) {
                right = mid - 1;
                continue;
            }
            if(target > midValue) {
                left = mid + 1;
            }
        }
        return -1;
        
    }
}
