package practice.tree.revisited;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreInPostOrderTraversal {
    static TreeNode root;

    public static void preInPostTraversal(TreeNode root) {
        if (null == root) {
            return;
        } else {
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(root, 1));
            List<Integer> preOrder = new ArrayList<>();
            List<Integer> inOrder = new ArrayList<>();
            List<Integer> postOrder = new ArrayList<>();
            while (!stack.isEmpty()) {
                Pair temp = stack.pop();
                if (temp.level == 1) {
                    preOrder.add(temp.treeNode.val);
                    temp.level++;
                    stack.push(temp);
                    if (null != temp.treeNode.leftChild) {
                        stack.push(new Pair(temp.treeNode.leftChild, 1));
                    }

                } else if (temp.level == 2) {
                    inOrder.add(temp.treeNode.val);
                    temp.level++;
                    stack.push(temp);
                    if (null != temp.treeNode.rightChild) {
                        stack.push(new Pair(temp.treeNode.rightChild, 1));
                    }
                } else {
                    postOrder.add(temp.treeNode.val);
                }
            }
            System.out.print("Preorder --> ");
            System.out.println(Arrays.toString(preOrder.toArray()));
            System.out.print("Inorder --> ");
            System.out.println(Arrays.toString(inOrder.toArray()));
            System.out.print("Postorder --> ");
            System.out.println(Arrays.toString(postOrder.toArray()));
        }
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

        preInPostTraversal(root);
    }

    static class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode treeNode;
        int level;

        public Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}
