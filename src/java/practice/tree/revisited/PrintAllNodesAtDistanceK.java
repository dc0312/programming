package practice.tree.revisited;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PrintAllNodesAtDistanceK {
    public static void main(String[] args) {
        Tree treeNew = new Tree();
        treeNew.root = new TreeNode(3);
        treeNew.root.leftChild = new TreeNode(5);
        treeNew.root.leftChild.leftChild = new TreeNode(6);
        treeNew.root.leftChild.rightChild = new TreeNode(2);
        treeNew.root.leftChild.rightChild.leftChild = new TreeNode(7);
        treeNew.root.leftChild.rightChild.rightChild = new TreeNode(4);
        treeNew.root.rightChild = new TreeNode(1);
        treeNew.root.rightChild.leftChild = new TreeNode(0);
        treeNew.root.rightChild.rightChild = new TreeNode(8);
        treeNew.printAllNodes(5, 2);
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

        public void printAllNodes(int val, int k) {
            HashMap<TreeNode, TreeNode> parentMap = makeParentMap(new HashMap<>());
            Set<TreeNode> visited = new HashSet<>();
            int distance = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode target = findTargetNode(root, val);
            queue.addLast(target);
            visited.add(target);
            while (!queue.isEmpty()) {
                int size = queue.size();
                if (distance == k) {
                    break;
                }
                distance++;
                while (size-- > 0) {
                    TreeNode temp = queue.removeFirst();
                    if (null != temp.leftChild && !visited.contains(temp.leftChild)) {
                        queue.addLast(temp.leftChild);
                        visited.add(temp.leftChild);
                    }
                    if (null != temp.rightChild && !visited.contains(temp.rightChild)) {
                        queue.addLast(temp.rightChild);
                        visited.add(temp.rightChild);
                    }
                    if (null != parentMap.get(temp) && !visited.contains(parentMap.get(temp))) {
                        queue.addLast(parentMap.get(temp));
                        visited.add(parentMap.get(temp));
                    }
                }
            }
            while (!queue.isEmpty()) {
                System.out.print(queue.poll());
            }
        }

        private TreeNode findTargetNode(TreeNode root, int val) {
            if (null == root) {
                return null;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.removeFirst();
                if (temp.val == val) {
                    return temp;
                }
                if (null != temp.leftChild) {
                    queue.addLast(temp.leftChild);
                }
                if (null != temp.rightChild) {
                    queue.addLast(temp.rightChild);
                }
            }
            return null;
        }

        private HashMap<TreeNode, TreeNode> makeParentMap(HashMap<TreeNode, TreeNode> parentMap) {
            if (root == null) {
                return parentMap;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.removeFirst();
                if (null != temp.leftChild) {
                    parentMap.put(temp.leftChild, temp);
                    queue.addLast(temp.leftChild);
                }
                if (null != temp.rightChild) {
                    parentMap.put(temp.rightChild, temp);
                    queue.addLast(temp.rightChild);
                }
            }
            return parentMap;
        }
    }

}
