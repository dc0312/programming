package practice.tree.revisited;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(1);
        treeNew.root.leftChild = new TreeNode(2);
        treeNew.root.rightChild = new TreeNode(3);
        treeNew.root.rightChild.leftChild = new TreeNode(4);
        treeNew.root.rightChild.rightChild = new TreeNode(5);

        treeNew.zigZagTraversal();

    }

    static class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree {
        TreeNode root;

        public void zigZagTraversal() {
            if (null == root) {
                return;
            } else {
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.addLast(root);
                ArrayList<Integer> ans = new ArrayList<>();
                boolean flag = false;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    int arr[] = new int[size];

                    for (int i = 0; i < size; i++) {
                        TreeNode temp = queue.removeFirst();
                        int index = !flag ? i : size - i - 1;
                        arr[index] = temp.val;
                        if (null != temp.leftChild) {
                            queue.addLast(temp.leftChild);
                        }
                        if (null != temp.rightChild) {
                            queue.addLast(temp.rightChild);
                        }
                    }
                    for (int i : arr) {
                        ans.add(i);
                    }
                    flag = !flag;
                }
                System.out.println(Arrays.toString(ans.toArray()));
            }
        }


    }

}
