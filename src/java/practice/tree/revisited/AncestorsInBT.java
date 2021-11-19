package practice.tree.revisited;

import java.util.ArrayList;
import java.util.List;

public class AncestorsInBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        List<Integer> treeNodeList = findAncestors(root, 7);
        treeNodeList.stream().forEach(System.out::println);
    }

    private static List<Integer> findAncestors(TreeNode root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        findAncestors(root, target, ans);
        return ans;
    }

    private static boolean findAncestors(TreeNode root, int target, ArrayList<Integer> ans) {
        if (null == root) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        if (findAncestors(root.left, target, ans) || findAncestors(root.right, target, ans)) {
            ans.add(root.val);
            return true;
        } else {
            return false;
        }
    }
}
