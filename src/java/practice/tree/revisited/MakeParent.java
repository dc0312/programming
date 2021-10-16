package practice.tree.revisited;

import java.util.HashMap;
import java.util.Map;

public class MakeParent {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(3);
        treeNew.root.leftChild = new TreeNode(5);
        treeNew.root.rightChild = new TreeNode(1);
        treeNew.root.rightChild.leftChild = new TreeNode(0);
        treeNew.root.rightChild.rightChild = new TreeNode(8);
        treeNew.root.leftChild.leftChild = new TreeNode(6);
        treeNew.root.leftChild.rightChild = new TreeNode(2);
        treeNew.root.leftChild.rightChild.leftChild = new TreeNode(7);
        treeNew.root.leftChild.rightChild.rightChild = new TreeNode(4);

        treeNew.makeParent();
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

        public void makeParent() {
            if (null == root) {
                return;
            } else {
                Map<TreeNode, TreeNode> parentMap = new HashMap<>();
                makeParent(root, parentMap);
                System.out.println(parentMap);
            }
        }

        private void makeParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
            if (null == root) {
                return;
            }
            if (null != root.leftChild) {
                parentMap.put(root.leftChild, root);
            }
            if (null != root.rightChild) {
                parentMap.put(root.rightChild, root);
            }
            makeParent(root.leftChild, parentMap);
            makeParent(root.rightChild, parentMap);
        }
    }

}
