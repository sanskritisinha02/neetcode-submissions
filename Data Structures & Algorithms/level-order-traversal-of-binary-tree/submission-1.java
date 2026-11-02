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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode elem = queue.poll();
                level.add(elem.val);

                if(elem.left != null){
                    queue.add(elem.left);
                }

                if(elem.right != null){
                    queue.add(elem.right);
                }
            }

            result.add(level);
        } 
        return result;  
    }
}
