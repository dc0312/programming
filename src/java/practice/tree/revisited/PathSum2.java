package practice.tree.revisited;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static int sum;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root,22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> finalAnsList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        pathSum(root, targetSum, sum, finalAnsList, ans);
        return finalAnsList;
    }

    public static void pathSum(TreeNode root, int targetSum, int sum, List<List<Integer>> finalAnsList, List<Integer> ans) {

        if (null == root) {
            return;
        }
        ans.add(root.val);
        sum = sum + root.val;
        if (null == root.left && null == root.right) {
            if (sum == targetSum) {
                finalAnsList.add(new ArrayList<>(ans));
            }
            return;
        }

        if (null != root.left) {
            pathSum(root.left, targetSum, sum, finalAnsList, ans);
            ans.remove(ans.size() - 1);
        }

        if (null != root.right) {
            pathSum(root.right, targetSum, sum, finalAnsList, ans);
            ans.remove(ans.size() - 1);
        }


    }
}
