/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    public Node construct(int[][] g) { return build(0, 0, g.length - 1, g.length - 1, g);}

    Node build(int r1, int c1, int r2, int c2, int[][] g) {
        if (r1 > r2 || c1 > c2) return null;
        boolean isLeaf = true;
        int val = g[r1][c1];
        for (int i = r1; i <= r2; i++)
            for (int j = c1; j <= c2; j++)
                if (g[i][j] != val) {
                    isLeaf = false;
                    break;
                }
        if (isLeaf)
            return new Node(val == 1, true, null, null, null, null);
        int rowMid = (r1 + r2) / 2, colMid = (c1 + c2) / 2;
        return new Node(false, false,
            build(r1, c1, rowMid, colMid, g),//top left 
            build(r1, colMid + 1, rowMid, c2, g),//top right
            build(rowMid + 1, c1, r2, colMid, g),//bottom left 
            build(rowMid + 1, colMid + 1, r2, c2, g));//bottom right
    }
}