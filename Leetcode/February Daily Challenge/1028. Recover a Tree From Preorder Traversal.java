/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    TreeNode solve(int i[], int currDepth, String traversal) {
        int n = traversal.length();
        if (i[0] >= n)
            return null;

        int j = i[0];
        int dashCnt = 0;
        while (j < n && traversal.charAt(j) == '-') {

            dashCnt++;
            j++;
        }

        if (dashCnt != currDepth)
            return null;

        i[0] += dashCnt;

        StringBuffer strNum = new StringBuffer();
        while (i[0] < n && traversal.charAt(i[0]) != '-') {

            strNum.append(traversal.charAt(i[0]));
            i[0]++;
        }

        int num = Integer.parseInt(strNum.toString());

        TreeNode node = new TreeNode(num);

        node.left = solve(i, currDepth + 1, traversal);
        node.right = solve(i, currDepth + 1, traversal);

        return node;
    }

    public TreeNode recoverFromPreorder(String traversal) {

        int i[] = new int[1];

        return solve(i, 0, traversal);
    }
}