package practice.tree.revisited;

import java.util.LinkedList;

public class MaxWidthOfTree {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(1);
        treeNew.root.leftChild = new TreeNode(2);
        treeNew.root.leftChild.leftChild = new TreeNode(4);
        treeNew.root.leftChild.rightChild = new TreeNode(5);
        treeNew.root.leftChild.rightChild.leftChild = new TreeNode(6);
        treeNew.root.leftChild.rightChild.rightChild = new TreeNode(7);
        treeNew.root.rightChild = new TreeNode(3);
        treeNew.root.rightChild.rightChild = new TreeNode(8);

        System.out.println("Max Width : " + treeNew.maxWidth());
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

    static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static class Tree {
        TreeNode root;

        public int maxWidth() {
            if (null == root) {
                return 0;
            } else {
                return maxWidth(root);
            }
        }

        private int maxWidth(TreeNode root) {
            LinkedList<Pair> queue = new LinkedList<>();
            queue.addLast(new Pair(root, 0));
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int leftMax = queue.getFirst().level;
                int rightMax;
                while (size-- > 0) {
                    Pair temp = queue.removeFirst();
                    rightMax = temp.level;
                    if (null != temp.node.leftChild) {
                        queue.addLast(new Pair(temp.node.leftChild, 2 * rightMax + 1));
                    }
                    if (null != temp.node.rightChild) {
                        queue.addLast(new Pair(temp.node.rightChild, 2 * rightMax + 2));
                    }
                    max = Math.max(max, rightMax - leftMax + 1);
                }
            }
            return max;
        }

    }

}
