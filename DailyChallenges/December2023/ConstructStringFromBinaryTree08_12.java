package DailyChallenges.December2023;

import Trees.TreeNode;

public class ConstructStringFromBinaryTree08_12 {

    public static String tree2str(TreeNode root) {

        StringBuilder result = new StringBuilder();
        result.append(root.val);

        if (root.left != null) {
            result.append("(").append(tree2str(root.left)).append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                result.append("()");
            }
            result.append("(").append(tree2str(root.right)).append(")");
        }

        return result.toString();
    }

}
