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
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);

        int numLevel = 0;
        while(true){

            int pointer = queue.size();

            if(pointer == 0){
                return numLevel;
            }

            while(pointer > 0){

                TreeNode elem = queue.poll();

                if(elem.left != null){
                    queue.add(elem.left);
                }
                if(elem.right != null){
                    queue.add(elem.right);
                }
                pointer--;
            }
        numLevel++;
        }
    }
}
