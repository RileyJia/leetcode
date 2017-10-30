// Given a binary tree, return the inorder traversal of its nodes' values.
//
//
// For example:
// Given binary tree [1,null,2,3],
//
//    1
//     \
//      2
//     /
//    3
//
//
//
// return [1,3,2].
//
//
// Note: Recursive solution is trivial, could you do it iteratively?


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
/* ************************* Morris Traversal *************************/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        TreeNode pointer = root;
        TreeNode prev = null;

        
        while(pointer != null){
            if (pointer.left != null){
                prev = pointer.left;
                while(prev.right != null && prev.right != pointer){
                    prev = prev.right;
                }
                
                if (prev.right == null){
                    prev.right = pointer;
                    pointer = pointer.left;
                } else {
                    prev.right = null;
                    res.add(pointer.val);
                    pointer = pointer.right;
                }
            } else {
                res.add(pointer.val);
                pointer = pointer.right;
            }
        }
        
        return res;


    }
    
/* ************************** ITERATIVELY **************************** */
/*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        Stack<TreeNode> storage = new Stack<>();

        while (root != null || !storage.empty()){
            if (root != null){
                storage.push(root);
                root = root.left;
            }
            else {
                root = storage.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
*/
    
/* *************************** RECURSIVE **************************** */
/*    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,root,res);
        return res;
    }
    
    public void helper(TreeNode current, TreeNode root, List<Integer> res){
        if (current == null){
            //res.add(current.val);
            return;
        }
        
        helper(current.left, root, res);
        res.add(current.val);
        helper(current.right, root, res);
        return;
    }
*/
}
