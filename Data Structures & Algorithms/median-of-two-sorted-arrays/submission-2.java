class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] small = nums1.length > nums2.length ? nums2 : nums1;
        int[] large = nums1.length > nums2.length ? nums1 : nums2;

        int total = nums1.length + nums2.length;

        int start = 0;
        int end = small.length;

        while(start <= end){

            int midX = start + (end - start) / 2;
            int midY = (total + 1) / 2 - midX;

            int l1;
            if(midX == 0){
                l1 = Integer.MIN_VALUE;
            }
            else{
                l1 = small[midX - 1];
            }

            int r1;
            if(midX == small.length){
                r1 = Integer.MAX_VALUE;
            }
            else{
                r1 = small[midX];
            }

            int l2;
            if(midY == 0){
                l2 = Integer.MIN_VALUE;
            }
            else{
                l2 = large[midY - 1];
            }

            int r2;
            if(midY == large.length){
                r2 = Integer.MAX_VALUE;
            }
            else{
                r2 = large[midY];
            }

            if(l1 <= r2 && l2 <= r1){
                if(total % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                else{
                    return Math.max(l1, l2);
                }
            }

            if(l1 > r2){
                end = midX - 1;
            }
            else{
                start = midX + 1;
            }
        }
        return 0;
    }
}
