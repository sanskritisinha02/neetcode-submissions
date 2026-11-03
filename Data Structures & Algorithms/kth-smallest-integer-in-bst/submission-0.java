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

    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    public void inOrder(TreeNode root, int k){

        if(root == null){
            return;
        }
        //left
        inOrder(root.left, k);
        count++;

        //current
        if(count == k){
            ans = root.val;
            return;
        }

        //right
        inOrder(root.right, k);
    }
}
