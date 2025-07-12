public class consbtPretoIn {
    
}
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
    Map<Integer,Integer> indexidxmap;
    int preorderidx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderidx=0;
        indexidxmap = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            indexidxmap.put(inorder[i],i);
        }
        return helper (preorder,0,inorder.length-1);
    }
    private TreeNode helper(int []preorder ,int start,int end){
        if(start>end)return null;
        int rootval = preorder[preorderidx++];
        TreeNode root = new TreeNode(rootval);
        int inIndex = indexidxmap.get(rootval);
        root.left = helper(preorder,start,inIndex-1);
        root.right = helper(preorder , inIndex+1,end);
        return root;
    }
}