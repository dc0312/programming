package leetcode.tree;

public class LeetCode230KthSmallestInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;

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
        System.out.println(kthSmallest(root,3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        kthSmallest(root, k, ans);
        return ans[0];
    }

    public static void kthSmallest(TreeNode root, int k, int[] ans) {
        if (null == root) {
            return;
        }
        kthSmallest(root.left, k, ans);
        count++;
        if (count == k) {
            ans[0] = root.val;
        }
        kthSmallest(root.right, k, ans);
    }
}
