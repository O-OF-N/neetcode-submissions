class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int[] chars= new int[26];
            for(int i=0;i<str.length();i++) {
                char c = str.charAt(i);
                chars[c-'a'] += 1;
            }
            String charStr = Arrays.toString(chars);
            List<String> a = anagrams.getOrDefault(charStr, new ArrayList<>());
            a.add(str);
            anagrams.put(charStr, a);
        }
        return new ArrayList(anagrams.values());
    }
}
