class MyCalendar {
    TreeMap<Integer, Integer> m;
    public MyCalendar() {
        m = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer fl = m.floorKey(start);
        if(fl != null && m.get(fl) > start)
            return false;
        Integer cl = m.ceilingKey(start);
        if(cl != null && end > cl)
            return false;
        m.put(start, end);
        return true;
            
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */