
class Solution {
   
    public int trap(int[] height) {
        int n = height.length;
        int[] tallestRightAtPoint = new int[n];
        int[] tallestLefttAtPoint = new int[n];
        int[] maxWater = new int[n];
        int tallestSoFar = 0;
        for(int i=n-1;i>=1;i--) {
            int currHeight = height[i];
            tallestSoFar = Math.max(currHeight, tallestSoFar);
            tallestRightAtPoint[i-1] = tallestSoFar;
        }
        tallestSoFar = 0;
        for(int i=0;i<n-1;i++) {
            int currHeight = height[i];
            tallestSoFar = Math.max(currHeight, tallestSoFar);
            tallestLefttAtPoint[i+1] = tallestSoFar;
        }
        //System.out.println(Arrays.toString(tallestLefttAtPoint));
        //System.out.println(Arrays.toString(tallestRightAtPoint));
        for(int i=0;i<n;i++) {
            int currHeight = height[i];
            int leftHeight = tallestLefttAtPoint[i];
            int rightHeight = tallestRightAtPoint[i];
            maxWater[i] = Math.max(0, Math.min(leftHeight, rightHeight)-currHeight);

        }
        int totalWater = 0;
        for(int water:maxWater) {
            totalWater += water;
        }
        //System.out.println(Arrays.toString(maxWater));
        return totalWater;
    }
        
}
