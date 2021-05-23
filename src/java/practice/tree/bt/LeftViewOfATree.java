package practice.tree.bt;

import java.util.LinkedList;

public class LeftViewOfATree {
    public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.root = new TreeNode(2);
//        tree.root.left = new TreeNode(1);
//        tree.root.right = new TreeNode(1);
        tree.root = new TreeNode(32);
        tree.root.left = new TreeNode(21);
        tree.root.left.left = new TreeNode(19);
        tree.root.left.left.right = new TreeNode(27);
        tree.root.left.left.right.right = new TreeNode(28);
        tree.root.right = new TreeNode(47);
        tree.root.right.right = new TreeNode(56);
        tree.leftView();
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
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
                TreeNode current = q.peekFirst();
                System.out.print(current.data + "->");
                while (size > 0) {
                    if (null != current.left) {
                        q.addLast(current.left);
                    }
                    if (null != current.right) {
                        q.addLast(current.right);
                    }
                    q.removeFirst();
                    size--;
                }
            }
            System.out.println();
        }

    }
}
