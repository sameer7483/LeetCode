class Solution {
    public int brokenCalc(int val, int target) {
        //even divide or add one
        // odd add 1
        int count = 0;
        
        while(val != target){
            if(val > target ){
                count += val - target;
                return count;
            }
            if(target %2 != 0){
                target +=1;
                count++;
            }
            else{
                target = target/2;
                count++;
            }
                
            
        }
        return count;
    }
}