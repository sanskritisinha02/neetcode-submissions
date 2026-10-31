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

//Recursive approach
// class Solution {
//     public TreeNode invertTree(TreeNode root) {

//         if(root == null){
//             return null;
//         }

//         TreeNode left = invertTree(root.left);
//         TreeNode right = invertTree(root.right);

//         root.left = right;
//         root.right = left;

//         return root;
        
//     }
// }

//BFS or level order approach
class Solution {
    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            final TreeNode node = queue.poll();

        //swap

        final TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        //add left to right and right to left
        if(node.left != null){
            queue.add(node.left);
        }

        if(node.right != null){
            queue.add(node.right);
        }
        }

        return root;
    }
}

