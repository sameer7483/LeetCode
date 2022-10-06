
class TimeMap {
    Map<String, List<Pair<Integer, String>>> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> l = m.getOrDefault(key, new ArrayList<>());
        l.add(new Pair(timestamp, value));
        m.put(key, l);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key))
            return "";
        List<Pair<Integer, String>> l = m.get(key);
        int lo = 0, hi = l.size()-1;
        String res = "";
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            Pair<Integer, String> p= l.get(mid);
            if(p.getKey() > timestamp)
                hi = mid-1;
            else{
                res = p.getValue();
                lo = mid+1;   
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */