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
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,0,n-1,postorder,0,n-1,map);
    }

    public static TreeNode build(int[] inorder,int ioStrat,int ioEnd,int[] postorder,int poStart,int poEnd,Map<Integer,Integer> map){
        if (ioStrat>ioEnd || poStart>poEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[poEnd]);
        int rootIdx = map.get(postorder[poEnd]);
        int numsAtLeft = rootIdx-ioStrat;

        root.left = build(inorder,ioStrat,rootIdx-1,postorder,poStart,poStart+numsAtLeft-1,map);
        root.right = build(inorder,rootIdx+1,ioEnd,postorder,poStart+numsAtLeft,poEnd-1,map);
        return root;
    }
}