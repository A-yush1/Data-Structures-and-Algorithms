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

    TreeNode solve(int preStart, int preEnd, int postStart, Map<Integer, Integer> mp, int preorder[], int postorder[])
    {
        if(preStart > preEnd)
        return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        if(preStart == preEnd)
        return root;

        int nextNodeVal = preorder[preStart + 1];
        
        int j = mp.get(nextNodeVal);

        int numOfNodes = j - postStart + 1;

        root.left = solve(preStart + 1, preStart + numOfNodes, postStart, mp, preorder, postorder);
        root.right = solve(preStart + numOfNodes + 1, preEnd, j + 1, mp, preorder, postorder);

        return root;

    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        int n = preorder.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++)
        mp.put(postorder[i], i);

        return solve(0, n-1, 0, mp, preorder, postorder);
    }
}