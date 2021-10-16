package practice.tree.revisited;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(1);
        treeNew.root.leftChild = new TreeNode(2);
        treeNew.root.rightChild = new TreeNode(3);
        treeNew.root.leftChild.leftChild = new TreeNode(4);
        treeNew.root.leftChild.rightChild = new TreeNode(5);
        treeNew.root.leftChild.rightChild.leftChild = new TreeNode(6);
        treeNew.root.leftChild.rightChild.rightChild = new TreeNode(7);

        System.out.println(treeNew.lca(4, 7));
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

        public int lca(int p, int q) {
            if (null == root) {
                return -1;
            } else {
                TreeNode ans = lca(root, p, q);
                return ans.val;
            }
        }

        private TreeNode lca(TreeNode node, int p, int q) {
            if (null == node || p == node.val || q == node.val) {
                return node;
            }

            TreeNode left = lca(node.leftChild, p, q);
            TreeNode right = lca(node.rightChild, p, q);

            if (null == left) {
                return right;
            } else if (null == right) {
                return left;
            } else {
                return node;
            }
        }
    }

}
