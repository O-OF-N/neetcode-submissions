class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> reqCount = new HashMap<>();
        Map<Character,Integer> currCount = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();
        int l =0;
        int r = 0;
        for(int i=0;i<n1;i++) {
            char c = s1.charAt(i);
            int count = reqCount.getOrDefault(c, 0);
            reqCount.put(c, count+1);
        }

        while(true) {
            char curr = s2.charAt(r);
            //System.out.println("curr = " + curr);
            if (!reqCount.containsKey(curr)) {
                r++;
                l = r;
                currCount = new HashMap<>();
            } else {
                int count = currCount.getOrDefault(curr , 0);
                int req = reqCount.get(curr);
                if(count+1 > req) {
                    while(l<r) {
                        char leftChar = s2.charAt(l);
                        int leftCharCount = currCount.get(leftChar);
                        l++;
                        currCount.put(leftChar, leftCharCount-1);
                        if(currCount.getOrDefault(curr,0)<=req) {
                            break;
                        }
                    }
                } else {
                    currCount.put(curr, count+1);
                    //System.out.println(currCount);
                    if(currCount.equals(reqCount)){
                        return true;
                    } else {
                        r++;
                    }
                }
            }
            if(r>=n2) {
                return false;
            }
        }        
    }
}
