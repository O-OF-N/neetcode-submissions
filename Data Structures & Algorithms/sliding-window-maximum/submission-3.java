class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        Deque<Integer> positions = new ArrayDeque<>();
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int curr = nums[i];
            while(positions.size()>0) {
                int pos= positions.peekLast();
                //System.out.println("pos = " + pos + " curr = " + curr +" dq inside = " + positions);
                int value = nums[pos];
                if(curr>value || pos<i-k) {
                    positions.pollLast();
                } else {
                    break;
                }
            }
            positions.offer(i);
            if(i>=k-1) {
                //System.out.println("dq final = " + positions);
                while(positions.size()>0) {
                    ///System.out.println("positions.peekFirst() = " + positions.peekFirst() + " i = " + i + " i-k = " + (i-k));
                    if(positions.peekFirst()>i-k){
                        result.add(nums[positions.peekFirst()]);
                        break;
                    } else{
                        positions.pollFirst();
                    }
                }
                //System.out.println("dq final after= " + positions);
            }
        }
        return result.stream()
                             .mapToInt(Integer::intValue)
                             .toArray();
    }
}
