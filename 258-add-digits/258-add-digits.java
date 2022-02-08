class Solution {
    public int addDigits(int num) {
        while(num/10 > 0){
            int x= 0;
            while(num > 0){
                x+= num%10;
                num = num/10;
            }
            num = x;
        }
        return num;
    }
}