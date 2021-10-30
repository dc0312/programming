package practice.tree.revisited;

public class CheckIfSymmTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);
        tree.root.leftChild = new TreeNode(2);
        tree.root.rightChild = new TreeNode(3);

        System.out.println("Is Symmetric tree ? : " + tree.checkIfSymmTree());
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

        private boolean checkIfSymmTree() {
            if (null == root) {
                return true;
            } else {
                return checkIfSymmTree(root.leftChild,root.rightChild);
            }
        }

        private boolean checkIfSymmTree(TreeNode left,TreeNode right) {
            if(null == left || null == right){
                return left==right;
            }

            if(left.val != right.val){
                return false;
            }

            return checkIfSymmTree(left.leftChild,right.rightChild) && checkIfSymmTree(left.rightChild,right.leftChild);
        }

    }

}
