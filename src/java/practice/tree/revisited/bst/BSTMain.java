package practice.tree.revisited.bst;

import java.util.LinkedList;

public class BSTMain {
    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tree {
        TreeNode root;

        public void insert(int val) {
            if (null == root) {
                root = new TreeNode(val);
            } else {
                TreeNode current = root;
                while (true) {
                    if (val < current.val) {
                        if (current.left == null) {
                            current.left = new TreeNode(val);
                            break;
                        } else {
                            current = current.left;
                        }
                    } else {
                        if (current.right == null) {
                            current.right = new TreeNode(val);
                            break;
                        } else {
                            current = current.right;
                        }
                    }
                }
            }
        }

        public void levelOrderTraversal() {
            LinkedList<TreeNode> q = new LinkedList<>();
            q.addLast(root);
            while (!q.isEmpty()) {
                TreeNode current = q.removeFirst();
                System.out.print(current.val + "->");
                if (null != current.left) {
                    q.addLast(current.left);
                }
                if (null != current.right) {
                    q.addLast(current.right);
                }
            }
            System.out.println();
        }

        public boolean searchKey(int key){
            LinkedList<TreeNode> q = new LinkedList<>();
            q.addLast(root);
            while(!q.isEmpty()){
                TreeNode current = q.removeFirst();
                if(current.val == key){
                    return true;
                }else if (key < current.val){
                    if(null != current.left){
                        q.addLast(current.left);
                    }
                }else{
                    if(null != current.right){
                        q.addLast(current.right);
                    }
                }
            }
            return false;
        }

        public int ceil(int key){
            int ceil =-1;
            while(null != root){
                if(root.val == key){
                    ceil = root.val;
                    return ceil;
                }
                if(key > root.val){
                    root = root.right;
                }else{
                    ceil = root.val;
                    root = root.left;
                }
            }
            return ceil;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(12);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(6);
        tree.insert(13);
        tree.levelOrderTraversal();
        System.out.println(tree.searchKey(13));
        System.out.println(tree.searchKey(20));
        System.out.println(tree.ceil(9));
    }
}
