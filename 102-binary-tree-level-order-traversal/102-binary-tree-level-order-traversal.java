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

    public List<List<Integer>> levelOrder(TreeNode root){ 

        List<List<Integer>> outer = new ArrayList<>();   
        
        if(root == null){
            return outer;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
                        
        List<Integer> innerList = new ArrayList<>();
            
        int size = q.size();
            
            for(int i=0; i<size; i++){
                
               TreeNode current = q.poll();
                innerList.add(current.val);
                
                if(current.left != null)
                    q.add(current.left);
                
                if(current.right != null)
                    q.add(current.right);
            }
            outer.add(innerList);
        }
        return outer;
    }
}