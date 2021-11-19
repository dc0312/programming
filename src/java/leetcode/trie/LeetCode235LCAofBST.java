package leetcode.trie;

public class LeetCode235LCAofBST {
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
        System.out.println(lowestCommonAncestor(root,4,7).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(null == root){
            return null;
        }
        if(p < root.val && q < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p > root.val && q > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
