class Solution {
    private boolean isValid(Map<Character,Integer> required, Map<Character,Integer> actual) {
        for(char k :required.keySet()) {
            int reqCount = required.get(k);
            int actCount = actual.getOrDefault(k,0);
            if(reqCount>actCount) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> required= new HashMap<>();
        Map<Character,Integer> actual= new HashMap<>();
        int matched = 0;
        int left = -1;
        int min = s.length() + 1;
        String minString = "";
        if(t.length()==1) {
            char tChar = t.charAt(0);
            for(int i=0;i<s.length();i++) {
                char sChar = s.charAt(0);
                if(tChar == sChar) {
                    return t;
                }
            }
        }
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            int count = required.getOrDefault(c,0); 
            required.put(c,count+1);
        }
        //System.out.println("required = " + required);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            //System.out.println("starting i = " + i +" C = " + Character.toString(c) + " actual =" + actual + " minString = " + minString);
            int requiredCount = required.getOrDefault(c, 0);
            int actualCount = actual.getOrDefault(c, 0);
            if(requiredCount==0) {
            //System.out.println("Ending 0 C = " + Character.toString(c) + " actual =" + actual + " minString = " + minString +" left = " + left);
                continue;
            } else if(requiredCount > 0) {
                actualCount = actualCount + 1;
            }
            if(left<0) {
                left = i;
                actual.put(c, actualCount);
                while(isValid(required,actual)) {
                    int len = i-left+1;
                    if(len<min) {
                        minString = s.substring(left, i+1);
                        min = minString.length();
                    }
                    char leftChar = s.charAt(left);
                    int leftCharCount = actual.getOrDefault(leftChar, 0);
                    if(leftCharCount-1 <=0) {
                        actual.remove(leftChar);
                    } else {
                        actual.put(leftChar,leftCharCount-1);
                    }
                    left++;
                }
                
            }
            else if(actualCount >= requiredCount) {
                actual.put(c, actualCount);
                while(isValid(required,actual)) {
                    int len = i-left+1;
                    if(len<min) {
                        minString = s.substring(left, i+1);
                        min = minString.length();
                    }
                    char leftChar = s.charAt(left);
                    int leftCharCount = actual.getOrDefault(leftChar, 0);
                    if(leftCharCount-1 <=0) {
                        actual.remove(leftChar);
                    } else {
                        actual.put(leftChar,leftCharCount-1);
                    }
            //System.out.println("Contributed to Ending 3");
                    left++;
                }
            } else if(actualCount < requiredCount){
                actual.put(c, actualCount);
            } 
            //System.out.println("Ending 3 C = " + Character.toString(c) + " actual =" + actual + " minString = " + minString +" left = " + left);
        }
        return minString;
    }
}
