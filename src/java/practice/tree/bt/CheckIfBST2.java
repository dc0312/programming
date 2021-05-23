package practice.tree.bt;

public class CheckIfBST2 {
    public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.root = new TreeNode(2);
//        tree.root.left = new TreeNode(1);
//        tree.root.right = new TreeNode(1);
        tree.root = new TreeNode(32);
        tree.root.left = new TreeNode(21);
        tree.root.left.left = new TreeNode(19);
        tree.root.left.left.right = new TreeNode(27);
        tree.root.right = new TreeNode(47);
        tree.root.right.right = new TreeNode(56);

        System.out.println("Is BST ? " + tree.isBST());
        tree.inOrder(tree.root);
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class Tree {
        TreeNode root;
        int prev;

        public boolean isBST() {
            if (null == root) {
                return true;
            } else {
                return isBST(root);
            }
        }

        private boolean isBST(TreeNode root) {
            if (null == root) {
                return true;
            }

            boolean isLeftBST = isBST(root.left);
            if (!isLeftBST || root.data <= prev) {
                return false;
            }
            prev = root.data;
            boolean isRightBST = isBST(root.right);
            return isRightBST;
        }

        public void inOrder(TreeNode root) {
            if (null == root) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + "->");
            inOrder(root.right);
        }
    }
}
