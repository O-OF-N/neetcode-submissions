class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> minMax = new HashMap<>();
        Set<Integer> allElements = new HashSet<>();
        Set<Integer> evaluated = new HashSet<>();
        for(int i=0;i<n;i++) {
            int num = nums[i];
            allElements.add(num);
        }
        for(int i=0; i < n;i++) {
            int num = nums[i];
            if(evaluated.contains(num)) {
                continue;
            } 
            int nextNum = num+1;
            if(minMax.containsKey(nextNum)) {
                int max= minMax.get(nextNum); 
                minMax.remove(nextNum);
                minMax.put(num , max);
                continue;
            }
            int max = num;
            while(allElements.contains(max)) {
                evaluated.add(max);
                max = max+1;
            }
            minMax.put(num, max-1);
        }
        int maxLength = 0;
        Set<Integer> allMinValues = minMax.keySet();
        for(int minValue:allMinValues) {
            int maxValue = minMax.get(minValue);
            int length = maxValue - minValue + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
