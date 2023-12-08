import javax.swing.tree.TreeNode;

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
class Leet_606 {
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }

        // If the root Node has no children
        if(root.left == null && root.right == null){
            return root.val + "";
        }

        // If the root Node has a only left child
        if(root.right == null){
            return root.val + "(" + tree2str(root.left) + ")";
        }

        // If the root Node has both left & right children
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}