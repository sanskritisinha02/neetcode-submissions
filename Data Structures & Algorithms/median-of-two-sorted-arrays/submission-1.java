class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        Arrays.sort(result);
        int n = result.length;

        if(n % 2 == 0){
            return (result[n/2 - 1] + result[n/2]) / 2.0;
        }
        else{
            return result[n/2];
        }  
    }
}
