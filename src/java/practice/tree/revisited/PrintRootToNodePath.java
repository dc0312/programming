package practice.tree.revisited;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintRootToNodePath {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(1);
        treeNew.root.leftChild = new TreeNode(2);
        treeNew.root.rightChild = new TreeNode(3);
        treeNew.root.leftChild.leftChild = new TreeNode(4);
        treeNew.root.leftChild.rightChild = new TreeNode(5);
        treeNew.root.leftChild.rightChild.leftChild = new TreeNode(6);
        treeNew.root.leftChild.rightChild.rightChild = new TreeNode(7);

        treeNew.getPath(7);

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

        public void getPath(int val) {
            if (null == root) {
                return;
            } else {
                ArrayList<Integer> ans = new ArrayList<>();
                getPath(root, ans, val);
                System.out.println(Arrays.toString(ans.toArray()));
            }
        }

        private boolean getPath(TreeNode node, ArrayList<Integer> ans, int val) {
            if (null == node) {
                return false;
            }
            ans.add(node.val);
            if (node.val == val) {
                return true;
            }

            if (getPath(node.leftChild, ans, val) || getPath(node.rightChild, ans, val)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            return false;
        }
    }

}
