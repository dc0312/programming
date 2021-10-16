package practice.tree.revisited;

public class CheckIfBalancedTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);
        tree.root.leftChild = new TreeNode(1);
        tree.root.leftChild.leftChild = new TreeNode(1);
        tree.root.leftChild.leftChild.leftChild = new TreeNode(1);
        tree.root.leftChild.leftChild.leftChild.leftChild = new TreeNode(1);
        tree.root.leftChild.leftChild.leftChild.leftChild.leftChild = new TreeNode(1);
        tree.root.leftChild.rightChild = new TreeNode(1);
        tree.root.leftChild.rightChild.leftChild = new TreeNode(1);
        tree.root.leftChild.rightChild.leftChild.leftChild = new TreeNode(1);
        tree.root.leftChild.rightChild.leftChild.leftChild.leftChild = new TreeNode(1);
        tree.root.leftChild.rightChild.leftChild.leftChild.leftChild.leftChild = new TreeNode(1);

        tree.root.rightChild = new TreeNode(1);
        System.out.println("Is Balanced tree ? : " + tree.checkIfBalancedTree());

        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(1);
        treeNew.root.leftChild = new TreeNode(2);
        treeNew.root.rightChild = new TreeNode(3);
        treeNew.root.rightChild.leftChild = new TreeNode(4);
        treeNew.root.rightChild.rightChild = new TreeNode(5);

        System.out.println("Is Balanced tree ? : " + treeNew.checkIfBalancedTree());
    }

    static class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree {
        TreeNode root;

        private boolean checkIfBalancedTree() {
            if (null == root) {
                return true;
            } else {
                return -1 != checkIfBalancedTree(root);
            }
        }

        private int checkIfBalancedTree(TreeNode node) {
            if (null == node) {
                return 0;
            }

            int lh = checkIfBalancedTree(node.leftChild);
            if (lh == -1) {
                return -1;
            }
            int rh = checkIfBalancedTree(node.rightChild);
            if (rh == -1) {
                return -1;
            }
            if (Math.abs(lh - rh) > 1) {
                return -1;
            }
            return 1 + Math.max(lh, rh);
        }

    }

}
