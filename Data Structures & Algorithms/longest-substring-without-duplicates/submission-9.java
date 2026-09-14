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
            //System.out.println("i = " + i + " c = " + Character.toString(c) + " currStart= " + currStart + " map = "  +posMap);
            if(posMap.containsKey(c)) {
                int prevPosition = posMap.get(c);
                if(prevPosition>=currStart) {
                    //System.out.println("inside prevPosition = " + prevPosition );
                    maxLength = Math.max(maxLength, i-currStart);
                    //System.out.println("maxLength = " + maxLength);
                    currStart = prevPosition+1;
                } else {
                    //System.out.println("outside prevPosition = " + prevPosition );
                    //currStart = i;
                }
                
            } 
            posMap.put(c,i);
            
        }
        maxLength = Math.max(maxLength, n-currStart);
        //System.out.println("outside maxLength = " + maxLength);
        return maxLength;
        
    }
}
