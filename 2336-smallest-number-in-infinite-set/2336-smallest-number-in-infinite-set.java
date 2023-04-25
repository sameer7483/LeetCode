class SmallestInfiniteSet {
    SortedSet<Integer> q;
    int count;
    public SmallestInfiniteSet() {
        count = 1;
        q = new TreeSet<>();
        
    }
    
    public int popSmallest() {
        if(q.isEmpty())
            return count++;
        int res =  q.first();
        q.remove(res);
        return res;
    }
    
    public void addBack(int num) {
        if(num >= count)
            return;
        q.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */