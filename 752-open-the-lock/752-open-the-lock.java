class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> d = new HashSet<>();
        for(String s : deadends)
            d.add(s);
        if(d.contains("0000"))
            return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int level =-1;
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        while(!q.isEmpty()){
            level++;
            int size = q.size();
        for(int j=0;j<size;j++){
            String p = q.poll();
            if(p.equals(target))
                return level;
            for(int i=0;i<4;i++){
                String digit =String.valueOf((Character.getNumericValue(p.charAt(i))+1)%10);
                String s1 = p.substring(0, i)+ digit + p.substring(i+1);
                digit = String.valueOf((Character.getNumericValue(p.charAt(i))-1+10)%10);
                String s2 = p.substring(0, i)+ digit + p.substring(i+1);
                if(!vis.contains(s1) && !d.contains(s1)){
                    q.add(s1);
                    vis.add(s1);
                }
                if(!vis.contains(s2) && !d.contains(s2)){
                    q.add(s2);
                    vis.add(s2);
                }
            }                
        }
    }
        return -1;
    }
}