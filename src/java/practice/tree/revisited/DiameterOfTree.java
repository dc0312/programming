package practice.tree.revisited;

public class DiameterOfTree {
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
        System.out.println("Diameter : " + tree.diameter());
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
        static TreeNode root;

        private static int diameter() {
            if (null == root) {
                return 0;
            } else {
                int[] dia = new int[1];
                diameter(root, dia);
                return dia[0];
            }
        }

        private static int diameter(TreeNode node, int[] dia) {
            if (null == node) {
                return 0;
            }
            int lh = diameter(node.leftChild, dia);
            int rh = diameter(node.rightChild, dia);

            dia[0] = Math.max(dia[0], lh + rh);
            return 1 + Math.max(lh, rh);
        }

    }

}
