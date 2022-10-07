class MyCalendarThree {
    TreeMap<Integer, Integer> m;
    public MyCalendarThree() {
        m = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        m.put(start, m.getOrDefault(start, 0)+1);
        m.put(end, m.getOrDefault(end, 0)-1);
        int k = 0, curr =0;
        for(int v : m.values()){
            curr += v;
            k = Math.max(k, curr);
        }
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */