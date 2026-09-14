class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int row = 0; row < matrix.length; row++){

            int ans = binarySearch(matrix[row], target);
            if(ans!=(-1)){
                return true;
            }
        }
        return false;
    }

    static int binarySearch(int[] row, int target){

        int start = 0;
        int end = row.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(row[mid] == target){
                return mid;
            }
            else if(row[mid] < target){
                start = mid + 1;
            }
            else if(row[mid] > target){
                end = mid - 1;
            }
        }
        return -1;
    }
}
