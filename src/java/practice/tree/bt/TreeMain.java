package practice.tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

class Tree {
    TreeNode root;

    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);
        if (null == root) {
            root = newNode;
        } else {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode current = q.remove();
                if (null == current.left) {
                    current.left = newNode;
                    return;
                } else {
                    q.add(current.left);
                }
                if (null == current.right) {
                    current.right = newNode;
                    return;
                } else {
                    q.add(current.right);
                }
            }
        }
    }

    /**
     * Pre-Order Traversal Recursive
     */
    public void preOrder() {
        if (null == root) {
            return;
        }
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.data + "->");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * Pre-Order Traversal Iterative
     */
    public void preOrderIterative() {
        if (null == root) {
            return;
        }
        preOrderIterative(root);
        System.out.println();
    }

    private void preOrderIterative(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode current = s.pop();
            System.out.print(current.data + "->");
            if (null != current.right) {
                s.push(current.right);
            }
            if (null != current.left) {
                s.push(current.left);
            }
        }
    }

    /**
     * In Order Traversal
     */
    public void inOrder() {
        if (null == root) {
            return;
        }
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + "->");
        inOrder(root.right);
    }

    public void inOrderIterative() {
        if (null == root) {
            return;
        } else {
            inOrderIterative(root);
        }
        System.out.println();
    }

    private void inOrderIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            while (null != root.left) {
                s.push(root.left);
                root = root.left;
            }
            TreeNode current = s.pop();
            System.out.print(current.data + "->");
            if (null != current.right) {
                s.push(current.right);
                while (null != current.right.left) {
                    s.push(current.right.left);
                    current.right = current.right.left;
                }

            }
        }
        System.out.println();
    }

    /**
     * Post Order Traversal
     */
    public void postOrder() {
        if (null == root) {
            return;
        }
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "->");
    }

    /**
     * Level Order Traversal
     */
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

    /**
     * Size of the tree
     */
    public int size() {
        if (null == root) {
            return 0;
        }
        return size(root);
    }

    private int size(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int lSize = size(root.left);
        int rSize = size(root.right);
        int size = lSize + rSize + 1;
        return size;
    }

    /**
     * To find the sum of the tree nodes.
     */
    public int sum() {
        if (null == root) {
            return 0;
        }
        return sum(root);
    }

    private int sum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int lSum = sum(root.left);
        int rSum = sum(root.right);
        int sum = lSum + rSum + root.data;
        return sum;
    }

    /**
     * Find Max in the Tree
     */
    public int max() {
        if (null == root) {
            return Integer.MIN_VALUE;
        }
        return max(root);
    }

    private int max(TreeNode root) {
        if (null == root) {
            return Integer.MIN_VALUE;
        }
        int lMax = max(root.left);
        int rMax = max(root.right);

        int max = Math.max(root.data, Math.max(lMax, rMax));
        return max;
    }

    /**
     * Find Height of the tree
     */
    public int height() {
        if (null == root) {
            return 0;
        }
        return height(root);
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int height = Math.max(lHeight, rHeight) + 1;
        return height;
    }
}

public class TreeMain {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.insert(11);
        tree.preOrder();
        tree.preOrderIterative();
        tree.inOrder();
        tree.inOrderIterative();
        tree.postOrder();
        tree.levelOrderTraversal();
        System.out.println("Size of tree : " + tree.size());
        System.out.println("Sum of tree : " + tree.sum());
        System.out.println("Max of tree : " + tree.max());
        System.out.println("Height of tree : " + tree.height());
    }
}
