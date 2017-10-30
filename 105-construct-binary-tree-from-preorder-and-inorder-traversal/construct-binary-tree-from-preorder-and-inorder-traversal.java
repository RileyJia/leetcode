// Given preorder and inorder traversal of a tree, construct the binary tree.
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
    private int[] preorder,inorder;
    private HashMap<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        if (preorder.length == 0 || inorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return tree(0, preorder.length - 1, 0, inorder.length - 1);

    }

    public TreeNode tree( int pStart, int pEnd, int iStart, int iEnd){
        if (pStart>pEnd||iStart>iEnd) return null;

        TreeNode result = new TreeNode(preorder[pStart]);
        int index = map.get(result.val);
        result.left = tree(pStart + 1, index - iStart + pStart, iStart, index - 1);
        result.right = tree(pStart + index - iStart + 1,pEnd,index + 1, iEnd);
        return result;
    }
}
