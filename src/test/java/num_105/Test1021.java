package num_105;

import org.junit.jupiter.api.Test;

public class Test1021 {

    @Test
    public void testCase01() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return partition(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     *
     * @param rootIndex as a root in the calculation
     * @param left (@include)
     * @param right (@include)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode partition(int rootIndex, int left, int right, int[] preorder, int[] inorder) {
        if (rootIndex > preorder.length - 1 || left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex]);

        int index = 0;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }

        int countOfLeftChildren = index - left;

        root.left = partition(rootIndex + 1, left, index, preorder, inorder);
        root.right = partition(rootIndex + countOfLeftChildren + 1, index, right, preorder, inorder);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
  }
}
