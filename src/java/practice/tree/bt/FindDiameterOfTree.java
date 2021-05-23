package practice.tree.bt;

public class FindDiameterOfTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(1);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.left.left = new TreeNode(1);
//        tree.root.left.left.left.left = new TreeNode(1);
//        tree.root.left.left.left.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(1);
        tree.root.left.right.left = new TreeNode(1);
        tree.root.left.right.left.left = new TreeNode(1);
        tree.root.left.right.left.left.left = new TreeNode(1);
        tree.root.left.right.left.left.left.left = new TreeNode(1);

        tree.root.right = new TreeNode(1);

        System.out.println("Diameter " + tree.diaMeter());
        System.out.println("Diameter " + tree.diameterOfBinaryTree());
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class DiaPair {
        int ht;
        int dia;
    }

    static class Tree {
        TreeNode root;

        /**
         * First Way :: Diameter of the Tree.
         */
        public int diaMeter() {
            if (null == root) {
                return 0;
            } else {
                return diaMeter(root);
            }
        }

        private int diaMeter(TreeNode root) {
            if (null == root) {
                return 0;
            }

            int dl = diaMeter(root.left);
            int dr = diaMeter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int dia = lh + rh + 2;
            return Math.max(dia, Math.max(dl, dr));
        }

        private int height(TreeNode root) {
            if (null == root) {
                return -1;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        /**
         * Second Way :: Diameter of the Tree.
         */
        public int diameterOfBinaryTree() {
            if (null == root) {
                return 0;
            } else {
                return diameterOfBinaryTree(root).dia;
            }
        }

        public DiaPair diameterOfBinaryTree(TreeNode root) {
            if (null == root) {
                DiaPair diaPair = new DiaPair();
                diaPair.ht = -1;
                diaPair.dia = 0;
                return diaPair;
            }
            DiaPair ld = diameterOfBinaryTree(root.left);
            DiaPair lr = diameterOfBinaryTree(root.right);
            DiaPair diaPair = new DiaPair();
            int dia = ld.ht + lr.ht + 2;
            diaPair.dia = Math.max(dia, Math.max(ld.dia, lr.dia));
            diaPair.ht = Math.max(ld.ht, lr.ht) + 1;
            return diaPair;
        }
    }

}
