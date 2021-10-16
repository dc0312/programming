package practice.tree.revisited;

public class HeightOfTree {
    static TreeNode root;

    public static int height() {
        if (root == null) {
            return 0;
        } else {
            return height(root);
        }
    }

    private static int height(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int lh = height(node.leftChild);
        int rh = height(node.rightChild);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.leftChild.rightChild = new TreeNode(5);
        root.leftChild.rightChild.rightChild = new TreeNode(8);
        root.leftChild.leftChild = new TreeNode(4);
        root.rightChild = new TreeNode(3);
        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.leftChild.rightChild = new TreeNode(9);
        root.rightChild.rightChild = new TreeNode(7);
        root.rightChild.rightChild.leftChild = new TreeNode(10);
        System.out.println("Height : " + height());
    }

    static class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
