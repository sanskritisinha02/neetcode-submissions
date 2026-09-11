class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] maxL = new int[n];
        int [] maxR = new int[n];
        int[] result = new int[n];
        int sum = 0;

        maxL[0] = height[0];
        for(int i = 1; i < n; i++){
            maxL[i] = Math.max(height[i], maxL[i-1]);
        }

        maxR[n-1] = height[n-1];
        for(int j = n-2; j >= 0; j--){
            maxR[j] = Math.max(height[j], maxR[j+1]);
        }

        for(int i = 0; i < n; i++){
            result[i] = Math.min(maxL[i], maxR[i]) - height[i];
            sum = sum + result[i];
        }
        return sum;
    }
}
