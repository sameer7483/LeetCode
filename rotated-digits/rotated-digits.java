class Solution {
    Map<Integer, Integer> m;
    public int rotatedDigits(int n) {
        m = new HashMap<>();
        m.put(2, 5);
        m.put(5, 2);
        m.put(6, 9);
        m.put(9, 6);
        m.put(1, 1);
        m.put(0, 0);   
        m.put(8, 8); 
        int count = 0;
        for(int i=1;i<=n;i++){
            if(isDifferent(i))
                count++;
        }
        return count;
        
    }
    
    public boolean isDifferent(int x){
        int temp = x;
        int newNum = 0;
        int i=0;
        while(temp > 0){
            int a = temp % 10;
            if(!m.containsKey(a))
                return false;
            newNum += m.get(a) * (int)Math.pow(10, i);
            i++;
            temp = temp/10;
        }
        if(newNum != x)
            return true;
        else
            return false;
    }
}