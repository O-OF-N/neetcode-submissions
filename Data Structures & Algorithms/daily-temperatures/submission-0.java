class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            int value = temperatures[i];
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && value > temperatures[stack.peek()]) {
                    int pos = stack.pop();
                    result[pos] = i-pos;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
