class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        int maxLength = 0;
        int currStart = 0;
        int n = s.length();
        if(n==1) {
            return 1;
        }
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            int prevPosition = posMap.getOrDefault(c, -1);
            if(prevPosition>=currStart) {
                maxLength = Math.max(maxLength, i-currStart);
                currStart = prevPosition+1;
                
            } 
            posMap.put(c,i);
            
        }
        maxLength = Math.max(maxLength, n-currStart);
        return maxLength;
        
    }
}
