package practice.tree.revisited;

public class MaxSumLeafToRoot {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root)
    {
        if(null == root){
            return 0;
        }
        int lAns = maxPathSum(root.left);
        int rAns = maxPathSum(root.right);

        return root.val + Math.max(lAns,rAns);
    }
}
