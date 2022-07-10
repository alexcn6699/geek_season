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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, new int[] {inorder.length - 1}, new int[] {postorder.length - 1}, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int[] inIndex, int[] postIndex, int target) {
        if (inIndex[0] < 0 || postIndex[0] < 0 || inorder[inIndex[0]] == target) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postIndex[0]--]);
        root.right = helper(inorder, postorder, inIndex, postIndex, root.val);
        inIndex[0]--;
        root.left = helper(inorder, postorder, inIndex, postIndex, target);

        return root;

    }
}