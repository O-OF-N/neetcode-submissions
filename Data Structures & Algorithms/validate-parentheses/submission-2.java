class Solution {
    Map<Character,Character> m = Map.of('[',']', '(', ')', '{', '}');
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i=0;i<n;i++) {
            System.out.println(st);
            char c = s.charAt(i);
            boolean shouldPop = !m.containsKey(c);
            if(st.size()>0) { 
                Character prev = st.pop();
                if(!shouldPop) {
                    st.push(prev);
                    st.push(c);
                    continue;
                } 
                if(c!=m.get(prev)) {
                    return false;
                }
            } else {
                if(shouldPop) {
                    return false;
                }
                st.push(c);
            }
        }
        return st.size()==0;
        
    }
}
