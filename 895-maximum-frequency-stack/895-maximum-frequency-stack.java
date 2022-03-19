class Pair{
    public int freq;
    public int pos;
    public int num;
    public Pair(int freq, int pos, int num){
        this.freq = freq;
        this.pos = pos;
        this.num = num;
    }
}
class FreqStack {

    PriorityQueue<Pair> q;
    Map<Integer, Integer> m;
    int i;
    public FreqStack() {
        q = new PriorityQueue<Pair>((p1, p2)-> p1.freq == p2.freq ? p2.pos-p1.pos : p2.freq - p1.freq);
        m = new HashMap<>();
        i=0;
    }
    
    public void push(int val) {
        int  t= m.getOrDefault(val, 0);
        m.put(val, t+1);
        q.add(new Pair(t+1, i++, val));
    }
    
    public int pop() {
        Pair p = q.poll();
        int  t= m.getOrDefault(p.num, 0);
        m.put(p.num, t-1);        
        return p.num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */