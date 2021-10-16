package practice.tree.revisited;

public class MaxPathSumTree {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(-10);
        treeNew.root.leftChild = new TreeNode(30);
        treeNew.root.rightChild = new TreeNode(20);
        treeNew.root.rightChild.leftChild = new TreeNode(50);
        treeNew.root.rightChild.rightChild = new TreeNode(70);
        treeNew.root.rightChild.rightChild.leftChild = new TreeNode(20);
        treeNew.root.rightChild.rightChild.rightChild = new TreeNode(30);

        System.out.println("Max Path Sum: " + treeNew.maxPathSum());
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
        private int max = Integer.MIN_VALUE;

        public int maxPathSum() {
            if (null == root) {
                return 0;
            } else {
                maxPathSum(root);
                return max;
            }
        }

        private int maxPathSum(TreeNode node) {
            if (null == node) {
                return 0;
            }

            int lSum = Math.max(0, maxPathSum(node.leftChild));
            int rSum = Math.max(0, maxPathSum(node.rightChild));

            max = Math.max(max, node.val + lSum + rSum);
            return node.val + Math.max(lSum, rSum);
        }
    }

}
