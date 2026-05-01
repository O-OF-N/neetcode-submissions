class Solution {
    Map<Integer,List<Integer>> counts = new HashMap<>();
    private int[] getResult(int n, int req) {
        if (n<req) {
            return new int[]{n, req};
        } else {
            return new int[]{req, n};
        }
    }
    public int[] twoSum(int[] nums, int target) {

        for (int i=0;i<nums.length; i++) {
            int n = nums[i];
            List<Integer> count= counts.getOrDefault(n , new ArrayList<>());
            count.add(i);
            counts.put(n, count);
        }

        for (int i=0;i<nums.length; i++) {
            int n = nums[i];
            int req = target - n;
            List<Integer> numCount= counts.getOrDefault(n , new ArrayList<>());
            List<Integer> reqCount= counts.getOrDefault(req , new ArrayList<>());
            System.out.println("numCount = " + numCount);
            System.out.println("reqCount = " + reqCount);
            if(req == n) {
                if (numCount.size()>1) {
                    return getResult(i, numCount.get(1));
                }
            } else {
                if(reqCount.size()>0) {
                    return getResult(i, reqCount.get(0));
                }
            }
        }
        return new int[]{};
        
    }
}
