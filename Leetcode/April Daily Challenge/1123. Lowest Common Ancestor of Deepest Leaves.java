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
    class Pair{
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }
    Pair solve(TreeNode root)
    {
        if(root == null)
        return new Pair(null, 0);

        Pair leftP = solve(root.left);
        Pair rightP = solve(root.right);

        if(leftP.depth == rightP.depth)
        return new Pair(root, leftP.depth + 1);
        
        else if(leftP.depth > rightP.depth)
        return new Pair(leftP.node, leftP.depth + 1);

        else
        return new Pair(rightP.node, rightP.depth + 1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        
        Pair res = solve(root);
        return res.node;
    }
}