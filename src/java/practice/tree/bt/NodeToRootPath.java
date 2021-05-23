package practice.tree.bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class NodeToRootPath {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(50);
        tree.root.left = new TreeNode(25);
        tree.root.right = new TreeNode(75);
        tree.root.left.left = new TreeNode(12);
        tree.root.left.right = new TreeNode(37);
        tree.root.right.left = new TreeNode(62);
        tree.root.right.right = new TreeNode(57);
        tree.root.left.right.left = new TreeNode(30);
        tree.root.right.left.right = new TreeNode(70);
        tree.levelOrderTraversal();
        tree.nodeToRootPath(70);
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private static class Tree {
        TreeNode root;

        public void levelOrderTraversal() {
            if (null == root) {
                return;
            } else {
                Queue<TreeNode> q = new ArrayDeque<>();
                q.add(root);
                while (!q.isEmpty()) {
                    TreeNode current = q.remove();
                    System.out.print(current.data + "->");
                    if (null != current.left) {
                        q.add(current.left);
                    }
                    if (null != current.right) {
                        q.add(current.right);
                    }
                }
            }
            System.out.println();
        }

        public void nodeToRootPath(int val) {
            if (null == root) {
                return;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                nodeToRootPath(val, root, list);
                if (list.isEmpty()) {
                    return;
                } else {
                    list.stream().map(i -> i + "->").forEach(System.out::print);
                }
            }
        }

        private boolean nodeToRootPath(int val, TreeNode root, ArrayList<Integer> list) {
            if (null == root) {
                return false;
            }
            if (val == root.data) {
                list.add(root.data);
                return true;
            }

            boolean isLeftFound = nodeToRootPath(val, root.left, list);
            if (isLeftFound) {
                list.add(root.data);
                return true;
            }
            boolean isRightFound = nodeToRootPath(val, root.right, list);
            if (isRightFound) {
                list.add(root.data);
                return true;
            }
            return false;
        }
    }
}
