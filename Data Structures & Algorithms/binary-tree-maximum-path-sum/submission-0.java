/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int maxSum;

    public int solve(TreeNode root){

        if(root == null){
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        int neeche_hi_milgaya_ans = l + r + root.val; //cannot explore further

        int koi_ek_aacha_hai = Math.max(l,r) + root.val; //can explore further

        int sirf_root_acha_hai = root.val; //can explore further

        maxSum = Math.max(maxSum, Math.max(neeche_hi_milgaya_ans, Math.max(koi_ek_aacha_hai, sirf_root_acha_hai)));

        //will only return jo explore kar sakte hai aur;
        return Math.max(koi_ek_aacha_hai , sirf_root_acha_hai);
    }

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        solve(root);
        return maxSum;
    }
}




















