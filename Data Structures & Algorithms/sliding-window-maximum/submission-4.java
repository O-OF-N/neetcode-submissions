class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> positions = new ArrayDeque<>();
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int curr = nums[i];
            while(positions.size()>0) {
                int pos= positions.peekLast();
                int value = nums[pos];
                if(curr>value || pos<i-k) {
                    positions.pollLast();
                } else {
                    break;
                }
            }
            positions.offer(i);
            if(i>=k-1) {
                while(positions.size()>0) {
                    if(positions.peekFirst()>i-k){
                        result.add(nums[positions.peekFirst()]);
                        break;
                    } else{
                        positions.pollFirst();
                    }
                }
            }
        }
        return result.stream()
                             .mapToInt(Integer::intValue)
                             .toArray();
    }
}
