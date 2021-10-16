package practice.tree.revisited;

/**
 * This program is valid only for complete tree.
 */
public class CountNumberOfNodes {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(3);
        treeNew.root.leftChild = new TreeNode(5);
        treeNew.root.leftChild.leftChild = new TreeNode(6);
        treeNew.root.leftChild.rightChild = new TreeNode(2);
        treeNew.root.leftChild.leftChild.leftChild = new TreeNode(7);
        treeNew.root.leftChild.leftChild.rightChild = new TreeNode(4);
        treeNew.root.rightChild = new TreeNode(1);
        treeNew.root.rightChild.leftChild = new TreeNode(0);
        treeNew.root.rightChild.rightChild = new TreeNode(8);

        System.out.println("Number of Nodes : " + treeNew.numberOfNodes());

    }

    static class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "->";
        }
    }

    static class Tree {
        TreeNode root;

        public int numberOfNodes() {
            if (null == root) {
                return 0;
            } else {
                return numberOfNodes(root);
            }
        }

        private int numberOfNodes(TreeNode root) {
            if (null == root) {
                return 0;
            }

            int leftHeight = getLeftHeight(root);
            int rightHeight = getRightHeight(root);

            if (leftHeight == rightHeight) {
                return (2 << (leftHeight)) - 1;
            } else {
                return 1 + numberOfNodes(root.leftChild) + numberOfNodes(root.rightChild);
            }
        }

        private int getRightHeight(TreeNode root) {
            int height = 0;
            while (null != root.leftChild) {
                height++;
                root = root.leftChild;
            }
            return height;
        }

        private int getLeftHeight(TreeNode root) {
            int height = 0;
            while (null != root.rightChild) {
                height++;
                root = root.rightChild;
            }
            return height;

        }
    }

}
