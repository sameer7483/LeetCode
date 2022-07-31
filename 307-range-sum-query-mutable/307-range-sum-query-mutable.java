class SegmentTreeNode {
    int start;
    int end;
    int val;
    SegmentTreeNode left;
    SegmentTreeNode right;
    public SegmentTreeNode(){};
    public SegmentTreeNode(int start, int end, int val){
        this.start = start;
        this.end = end;
        this.val = val;
    }
}


class NumArray {
    SegmentTreeNode root;
    int[] numArr;
    public NumArray(int[] nums) {
        root = makeSegmentTree(nums, 0 , nums.length-1);
        numArr = nums;
        
    }
    public void printRoot(SegmentTreeNode root){
        if(root == null)
            return;
        printRoot(root.left);
        System.out.println(root.val +" "+ root.start + "->" + root.end);
        printRoot(root.right);
    }
    
    public void update(int index, int val) {
        updateSt(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }
    public SegmentTreeNode makeSegmentTree(int[] nums, int lo, int hi){
        if(lo > hi)
            return null;
        if(lo == hi)
            return new SegmentTreeNode(lo, hi, nums[lo]);
        int mid = lo + (hi-lo)/2;
        SegmentTreeNode root = new SegmentTreeNode();
        root.start = lo;
        root.end = hi;
        SegmentTreeNode left = makeSegmentTree(nums, lo, mid);
        SegmentTreeNode right = makeSegmentTree(nums, mid+1, hi);
        root.val = (left != null ? left.val : 0) + (right != null ? right.val : 0); 
        root.left = left;
        root.right =right;
        return root;
    }
    
    public int getSum(SegmentTreeNode root, int lo, int hi){
        if (root == null)
            return 0;
        if(root.start >= lo && root.end <= hi){
            return root.val;
        }
        else if(root.end < lo || root.start > hi){
            return 0;
        }
        else
            return getSum(root.left, lo, hi) + getSum(root.right, lo, hi);
    } 
    
    public int updateSt(SegmentTreeNode root, int idx, int val){
        if(root == null)
            return 0;
        if(root.start == root.end){
            root.val = val;
            return val;
        }
        int mid = (root.start + root.end)/2;
        if(idx <= mid){
            updateSt(root.left, idx, val);
        }
        else{
            updateSt(root.right, idx, val);
        }
        root.val = root.left.val + root.right.val;
        return root.val;
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */