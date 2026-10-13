class Solution {
    private int findPos(int[] nums, int left, int right, int target) {
        for(int i=left;i<=right;i++) {
            if(nums[i]==target) {
                return i;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if(nums.length==1) {
            if(nums[0]==target) {
                return 0;
            } else {
                return -1;
            }
        }
        int left = 0; 
        int right = nums.length-1;
        int i=0;
        int foundMid = -1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            System.out.println("left = " + left +" right = " + right + " mid = " +mid) ;
            if(mid-1>=0 && mid+1<=right && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]) {
                foundMid = mid;
                break;
            } else if(mid-1>=0 && nums[left] >nums[mid-1]) {
                right = mid -1;
            } else if(mid+1<=right &&nums[mid+1] > nums[right]) {
                left = mid+1;
            } else {
                if(nums[left] >nums[right]) {
                    left = mid+1;
                } else {
                    foundMid = left;
                    break;
                }
            }
            if(i++>10) {
                break;
            }
        }
        if(foundMid>0) {
            int leftSegment1 = 0;
            int rightSegment1 = foundMid-1;
            int leftSegment2 = foundMid;
            int rightSegment2 = nums.length-1;
            if(target>=nums[leftSegment1] && target<=nums[rightSegment1]){
                return findPos(nums, leftSegment1, rightSegment1, target);
            } else if(target>=nums[leftSegment2] && target<=nums[rightSegment2]) {
                return findPos(nums, leftSegment2, rightSegment2, target);
            }
        } else {
            return findPos(nums, 0, nums.length-1, target);
        }
        return -1;
        
    }
}
