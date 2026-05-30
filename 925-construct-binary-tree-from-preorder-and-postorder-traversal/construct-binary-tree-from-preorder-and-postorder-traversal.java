/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = postorder.length;

        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }

        return construct(map, preorder, 0, n - 1, postorder, 0, n - 1, n);
    }

    public static TreeNode construct(Map<Integer, Integer> map, int[] preorder, int preStart, int preEnd,
            int[] postorder, int posStart, int posEnd, int n) {
        if (posStart > posEnd || preStart > preEnd || preStart > n - 1 || posEnd < 0 || posStart > n - 1
                || preEnd < 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int rootIdxForNextRoot = map.get(preorder[preStart + 1]);
        int numsAtLeftForNextRoot = rootIdxForNextRoot - posStart + 1;

        root.left = construct(map, preorder, preStart + 1, preStart + numsAtLeftForNextRoot, postorder, posStart,
                rootIdxForNextRoot, n);
        root.right = construct(map, preorder, preStart + numsAtLeftForNextRoot + 1, preEnd, postorder,
                rootIdxForNextRoot + 1, posEnd - 1, n);
        return root;
    }
}