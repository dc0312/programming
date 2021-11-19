package practice.tree.revisited.bst;

public class KthSmallestBst {
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

        logic(root, 3);
    }

    private static void logic(TreeNode root, int k) {
        if (null == root) {
            return;
        }
        logic(root.left, k);
        count++;
        if (count == k) {
            System.out.println(root.val);
        }
        logic(root.right, k);

    }
}
