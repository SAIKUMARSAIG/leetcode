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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        // return null;
        return build(map,inorder,0,n-1,preorder,0,n-1);
    }
    public static TreeNode build(Map<Integer,Integer> map,int[] inorder,int ioStart,int ioEnd,int[] preorder,int prStart,int prEnd){
        if (ioStart>ioEnd || prStart>prEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prStart]);
        int rootIdx = map.get(root.val);
        int numsAtLeft = rootIdx-ioStart;
//        root.left = build(map,inorder,ioStart,rootIdx-1,preorder,prStart+1,prEnd);
        root.left = build(map, inorder, ioStart, rootIdx - 1, preorder, prStart + 1, prStart + numsAtLeft);
        // root.right = build(map,inorder,numsAtLeft+1,ioEnd,preorder,prStart+rootIdx+1,prEnd);
        root.right = build(map,inorder,rootIdx+1,ioEnd,preorder,prStart+numsAtLeft+1,prEnd);
        return root;
    }
}