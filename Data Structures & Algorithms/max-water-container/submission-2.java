class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        int maxArea = 0;
        while(l<r) {
            int leftHeight = heights[l];
            int rightHeight =  heights[r];
            int height = Math.min(leftHeight, rightHeight);
            int area = (r-l) * height;
            //System.out.println("l = " + l + " r = " + r + " lh = " + leftHeight + " rh = " + rightHeight + " area = " + area);
            maxArea = Math.max(area,maxArea);
            if(leftHeight<=rightHeight) {
                l++;
            } else if(rightHeight<leftHeight) {
                r--;
            }
        }
        return maxArea;
    }
}
