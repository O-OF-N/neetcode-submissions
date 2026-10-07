class Solution {

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int lastPos = matrix[0].length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            System.out.println("left = " + left + " right = " + right + "mid = " + mid);
            System.out.println(" value = " + Arrays.toString(matrix[mid]) + " last Pos = " + lastPos);
            int midValue = matrix[mid][lastPos];
            System.out.println("midValue = " + midValue + " target = " +target );
            if(midValue == target || (mid ==0 && midValue>target) || (mid>0 && matrix[mid-1][lastPos] < target &&  midValue>target)) {
                return mid;
            } 
            if(midValue<target) {
                left = mid+1;
                continue;
            }
            if(midValue>target) {
                right = mid-1;
                continue;
            }
        }
        return -1;
    }

    private int findCol(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            int midValue = matrix[mid];
            if(midValue == target) {
                return mid;
            } 
            if(midValue<target) {
                left = mid+1;
                continue;
            }
            if(midValue>target) {
                right = mid-1;
                continue;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = findRow(matrix, target);
        System.out.println("row index= " + rowIndex);
        if(rowIndex == -1) {
            return false;
        }
        int colIndex = findCol(matrix[rowIndex], target);
        if(colIndex == -1) {
            return false;
        }
        return true;
    }
}
