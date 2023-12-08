package Trees;

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        int maxDepthLeft = 1 + maxDepth(root.left);
        int maxDepthRight = 1 + maxDepth(root.right);

        return Math.max(maxDepthLeft, maxDepthRight);
    }

}
