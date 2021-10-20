package practice.tree.revisited;

import java.util.LinkedList;

public class SerializeDeserializeTree {
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

        public String serialize() {
            if (null == root) {
                return "#";
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(root.val);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.removeFirst();
                if (null != temp.leftChild) {
                    queue.add(temp.leftChild);
                    stringBuilder.append(temp.leftChild.val);
                } else {
                    stringBuilder.append("#");
                }
                if (null != temp.rightChild) {
                    queue.add(temp.rightChild);
                    stringBuilder.append(temp.rightChild.val);
                } else {
                    stringBuilder.append("#");
                }
            }
            return stringBuilder.toString();
        }

        public TreeNode deserialize(String s) {
            String[] parts = s.split("");
            TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            for (int i = 1; i < parts.length; i++) {
                TreeNode temp = queue.poll();
                if (!"#".equals(parts[i])) {
                    temp.leftChild = new TreeNode(Integer.parseInt(parts[i]));
                    queue.addLast(temp.leftChild);
                    i++;
                }
                if (!"#".equals(parts[i])) {
                    temp.rightChild = new TreeNode(Integer.parseInt(parts[i]));
                    queue.addLast(temp.rightChild);
                }
            }
            return root;
        }

        public void levelOrderTraversal() {
            if (null == root) {
                return;
            } else {
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.addLast(root);
                while (!queue.isEmpty()) {
                    TreeNode current = queue.removeFirst();
                    System.out.print(current.val + "->");
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
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);
        tree.root.leftChild = new TreeNode(2);
        tree.root.leftChild.leftChild = new TreeNode(4);
        tree.root.leftChild.leftChild.rightChild = new TreeNode(6);
        tree.root.rightChild = new TreeNode(3);
        tree.root.rightChild.leftChild = new TreeNode(5);
        tree.root.rightChild.leftChild.leftChild = new TreeNode(7);
        tree.root.rightChild.leftChild.rightChild = new TreeNode(8);
        String ser = tree.serialize();
        System.out.println(ser);

        Tree newTree = new Tree();
        newTree.root = tree.deserialize(ser);
        newTree.levelOrderTraversal();
    }
}
