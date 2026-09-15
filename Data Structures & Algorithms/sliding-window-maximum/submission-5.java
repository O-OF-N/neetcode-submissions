class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> positions = new ArrayDeque<>();
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int curr = nums[i];
            while (!positions.isEmpty() && positions.peekFirst() <= i - k) {
                positions.pollFirst();
            }
            while (!positions.isEmpty()
                    && nums[positions.peekLast()] <= nums[i]) {
                positions.pollLast();
            }
            positions.offerLast(i);
            if (i >= k - 1) {
                result.add(nums[positions.peekFirst()]);
            }
        }
        return result.stream()
                             .mapToInt(Integer::intValue)
                             .toArray();
    }
}
