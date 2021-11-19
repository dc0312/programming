package leetcode.trie;

import leetcode.tree.LeetCode230KthSmallestInBST;

public class LeetCode98ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, Integer min, Integer max){
        if(null == root){
            return true;
        }
        if((null != min && root.val <= min) || (null != max && root.val >= max)){
            return false;
        }
        return isValidBST(root.left, min,root.val) && isValidBST(root.right,root.val,max);
    }
}
