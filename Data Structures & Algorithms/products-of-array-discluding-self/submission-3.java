class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] productLeft = new int[n];
        int[] productRight = new int[n];
        int[] result = new int[n];
        int productSoFar = 1;
        for (int i=0;i<n;i++) {
            int num = nums[i];
            productLeft[i] = num * productSoFar;
            productSoFar = productLeft[i] ;
        }
        productSoFar = 1;
        for (int i=n-1;i>=0;i--) {
            int num = nums[i];
            productRight[i] = num * productSoFar;
            productSoFar = productRight[i] ;
        }
        System.out.println("Left = " + Arrays.stream(productLeft)
                           .boxed()
                           .collect(Collectors.toList()));
        System.out.println("Right = " + Arrays.stream(productRight)
                           .boxed()
                           .collect(Collectors.toList()));
        for(int i=0; i < n; i++) {
            int left = 1;
            int right = 1;
            if(i>0) {
                left = productLeft[i-1];
            }
            if(i<n-1) {
                right = productRight[i+1];
            }
            result[i] = left * right;
        }
        return result;
    }
}  
