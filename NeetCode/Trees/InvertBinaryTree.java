package Trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {


        if (root != null && (root.left != null || root.right != null)) {

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            if (root.left != null) {
                invertTree(root.left);
            }
            if (root.right != null) {
                invertTree(root.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));


        printTree(invertTree(root), "", false);
    }

    public static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) {
            return;
        }

        System.out.print(prefix);
        System.out.print(isLeft ? "├── " : "└── ");
        System.out.println(root.val);

        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }
}
