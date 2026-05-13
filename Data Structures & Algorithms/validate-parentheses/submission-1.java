class Solution {
    Map<Character,Character> m = Map.of('[',']', '(', ')', '{', '}');
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i=0;i<n;i++) {
            System.out.println(st);
            char c = s.charAt(i);
            boolean shouldPop = !m.containsKey(c);
            System.out.println("shouldPop = " + shouldPop + " c = " + c);
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
        System.out.println(st);
        return st.size()==0;
        
    }
}
