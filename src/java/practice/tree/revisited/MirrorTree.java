package practice.tree.revisited;

import javax.xml.soap.Node;
import java.util.LinkedList;

public class MirrorTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void levelTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.pop();
            System.out.print(current.val + "->");
            if (null != current.left) {
                queue.addLast(current.left);
            }
            if (null != current.right) {
                queue.addLast(current.right);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        levelTraversal(root);
        mirrorTree(root);
        levelTraversal(root);
    }

    private static TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);


        root.left = right;
        root.right = left;
        return root;
    }
}
