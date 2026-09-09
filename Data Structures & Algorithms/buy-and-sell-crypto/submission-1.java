class Solution {
    public int maxProfit(int[] prices) {

        int i = 0;
        int j = 0;
        int max_profit = 0;
        int n = prices.length;

        while(j < n){

            max_profit = Math.max(max_profit, prices[j] - prices[i]);

            if(prices[j] < prices[i]){
                i = j;
            }

            j++;
        }

        return max_profit;
        
    }
}
