class Solution {
    Map<Character,Integer> seen = new HashMap<>();
    public boolean isAnagram(String s, String t) {

        for(char c : s.toCharArray()) {
            int count = seen.getOrDefault(c, 0);
            seen.put(c, count+1);
        }
        for(char c : t.toCharArray()) {
            if(!seen.containsKey(c)) {
                return false;
            }
            int count = seen.getOrDefault(c, 0);
            if(count-1<=0) {
                seen.remove(c);
            } else {
                seen.put(c, count-1);
            }
        }
        return seen.size()==0;
    }
}
