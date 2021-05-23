package practice.tree.bt;

public class CheckIfBST {
    public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.root = new TreeNode(10);
//        tree.root.left = new TreeNode(5);
//        tree.root.left.left = new TreeNode(2);
//        tree.root.left.right = new TreeNode(7);
//        tree.root.left.right.left = new TreeNode(6);
//        tree.root.left.right.right = new TreeNode(8);
//        tree.root.right = new TreeNode(15);
//        tree.root.right.left = new TreeNode(12);
//        tree.root.right.right = new TreeNode(20);
//        tree.root.right.right.left = new TreeNode(18);
//        tree.root.right.right.right = new TreeNode(25);
        tree.root = new TreeNode(32);
        tree.root.left = new TreeNode(26);
        tree.root.left.left = new TreeNode(19);
        tree.root.left.left.right = new TreeNode(27);
        tree.root.right = new TreeNode(47);
        tree.root.right.right = new TreeNode(56);

        System.out.println("Is BST ? " + tree.isBST());
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class BSTPair {
        boolean isBST;
        int max;
        int min;

        @Override
        public String toString() {
            return "BSTPair{" +
                    "isBst=" + isBST +
                    ", max=" + max +
                    ", min=" + min +
                    '}';
        }
    }

    static class Tree {
        TreeNode root;

        public static BSTPair isBST(TreeNode node) {
            if (node == null) {
                BSTPair bp = new BSTPair();
                bp.min = Integer.MAX_VALUE;
                bp.max = Integer.MIN_VALUE;
                bp.isBST = true;
                return bp;
            }

            BSTPair lp = isBST(node.left);
            BSTPair rp = isBST(node.right);

            BSTPair mp = new BSTPair();
            mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
            mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
            mp.isBST = lp.isBST && rp.isBST && node.data > lp.max && node.data < rp.min;

            return mp;
        }

        public boolean isBST() {
            if (null == root) {
                return false;
            } else {
                return isBST(root).isBST;
            }
        }

    }
}
