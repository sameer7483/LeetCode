class DetectSquares {
    Map<String, Integer> m;
    List<int[]> coords;
    public DetectSquares() {
        m = new HashMap<>();
        coords = new ArrayList<>();
    }
    
    public void add(int[] point) {
        coords.add(point);
        m.put(point[0]+"@"+point[1], m.getOrDefault(point[0]+"@"+point[1], 0)+1);
    }
    
    public int count(int[] point) {
        int sum = 0;
        int px = point[0];
        int py = point[1];
        for(int[] c : coords){
            int x = c[0];
            int y = c[1];
            if(px == x || py == y || Math.abs(px-x) != Math.abs(py-y))
                continue;
            sum += m.getOrDefault(x+"@"+py, 0) * m.getOrDefault(px+"@"+y, 0);
        }
        return sum;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */