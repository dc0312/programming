package practice.tree.revisited;

import java.util.LinkedList;

public class OddEvenLevelDiff {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right = new TreeNode(30);

        System.out.println(getLevelDiff(root));
    }

    private static int getLevelDiff(TreeNode root) {
        int evenSum = 0;
        int oddSum = 0;
        boolean flag = true;

        LinkedList<TreeNode> q = new LinkedList<>();

        q.addLast(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = q.removeFirst();
                if (flag) {
                    oddSum += current.val;
                } else {
                    evenSum += current.val;
                }
                if (null != current.left) {
                    q.addLast(current.left);
                }
                if (null != current.right) {
                    q.addLast(current.right);
                }
            }
            flag = !flag;
        }

        return oddSum -evenSum;
    }
}
