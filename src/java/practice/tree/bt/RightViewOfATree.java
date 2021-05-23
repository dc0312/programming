package practice.tree.bt;

import java.util.LinkedList;

public class RightViewOfATree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(4);
        tree.root.right = new TreeNode(3);
//        tree.root = new TreeNode(32);
//        tree.root.left = new TreeNode(21);
//        tree.root.left.left = new TreeNode(19);
//        tree.root.left.left.right = new TreeNode(27);
//        tree.root.left.left.right.right = new TreeNode(28);
//        tree.root.right = new TreeNode(47);
//        tree.root.right.right = new TreeNode(56);
        tree.leftView();
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static class Tree {
        TreeNode root;

        public void leftView() {
            if (null == root) {
                return;
            }
            LinkedList<TreeNode> q = new LinkedList<>();
            q.addLast(root);
            while (!q.isEmpty()) {
                int size = q.size();
                System.out.print(q.peekFirst().data + "->");
                while (size-- > 0) {
                    TreeNode current = q.removeFirst();
                    if (null != current.right) {
                        q.addLast(current.right);
                    }
                    if (null != current.left) {
                        q.addLast(current.left);
                    }
                }
            }
            System.out.println();
        }

    }
}
