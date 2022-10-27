class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> p1 = new ArrayList<>();
        List<int[]> p2 = new ArrayList<>();
        for(int i=0;i<n*n;i++){
            if(img1[i/n][i%n] ==1){
                p1.add(new int[]{i/n, i%n});
            }
            if(img2[i/n][i%n] ==1){
                p2.add(new int[]{i/n, i%n});
            }            
        }
        Map<String, Integer> m = new HashMap<>();
        int res = 0;
        for(int[] a : p1){
            for(int[] b : p2){
                String key = (a[0]-b[0]) +" "+(a[1]-b[1]);
                m.put(key, m.getOrDefault(key, 0)+1);
                res = Math.max(res, m.get(key));
            }
        }
        return res;
    }
}