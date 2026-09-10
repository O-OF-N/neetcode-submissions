class Solution {
    public boolean isPalindrome(String s) {
        List<Character> charList = new ArrayList<>();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                charList.add(ch);
            }
        }

        int i = 0;
        int j = charList.size()-1;
        while(i<j){
            char charI = charList.get(i);
            char charJ = charList.get(j);
            System.out.println("charI = " + charI);
            System.out.println("charJ = " + charJ);
            if(charI == charJ) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
