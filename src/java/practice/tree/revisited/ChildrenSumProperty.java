package practice.tree.revisited;

import java.util.LinkedList;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(40);
        treeNew.root.leftChild = new TreeNode(10);
        treeNew.root.leftChild.leftChild = new TreeNode(2);
        treeNew.root.leftChild.rightChild = new TreeNode(5);
        treeNew.root.rightChild = new TreeNode(20);
        treeNew.root.rightChild.leftChild = new TreeNode(30);
        treeNew.root.rightChild.rightChild = new TreeNode(40);
        treeNew.childrenSum();
        treeNew.levelOrderTraversal();

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

        public void childrenSum() {
            if (null == root) {
                return;
            } else {
                childrenSum(root);
            }

        }

        private void childrenSum(TreeNode root) {
            if (null == root) {
                return;
            }
            int child = 0;
            if (null != root.leftChild) {
                child += root.leftChild.val;
            }
            if (null != root.rightChild) {
                child += root.rightChild.val;
            }

            if (child >= root.val) {
                root.val = child;
            } else {
                if (null != root.leftChild) {
                    root.leftChild.val = root.val;
                }
                if (null != root.rightChild) {
                    root.rightChild.val = root.val;
                }
            }

            childrenSum(root.leftChild);
            childrenSum(root.rightChild);

            int tot = 0;
            if (null != root.leftChild) {
                tot += root.leftChild.val;
            }
            if (null != root.rightChild) {
                tot += root.rightChild.val;
            }

            if (null != root.leftChild || null != root.rightChild) {
                root.val = tot;
            }
        }

        public void levelOrderTraversal() {
            if (null == root) {
                return;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.removeFirst();
                System.out.print(temp);
                if (null != temp.leftChild) {
                    queue.addLast(temp.leftChild);
                }
                if (null != temp.rightChild) {
                    queue.addLast(temp.rightChild);
                }
            }
        }
    }

}
