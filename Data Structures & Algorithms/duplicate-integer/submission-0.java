class Solution {
    Set<Integer> seen = new HashSet<>();
    public boolean hasDuplicate(int[] nums) {
        for (int num : nums) {
            if(!seen.add(num)){
                return true;
            }
        }
        return false;
    }
}