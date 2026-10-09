class Solution {
    
    public int findMin(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        int i=0;
        while(left<right) {
            System.out.println("left = " + left + " right = " + right);
            int mid = left + (right-left)/2;
            int midValue = nums[mid];
            int numLeft = nums[left];
            int numRight = nums[right];
            if(midValue>numRight) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
    
}
