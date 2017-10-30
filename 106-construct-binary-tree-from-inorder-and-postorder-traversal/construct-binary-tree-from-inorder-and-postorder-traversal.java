// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//


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
    private int[] inorder, postorder;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;

        if (inorder.length == 0 || postorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return tree(0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode tree(int pStart, int pEnd, int iStart, int iEnd){
        if (pStart > pEnd || iStart > iEnd) return null;

        TreeNode result = new TreeNode(postorder[pEnd]);
        int index = map.get(result.val);
        
        result.left = tree(pStart,pStart + index - iStart - 1, iStart,index - 1);
        result.right = tree(pStart + index - iStart, pEnd - 1, index + 1, iEnd);
        return result;

    }
}
