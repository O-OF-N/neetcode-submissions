class Solution {
    String delimiter = "\u001F";
    String blank = "␟";
    public String encode(List<String> strs) {
        if(strs.size()==0) {
            return "\u0000";
        }
        List<String> s2 = strs.stream().map(s->s.length()==0?blank:s).toList();
        return String.join(delimiter, s2);
    }

    public List<String> decode(String str) {
        if(str.equals("\u0000")) return new ArrayList<>();
        List<String> result =  Arrays.asList(str.split(delimiter, -1));
        return result.stream().map(s->s.equals(blank)?"":s).toList();
    }
}