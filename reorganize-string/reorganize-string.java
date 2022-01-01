class Pair{
    Character c;
    int count;
    public Pair(Character c, int count){
        this.c = c;
        this.count = count;
    }
}

class Solution {
    public String reorganizeString(String s) {
        if(s.length() ==1)
            return s;
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int count = m.getOrDefault(s.charAt(i), 0);
            m.put(s.charAt(i), count+1);
        }
        if(m.size() == 1)
            return "";
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> b.count - a.count);
        for(Map.Entry<Character, Integer> entry : m.entrySet()){
            q.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder("");
        while(q.size() > 1){
            Pair p1 = q.poll();
            Pair p2 = q.poll();
            sb.append(p1.c);
            sb.append(p2.c);
            p1.count = p1.count -1;
            p2.count = p2.count -1;
            if(p1.count > 0)
                q.add(p1);
            if(p2.count > 0)
                q.add(p2);
        }
        // System.out.println(sb.toString());
        if(!q.isEmpty()){
            Pair p = q.poll();
            if(sb.charAt(sb.length()-1) == p.c || p.count >1)
                return "";
            else
                sb.append(p.c);
        }
            return sb.toString();
    }
}