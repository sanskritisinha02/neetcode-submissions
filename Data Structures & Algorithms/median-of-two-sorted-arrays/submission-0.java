class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        Arrays.sort(result);
        int n = result.length;

        double median_even = 0.0;
        double median_odd = 0.0;

        if(n % 2 == 0){
            return median_even = ((n/2) + ((n/2) + 1))/2.0;
        }
        else{
            return median_odd = (n+1)/2.0;
        }  
    }
}
