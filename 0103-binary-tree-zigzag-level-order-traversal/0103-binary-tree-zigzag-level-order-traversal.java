class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean ltor = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode p = q.poll();
                
                if(ltor)
                    l.add(p.val);
                else
                    l.add(0, p.val);
                if(p.left != null)
                    q.add(p.left);
                if(p.right != null)
                    q.add(p.right);                    
            }
            ltor = !ltor;
            res.add(l);
        }
        return res;        
    }
}