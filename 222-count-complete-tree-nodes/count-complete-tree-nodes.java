// Given a complete binary tree, count the number of nodes.
//
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return count(root,0,0);
    }

    private int count (TreeNode node, int numL, int numR){
        if (node == null) return 0;
        TreeNode temp;
        if (numL == 0) {
            temp = node;
            while (temp.left != null) {
                numL++;
                temp = temp.left;
            }
        }

        if (numR == 0) {
            temp = node;
            while (temp.right != null) {
                numR++;
                temp = temp.right;
            }
        }

        if (numL == numR){
            return (1<< (numL+1)) - 1;
        }

        return 1 + count(node.left,numL - 1, 0) + count(node.right,0,numR - 1);
    }
}
