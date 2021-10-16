package practice.tree.revisited;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(6);
        binaryTree.levelOrderTraversal();
        binaryTree.preOrderTraversal();
        binaryTree.preOrderTraversalIterative();
        System.out.print("====> InOrder ");
        binaryTree.inOrderTraversal();
        System.out.print("====> InOrder ");
        binaryTree.inOrderTraversalIterative();
        binaryTree.inOrderTraversalIterativeNew();
        binaryTree.postOrderTraversal();

        BinaryTree binaryTreeNew = new BinaryTree();
        binaryTreeNew.root = new TreeNode(1);
        binaryTreeNew.root.leftChild = new TreeNode(2);
        binaryTreeNew.root.leftChild.rightChild = new TreeNode(5);
        binaryTreeNew.root.leftChild.rightChild.rightChild = new TreeNode(8);
        binaryTreeNew.root.leftChild.leftChild = new TreeNode(4);
        binaryTreeNew.root.rightChild = new TreeNode(3);
        binaryTreeNew.root.rightChild.leftChild = new TreeNode(6);
        binaryTreeNew.root.rightChild.leftChild.rightChild = new TreeNode(9);
        binaryTreeNew.root.rightChild.rightChild = new TreeNode(7);
        binaryTreeNew.root.rightChild.rightChild.leftChild = new TreeNode(10);
        binaryTreeNew.inOrderTraversal();
        binaryTreeNew.inOrderTraversalIterativeNew();
        binaryTreeNew.inOrderTraversalIterative();
    }

    static class TreeNode {
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    static class BinaryTree {
        TreeNode root;

        public void insert(int data) {
            if (null == root) {
                root = new TreeNode(data);
            } else {
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.addLast(root);
                while (!queue.isEmpty()) {
                    TreeNode current = queue.removeFirst();
                    if (null != current.leftChild) {
                        queue.addLast(current.leftChild);
                    } else {
                        current.leftChild = new TreeNode(data);
                        return;
                    }
                    if (null != current.rightChild) {
                        queue.addLast(current.rightChild);
                    } else {
                        current.rightChild = new TreeNode(data);
                        return;
                    }
                }
            }
        }


        public void preOrderTraversal() {
            if (null == root) {
                return;
            } else {
                preOrderTraversal(root);
                System.out.println();
            }
        }

        private void preOrderTraversal(TreeNode root) {
            if (null == root) {
                return;
            }

            System.out.print(root.data + "->");
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }

        public void inOrderTraversal() {
            if (null == root) {
                return;
            } else {
                inOrderTraversal(root);
                System.out.println();
            }
        }

        private void inOrderTraversal(TreeNode root) {
            if (null == root) {
                return;
            }
            inOrderTraversal(root.leftChild);
            System.out.print(root.data + "->");
            inOrderTraversal(root.rightChild);
        }

        public void postOrderTraversal() {
            if (null == root) {
                return;
            } else {
                postOrderTraversal(root);
                System.out.println();
            }
        }

        private void postOrderTraversal(TreeNode root) {
            if (null == root) {
                return;
            }
            postOrderTraversal(root.leftChild);
            postOrderTraversal(root.rightChild);
            System.out.print(root.data + "->");
        }

        public void levelOrderTraversal() {
            if (null == root) {
                return;
            } else {
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.addLast(root);
                while (!queue.isEmpty()) {
                    TreeNode current = queue.removeFirst();
                    System.out.print(current.data + "->");
                    if (null != current.leftChild) {
                        queue.addLast(current.leftChild);
                    }
                    if (null != current.rightChild) {
                        queue.addLast(current.rightChild);
                    }
                }
                System.out.println();
            }
        }

        public void preOrderTraversalIterative() {
            if (null == root) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                System.out.print(current.data + "->");
                if (null != current.rightChild) {
                    stack.push(current.rightChild);
                }
                if (null != current.leftChild) {
                    stack.push(current.leftChild);
                }
            }
            System.out.println();
        }

        public void inOrderTraversalIterative() {
            if (null == root) {
                return;
            } else {
                TreeNode temp = root;
                Stack<TreeNode> stack = new Stack<>();
                stack.push(temp);
                while (null != temp.leftChild) {
                    stack.push(temp.leftChild);
                    temp = temp.leftChild;
                }
                while (!stack.isEmpty()) {
                    TreeNode current = stack.pop();
                    System.out.print(current.data + "->");
                    if (null != current.rightChild) {
                        stack.push(current.rightChild);
                        while (null != current.rightChild.leftChild) {
                            stack.push(current.rightChild.leftChild);
                            current.rightChild = current.rightChild.leftChild;
                        }
                    }
                }
                System.out.println();
            }
        }

        public void inOrderTraversalIterativeNew() {
            TreeNode current = root;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(current);
            while (true) {
                if (null != current) {
                    stack.push(current);
                    current = current.leftChild;
                } else {
                    if (!stack.isEmpty()) {
                        return;
                    }
                    current = stack.pop();
                    System.out.print(current.data + "->");
                    current = current.rightChild;
                }
            }
        }
    }
}
