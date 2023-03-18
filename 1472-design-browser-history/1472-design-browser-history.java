class BrowserHistory {
    List<String> hist;
    int n;
    int curr;
    public BrowserHistory(String homepage) {
        hist = new ArrayList<>();
        hist.add(homepage);
        n = 0;
        curr = 0;
    }
    
    public void visit(String url) {
        if(curr+1 >= hist.size()){
            hist.add(url);
        }
        else{
            hist.set(curr+1, url);
        }
        
        curr++;
        n = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr-steps);
        return hist.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(n, curr+steps);
        return hist.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */